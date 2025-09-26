package com.example.demo.product;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class ProductSpecification {
    public static Specification<Product> withFilters(String search, String memoryType, String price, String owner, Integer emotion) {
        return (root, query, criteriaBuilder) -> {
            // 모든 조건을 담을 Predicate 초기화 (항상 참)
            var predicate = criteriaBuilder.conjunction();

            // 검색어 필터
            if (StringUtils.hasText(search)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("name"), "%" + search + "%"));
            }

            // 기억 종류 필터
            if (StringUtils.hasText(memoryType)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("memoryType"), MemoryType.valueOf(memoryType)));
            }
            
            // 기억 주인 필터
            if (StringUtils.hasText(owner)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("originalOwner"), owner));
            }
            
            // 감정 강도 필터
            if (emotion != null && emotion > 0) {
                 predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("emotionLevel"), emotion));
            }

            // 가격 범위 필터
            if (StringUtils.hasText(price)) {
                try {
                    if (price.endsWith("+")) {
                        int minPrice = Integer.parseInt(price.replace("+", ""));
                        predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
                    } else {
                        String[] range = price.split("-");
                        int minPrice = Integer.parseInt(range[0]);
                        int maxPrice = Integer.parseInt(range[1]);
                        predicate = criteriaBuilder.and(predicate, criteriaBuilder.between(root.get("price"), minPrice, maxPrice));
                    }
                } catch (NumberFormatException e) {
                    // 가격 포맷이 잘못된 경우 무시
                }
            }
            
            return predicate;
        };
    }
}