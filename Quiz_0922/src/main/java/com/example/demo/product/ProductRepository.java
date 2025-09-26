package com.example.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    
    // 희귀도가 높고 최신순인 상품 4개를 조회
    List<Product> findTop4ByOrderByRarityScoreDescCreatedAtDesc();
}