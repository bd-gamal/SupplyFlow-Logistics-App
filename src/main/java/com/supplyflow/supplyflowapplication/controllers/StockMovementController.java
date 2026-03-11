package com.supplyflow.supplyflowapplication.controllers;

import com.supplyflow.supplyflowapplication.entities.MovementType;
import com.supplyflow.supplyflowapplication.entities.StockMovement;
import com.supplyflow.supplyflowapplication.services.ProductService;
import com.supplyflow.supplyflowapplication.services.StockMovementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movements")
public class StockMovementController {
    private final StockMovementService movementService;
    private final ProductService productService;

    public StockMovementController(StockMovementService movementService, ProductService productService) {
        this.movementService = movementService;
        this.productService = productService;
    }

    @GetMapping
    public String listMovements(Model model) {
        model.addAttribute("movements", movementService.getAllMovements());
        return "movements/list";
    }

    @GetMapping("/new")
    public String showMovementsForm(Model model) {
        model.addAttribute("movements", new StockMovement());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("types", MovementType.values());
        return "movements/form";
    }

    @PostMapping("/save")
    public String saveMovement(@ModelAttribute("movement") StockMovement movement, Model model ) {
        try {
            movementService.registerMovement(movement);
            return "redirect:/movements";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("products", productService.getAllProducts());
            model.addAttribute("types", MovementType.values());
            return "movements/form";
        }
    }
}
