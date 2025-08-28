package com.example.funnel.controller;

import com.example.funnel.dto.FunnelRequest;
import com.example.funnel.model.Funnel;
import com.example.funnel.service.FunnelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funnels")
public class FunnelController {

    private final FunnelService funnelService;

    public FunnelController(FunnelService funnelService) {
        this.funnelService = funnelService;
    }

    @PostMapping
    public ResponseEntity<Funnel> createFunnel(@RequestBody FunnelRequest request) {
        Funnel funnel = funnelService.createFunnel(request);
        return ResponseEntity.status(201).body(funnel);
    }

    @GetMapping
    public ResponseEntity<List<Funnel>> getAllFunnels() {
        return ResponseEntity.ok(funnelService.getAllFunnels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funnel> getFunnelById(@PathVariable Long id) {
        return ResponseEntity.ok(funnelService.getFunnelById(id));
    }
}
