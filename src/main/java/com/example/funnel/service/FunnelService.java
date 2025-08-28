package com.example.funnel.service;

import com.example.funnel.dto.*;
import com.example.funnel.model.*;
import com.example.funnel.exception.*;
import com.example.funnel.event.*;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import io.micrometer.core.instrument.MeterRegistry;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FunnelService {

    private final Map<String, Funnel> store = new ConcurrentHashMap<>();
    private final ApplicationEventPublisher publisher;
    private final MeterRegistry meterRegistry; // for metrics (actuator + micrometer)

    public FunnelService(ApplicationEventPublisher publisher, MeterRegistry meterRegistry) {
        this.publisher = publisher;
        this.meterRegistry = meterRegistry;
    }

    public Funnel createFunnel(FunnelRequest req) {
        validate(req);

        String id = "funnel_" + UUID.randomUUID();
        Funnel f = new Funnel();
        f.setId(id);
        f.setName(req.getName());
        f.setDescription(req.getDescription());
        f.setFilter(req.getFilter());
        f.setStatus("CREATED");
        f.setCreatedAt(Instant.now());

        List<Stage> stages = new ArrayList<>();
        for (StageRequest sr : req.getStages()) {
            Stage s = new Stage();
            s.setOrder(sr.getOrder());
            s.setName(sr.getName());
            s.setType(sr.getType());
            stages.add(s);
        }
        f.setStages(stages);

        store.put(id, f);

        // metric - increments a named counter (requires actuator + micrometer on classpath)
        try { meterRegistry.counter("funnels.created").increment(); } catch (Exception ignored) {}

        // publish event
        publisher.publishEvent(new FunnelCreatedEvent(this, id, Instant.now()));

        return f;
    }

    private void validate(FunnelRequest req) {
        if (req.getStages() == null || req.getStages().size() != 5) {
            throw new InvalidInputException("Funnel must contain exactly 5 stages");
        }
        // optional: check for unique orders 1..5
        Set<Integer> orders = new HashSet<>();
        for (StageRequest s : req.getStages()) {
            orders.add(s.getOrder());
        }
        if (orders.size() != 5) {
            throw new InvalidInputException("Stages must have unique orders");
        }
    }
}
