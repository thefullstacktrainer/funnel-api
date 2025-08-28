package com.example.funnel.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FunnelEventListener {
    private static final Logger logger = LoggerFactory.getLogger(FunnelEventListener.class);

    @EventListener
    public void onFunnelCreated(FunnelCreatedEvent ev) {
        logger.info("FunnelCreated event received for id={} at {}", ev.getFunnelId(), ev.getTimestamp());
        // in real service you'd push to Kafka/RabbitMQ or another microservice
    }
}
