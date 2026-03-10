package com.supplyflow.supplyflowapplication.services;

import com.supplyflow.supplyflowapplication.entities.MovementType;
import com.supplyflow.supplyflowapplication.entities.Product;
import com.supplyflow.supplyflowapplication.entities.StockMovement;
import com.supplyflow.supplyflowapplication.repositories.ProductRepository;
import com.supplyflow.supplyflowapplication.repositories.StockMovementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockMovementService {
    private final StockMovementRepository movementRepository;
    private final ProductRepository productRepository;

    public StockMovementService(StockMovementRepository movementRepository, ProductRepository productRepository) {
        this.movementRepository = movementRepository;
        this.productRepository = productRepository;
    }

    public List<StockMovement> getAllMovements() {
        return movementRepository.findAll();
    }

    @Transactional
    public void registerMovement(StockMovement movement) {
        Product product = movement.getProduct();

        if (movement.getType() == MovementType.IN) {
            product.setQuantity(product.getQuantity() + movement.getQuantity());
        } else if (movement.getType() == MovementType.OUT) {
            if (product.getQuantity() < movement.getQuantity()) {
                throw new RuntimeException("Stock insuffisant pour cette sortie !");
            }
            product.setQuantity(product.getQuantity() - movement.getQuantity());
        }

        productRepository.save(product);
        movementRepository.save(movement);
    }
}
