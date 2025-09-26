package com.example.demo.product;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class ProductDto {

    @Getter
    @Builder
    public static class ProductListDto {
        private Long id;
        private String name;
        private String description;
        private int price;
        private int stock;
        private String originalOwner;
        private int emotionLevel;
        private int rarityScore;
        private MemoryType memoryType;
        private String imageUrls; // 대표 이미지

        public static ProductListDto from(Product product) {
            return ProductListDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .originalOwner(product.getOriginalOwner())
                    .emotionLevel(product.getEmotionLevel())
                    .rarityScore(product.getRarityScore())
                    .memoryType(product.getMemoryType())
                    .imageUrls(product.getImageUrls()) // 간단하게 전체를 넘기거나 첫번째 URL만 파싱해서 넘길 수 있음
                    .build();
        }
    }

    @Getter
    @Builder
    public static class ProductDetailDto {
        private Long id;
        private String name;
        private String description;
        private String detailedDescription;
        private int price;
        private int stock;
        private String originalOwner;
        private String magicalPower;
        private int emotionLevel;
        private int rarityScore;
        private MemoryType memoryType;
        private String imageUrls;

        public static ProductDetailDto from(Product product) {
            return ProductDetailDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .detailedDescription(product.getDetailedDescription())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .originalOwner(product.getOriginalOwner())
                    .magicalPower(product.getMagicalPower())
                    .emotionLevel(product.getEmotionLevel())
                    .rarityScore(product.getRarityScore())
                    .memoryType(product.getMemoryType())
                    .imageUrls(product.getImageUrls())
                    .build();
        }
    }

    @Getter
    @Builder
    public static class FeaturedProductDto {
         private Long id;
         private String name;
         private String description;
         private int price;
         private String originalOwner;
         private MemoryType memoryType;

        public static FeaturedProductDto from(Product product) {
            return FeaturedProductDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .originalOwner(product.getOriginalOwner())
                    .memoryType(product.getMemoryType())
                    .build();
        }
    }
}