package com.supplyflow.supplyflowapplication.services;

import com.supplyflow.supplyflowapplication.entities.Supplier;
import com.supplyflow.supplyflowapplication.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }
}
