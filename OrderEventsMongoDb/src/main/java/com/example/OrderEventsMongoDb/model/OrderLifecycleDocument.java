package com.example.OrderEventsMongoDb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "order_lifecycle")
public class OrderLifecycleDocument {
    @Id
    private String id;
    private String orderId;
    private List<OrderEvent> events = new ArrayList<>();;

    @Data
    public static class OrderEvent {
        private String type;       // e.g. "orderPlaced", "orderPaid", "orderShipped"
        private Instant timestamp; // event time
        private Object payload;    // schema-less additional data
    }
}
