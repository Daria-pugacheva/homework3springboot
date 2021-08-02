package ru.gb.pugacheva.homework3springboot.homework3springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.pugacheva.homework3springboot.homework3springboot.models.Product;
import ru.gb.pugacheva.homework3springboot.homework3springboot.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll (){
        return productRepository.findAll();
    }

    public void add (Product product){
        productRepository.add(product);
    }

    public Product findById (int id){
        return productRepository.findById(id);
    }
}
