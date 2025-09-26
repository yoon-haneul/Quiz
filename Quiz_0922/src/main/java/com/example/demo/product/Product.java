package com.example.demo.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String description;

    @Lob 
    private String detailedDescription;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private String originalOwner; 

    private String magicalPower; 

    @Column(nullable = false)
    private Integer emotionLevel; 

    @Column(nullable = false)
    private Integer rarityScore; 

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemoryType memoryType; 


    private String imageUrls;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Builder
    public Product(Long id, String name, String description, String detailedDescription, Integer price, Integer stock, String originalOwner, String magicalPower, Integer emotionLevel, Integer rarityScore, MemoryType memoryType, String imageUrls) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.detailedDescription = detailedDescription;
        this.price = price;
        this.stock = stock;
        this.originalOwner = originalOwner;
        this.magicalPower = magicalPower;
        this.emotionLevel = emotionLevel;
        this.rarityScore = rarityScore;
        this.memoryType = memoryType;
        this.imageUrls = imageUrls;
    }
}