package com.example.kafka_avro_demo.DTO;

import lombok.Data;

@Data
public class OrderRequest {
    private String orderId;
    private String customerId;
    private double totalAmount;
}
