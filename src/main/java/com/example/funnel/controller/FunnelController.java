package com.example.funnel.controller;

import com.example.funnel.dto.FunnelRequest;
import com.example.funnel.model.Funnel;
import com.example.funnel.service.FunnelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funnels")
public class FunnelController {
    private static final Logger logger = LoggerFactory.getLogger(FunnelController.class);
    private final FunnelService service;

    public FunnelController(FunnelService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Funnel> create(@RequestBody FunnelRequest req) {
        logger.info("Received create funnel request: name={}", req.getName());
        Funnel created = service.createFunnel(req);
        logger.info("Funnel created id={}", created.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
