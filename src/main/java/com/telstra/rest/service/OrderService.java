package com.telstra.rest.service;

import com.telstra.rest.dto.OrderRequestDTO;
import com.telstra.rest.entity.Order;
import com.telstra.rest.exception.DatabaseException;
import com.telstra.rest.exception.OrderNotFoundException;
import com.telstra.rest.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(OrderRequestDTO dto) {
        log.info("Creating new order");

        try {
            Order order = new Order();
            order.setCustomerName(dto.getCustomerName());
            order.setProductCode(dto.getProductCode());
            order.setQuantity(dto.getQuantity());

            // Save to DB
            Order saved = orderRepository.save(order);

            log.info("Order created successfully with id: {}", saved.getId());
            return saved;

        } catch (DataAccessException e) {
            log.error("DB error order: {}", e.getMessage(), e);
            throw new DatabaseException("DB error while creating order", e);
        } catch (Exception e) {
            log.error("Unexpected error while creating order: {}", e.getMessage(), e);
            throw new RuntimeException("Unexpected error while creating order", e);
        }
    }

    public Order getOrderById(UUID id) {
        log.info("Fetching order by id: {}", id);

        try {
            return orderRepository.findById(id)
                    .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
        } catch (DataAccessException e) {
            log.error("DB error while fetching order: {}", e.getMessage(), e);
            throw new DatabaseException("DB error while fetching order", e);
        }
    }

    public Order updateOrder(UUID id, OrderRequestDTO dto) {
        log.info("Updating order by id: {}", id);

        try {
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));

            order.setCustomerName(dto.getCustomerName());
            order.setProductCode(dto.getProductCode());
            order.setQuantity(dto.getQuantity());

            Order updated = orderRepository.save(order);

            log.info("Order updated successfully with id: {}", updated.getId());
            return updated;

        } catch (DataAccessException e) {
            log.error("DB error while updating order: {}", e.getMessage(), e);
            throw new DatabaseException("DB error while updating order", e);
        } catch (Exception e) {
            log.error("Unexpected error while updating order: {}", e.getMessage(), e);
            throw new RuntimeException("Unexpected error while updating order", e);
        }
    }


    public void deleteOrder(UUID id) {
        log.info("Deleting order by id: {}", id);

        try {
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));

            orderRepository.delete(order);

            log.info("Order deleted successfully with id: {}", id);

        } catch (DataAccessException e) {
            log.error("DB error while deleting order: {}", e.getMessage(), e);
            throw new DatabaseException("DB error while deleting order", e);
        } catch (Exception e) {
            log.error("Unexpected error while deleting order: {}", e.getMessage(), e);
            throw new RuntimeException("Unexpected error while deleting order", e);
        }
    }

}
