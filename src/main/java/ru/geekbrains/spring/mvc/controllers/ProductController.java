package ru.geekbrains.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.spring.mvc.model.Product;
import ru.geekbrains.spring.mvc.services.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product_page")
    public String showProductPage(Model model) {
        List<Product> list = productService.getAllProducts();
        model.addAttribute("products", list);
        return "product_table";
    }

    @GetMapping("/add_product")
    public String addNewProduct(@RequestParam String title, @RequestParam int cost) {
        Product product = new Product(1L, title, cost);
        productService.addProduct(product);
        return "redirect:/product_page";
    }
}
