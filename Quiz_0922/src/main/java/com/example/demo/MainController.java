package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.product.ProductDto;
import com.example.demo.product.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {

	private final ProductService productService;
	
    @GetMapping("/products")
    public String showProductsPage() {
        return "forward:/products.html";
    }

    
    @GetMapping("/")
    public String showIndexPage() {
        return "forward:/index.html";
    }
   
 
    @GetMapping("/products/{id}")
    public String showProductDetailPage(@PathVariable("id") Long id, Model model) {
        ProductDto.ProductDetailDto productData = productService.getProductById(id);
        model.addAttribute("product", productData);
        return "product-detail";
    }
    
    @GetMapping("/cart")
    public String showCartPage() {
        return "forward:/cart.html";
    }
}


