package ru.gb.spring.repositories;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import ru.gb.spring.data.Product;

@Component
public class ProductsRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = List.of(
                new Product(1L, "Milk", 54.67),
                new Product(2L, "Bread", 23.45),
                new Product(3L, "Beer", 45.67)
        );
    }

    public List<Product> getAllProduts() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
