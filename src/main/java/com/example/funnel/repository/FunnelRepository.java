package com.example.funnel.repository;

import com.example.funnel.model.Funnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunnelRepository extends JpaRepository<Funnel, Long> {
}
