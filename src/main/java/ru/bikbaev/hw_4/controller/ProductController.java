package ru.bikbaev.hw_4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ru.bikbaev.hw_4.model.Product;
import ru.bikbaev.hw_4.service.ProductService;


import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/product-create")
    public String formProductCreat(Product product) {
        return "product-create";
    }


    @PostMapping("/product-create")
    public String productCreat(Product product) {
        productService.creatProduct(product);
        return "redirect:products";
    }

    @GetMapping("product-delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/sell-product/")
    public String sellProductIdAndQuantityNull() {
        return "redirect:/products";
    }

    @GetMapping("/sell-product/{id}/")
    public String sellProductQuantityNull(@PathVariable int id) {
        return "redirect:/products";
    }

    @GetMapping("/sell-product/{id}/{quantity}")
    public String sellProduct(@PathVariable int id, @PathVariable int quantity) {
        productService.sellProduct(id, quantity);
        return "redirect:/products";
    }

    @GetMapping("/buy-product/{id}/{quantity}")
    public String buyProduct(@PathVariable int id, @PathVariable int quantity) {
        productService.buyProduct(id, quantity);
        return "redirect:/products";
    }

    @GetMapping("/buy-product/")
    public String buyProductIdAndQuantityNull() {
        return "redirect:/products";
    }

    @GetMapping("/buy-product/{id}/")
    public String buyProductQuantityNull(@PathVariable int id) {
        return "redirect:/products";
    }





}
