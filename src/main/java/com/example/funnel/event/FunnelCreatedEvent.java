package com.example.funnel.event;

import java.time.Instant;

public class FunnelCreatedEvent {
    private final Object source;
    private final String funnelId;
    private final Instant timestamp;

    public FunnelCreatedEvent(Object source, String funnelId, Instant timestamp) {
        this.source = source;
        this.funnelId = funnelId;
        this.timestamp = timestamp;
    }
    public String getFunnelId() { return funnelId; }
    public Instant getTimestamp() { return timestamp; }
}
