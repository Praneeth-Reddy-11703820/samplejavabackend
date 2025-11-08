package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection ="order_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {
    @Id
    private String id;

    private String productName;
    private int quantity;
    private double price;

    // Many items belong to one order
   // @DBRef
   // private Order order;

    // Optional: directly reference user (helps for queries)
    //@DBRef
    private User user;



}
