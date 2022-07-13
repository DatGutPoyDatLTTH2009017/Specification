package com.example.demo.entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table (name = "products")
public class Product {
    private int id;
    private String Name;
    private String Description;
    private String Gender;
    private String Color;
    private int Size;
    private double Price;
    private LocalDateTime CreatedAt;
    private int status;
}
