package com.supplyflow.supplyflowapplication.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_movements")
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private MovementType type;

    private int quantity;
    private LocalDateTime movementDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public StockMovement() {
        this.movementDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public MovementType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getMovementDate() {
        return movementDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMovementDate(LocalDateTime movementDate) {
        this.movementDate = movementDate;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
