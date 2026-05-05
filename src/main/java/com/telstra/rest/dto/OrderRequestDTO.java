package com.telstra.rest.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {


    @NotBlank (message = "Customer name is required")
    @Size(min = 3, max = 50, message = "Customer name must be between 3 and 50 characters")
    private String customerName;


    @NotBlank(message = "Product code is required")
    private String productCode;


    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 100, message = "Quantity cannot be more than 100")
    private Integer quantity;

}