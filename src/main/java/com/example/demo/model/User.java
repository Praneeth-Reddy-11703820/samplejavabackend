package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String name;
    private String email;
    private int age;
    private String role;      // Example: "USER" or "ADMIN"
    private String address;   // Example: "123 Main St"
    private String phone;
}
