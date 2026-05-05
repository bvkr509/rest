package com.telstra.rest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String customerName;
    private String productCode;
    private int quantity;

    private String status;
    private Instant createdAt;

    @PrePersist
    public void prePersist() {
        if (this.status == null) this.status = "CREATED";
        if (this.createdAt == null) this.createdAt = Instant.now();
    }

}