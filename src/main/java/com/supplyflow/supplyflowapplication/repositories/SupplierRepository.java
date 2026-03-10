package com.supplyflow.supplyflowapplication.repositories;

import com.supplyflow.supplyflowapplication.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
