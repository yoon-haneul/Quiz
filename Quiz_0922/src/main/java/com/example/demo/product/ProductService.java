package com.example.demo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    // 필터링 및 페이징된 상품 목록 조회
    public Page<ProductDto.ProductListDto> getProducts(Pageable pageable, String search, String memoryType, String price, String owner, Integer emotion) {
        // Specification을 사용하여 동적 쿼리 생성
        Specification<Product> spec = ProductSpecification.withFilters(search, memoryType, price, owner, emotion);
        
        Page<Product> productPage = productRepository.findAll(spec, pageable);
        
        // Page<Entity>를 Page<Dto>로 변환
        return productPage.map(ProductDto.ProductListDto::from);
    }

    // 상품 상세 정보 조회
    public ProductDto.ProductDetailDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 기억을 찾을 수 없어요. ID: " + id));
        return ProductDto.ProductDetailDto.from(product);
    }

    // 추천 상품 조회
    public List<ProductDto.FeaturedProductDto> getFeaturedProducts() {
        return productRepository.findTop4ByOrderByRarityScoreDescCreatedAtDesc().stream()
                .map(ProductDto.FeaturedProductDto::from)
                .collect(Collectors.toList());
    }
}