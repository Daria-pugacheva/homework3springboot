package ru.gb.pugacheva.homework3springboot.homework3springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.pugacheva.homework3springboot.homework3springboot.models.Product;
import ru.gb.pugacheva.homework3springboot.homework3springboot.services.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showStartPageWithProductsList(Model model){
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/add")
    public String showFormForNewProduct(){
        return "add_product";
    }

    @PostMapping("/add")
    public String saveNewProduct(@RequestParam int id, @RequestParam String title, @RequestParam int cost){
        Product product = new Product(id,title,cost);
        productService.add(product);
        return "redirect:/";
    }


}
