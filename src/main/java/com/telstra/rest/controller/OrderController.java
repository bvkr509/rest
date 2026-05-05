package com.telstra.rest.controller;

import com.telstra.rest.dto.OrderRequestDTO;
import com.telstra.rest.entity.Order;
import com.telstra.rest.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/orders/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/serviceOrder")
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody OrderRequestDTO dto) {
        Order saved = orderService.createOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "id", saved.getId(),
                "message", "Order created successfully"
        ));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable UUID id) {
        return ResponseEntity
                .ok(orderService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update( UUID id,
                                                      @Valid @RequestBody OrderRequestDTO dto) {
        Order updated = orderService.updateOrder(id, dto);

        return ResponseEntity.ok(Map.of(
                "message", "Order updated successfully",
                "id", updated.getId()
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable UUID id) {
        orderService.deleteOrder(id);

        return ResponseEntity.ok(Map.of(
                "message", "Order deleted successfully",
                "id", id
        ));
    }
}