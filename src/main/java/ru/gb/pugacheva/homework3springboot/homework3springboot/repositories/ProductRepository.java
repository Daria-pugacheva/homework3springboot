package ru.gb.pugacheva.homework3springboot.homework3springboot.repositories;

import org.springframework.stereotype.Component;
import ru.gb.pugacheva.homework3springboot.homework3springboot.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1,"Milk",10),
                new Product(2,"Water",20),
                new Product(3,"Tee",30),
                new Product(4,"Coffee",40)

        ));
    }

    public List<Product> findAll (){
        return Collections.unmodifiableList(products);
    }

    public void add (Product product){
        products.add(product);
    }

    public Product findById (int id){
        return products.stream().filter(p -> p.getId()==id).findFirst().get();
    }

}
