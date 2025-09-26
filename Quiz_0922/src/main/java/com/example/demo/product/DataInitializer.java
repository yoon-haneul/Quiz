package com.example.demo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if (productRepository.count() > 0) {
            return;
        }

        List<Product> products = List.of(
            Product.builder().name("토심이의 첫 일기장").description("순수한 감정이 담긴 일기장").price(45000).stock(1).originalOwner("토심이").magicalPower("마음을 편안하게 해줌").emotionLevel(9).rarityScore(8).memoryType(MemoryType.CHILDHOOD).build(),
            Product.builder().name("와플곰의 실험 비커").description("수많은 실험을 거친 마법 비커").price(32000).stock(3).originalOwner("와플곰").magicalPower("액체를 맛있게 만듦").emotionLevel(6).rarityScore(7).memoryType(MemoryType.EXPERIMENT).build(),
            Product.builder().name("탱고의 모험 나침반").description("차원을 넘나드는 나침반").price(78000).stock(1).originalOwner("탱고").magicalPower("길을 잃지 않게 해줌").emotionLevel(8).rarityScore(10).memoryType(MemoryType.ADVENTURE).build(),
            Product.builder().name("바쁘개의 만년필").description("수많은 계약을 성사시킨 만년필").price(52000).stock(10).originalOwner("바쁘개").magicalPower("업무 효율 10% 증가").emotionLevel(7).rarityScore(7).memoryType(MemoryType.EXPERIMENT).build(),
            Product.builder().name("누렁이의 밥그릇").description("수많은 기억을 담았던 밥그릇").price(99000).stock(1).originalOwner("누렁이").magicalPower("음식 맛을 2배로 만듦").emotionLevel(10).rarityScore(9).memoryType(MemoryType.FOOD).build(),
            Product.builder().name("오구의 첫 그림 붓").description("프리랜서의 꿈을 키웠던 붓").price(8000).stock(15).originalOwner("오구").magicalPower("창의력을 샘솟게 함").emotionLevel(7).rarityScore(5).memoryType(MemoryType.CHILDHOOD).build(),
            Product.builder().name("토심이와 친구들의 사진").description("소중한 우정이 담긴 폴라로이드 사진").price(38000).stock(4).originalOwner("토심이").magicalPower("우정을 돈독하게 함").emotionLevel(9).rarityScore(7).memoryType(MemoryType.FRIENDSHIP).build()
        );

        productRepository.saveAll(products);
        System.out.println("✅ 샘플 데이터가 성공적으로 추가되었습니다.");
    }
}