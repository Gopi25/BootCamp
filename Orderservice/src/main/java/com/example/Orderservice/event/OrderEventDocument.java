package com.example.Orderservice.event;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "order_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEventDocument {
    @Id
    private String id;
    private String orderId;
    private String product;
    private Integer quantity;
    private Double price;
    private String eventType;
}
