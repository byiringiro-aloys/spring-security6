package com.spring_sec.SpringSec1.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private record Product(Integer productId, String productName,Double price){}

    List<Product> products = new ArrayList<>(
            List.of(new Product(1,"Airtel Imagine",3000.0),
                    new Product(2,"I Phone",992.0)
                    )
    );

    @GetMapping
    public List<Product> getAllProducts(){
        return products;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        products.add(product);
        return product;
    }
}
