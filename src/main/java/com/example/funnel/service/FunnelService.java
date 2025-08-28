package com.example.funnel.service;

import com.example.funnel.dto.FunnelRequest;
import com.example.funnel.dto.StageRequest;
import com.example.funnel.model.Funnel;
import com.example.funnel.model.Stage;
import com.example.funnel.repository.FunnelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FunnelService {

    private final FunnelRepository funnelRepository;

    public FunnelService(FunnelRepository funnelRepository) {
        this.funnelRepository = funnelRepository;
    }

    public Funnel createFunnel(FunnelRequest request) {
        if (request.getStages() == null || request.getStages().size() != 5) {
            throw new IllegalArgumentException("Funnel must contain exactly 5 stages");
        }

        Set<Integer> orders = request.getStages().stream()
                .map(StageRequest::getOrder)
                .collect(Collectors.toSet());
        if (orders.size() != 5) {
            throw new IllegalArgumentException("Stages must have unique orders");
        }

        Funnel funnel = new Funnel();
        funnel.setName(request.getName());
        funnel.setDescription(request.getDescription());
        funnel.setFilter(request.getFilter());
        funnel.setCreatedAt(LocalDateTime.now());
        funnel.setStatus("CREATED");

        List<Stage> stages = request.getStages().stream().map(s -> {
            Stage stage = new Stage();
            stage.setStageOrder(s.getOrder());
            stage.setName(s.getName());
            stage.setType(s.getType());
            stage.setFunnel(funnel);
            return stage;
        }).collect(Collectors.toList());

        funnel.setStages(stages);
        return funnelRepository.save(funnel);
    }

    public List<Funnel> getAllFunnels() {
        return funnelRepository.findAll();
    }

    public Funnel getFunnelById(Long id) {
        return funnelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funnel not found with id " + id));
    }
}
