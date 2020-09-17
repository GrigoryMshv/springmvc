package ru.geekbrains.spring.mvc.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.mvc.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

        @Autowired
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Milk", 60));
        products.add(new Product(2L, "Cheese", 515));
        products.add(new Product(3L, "Eggs", 95));
        products.add(new Product(4L, "Meat", 750));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new RuntimeException("Product not found");
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
