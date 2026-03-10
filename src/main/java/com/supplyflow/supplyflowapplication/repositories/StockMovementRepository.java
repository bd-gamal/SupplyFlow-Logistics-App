package com.supplyflow.supplyflowapplication.repositories;

import com.supplyflow.supplyflowapplication.entities.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement, Integer> {
}
