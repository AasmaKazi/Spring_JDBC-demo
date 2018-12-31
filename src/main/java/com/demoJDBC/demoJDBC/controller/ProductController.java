package com.demoJDBC.demoJDBC.controller;

import com.demoJDBC.demoJDBC.modal.Product;
import com.demoJDBC.demoJDBC.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductRepo productRepo;


    @PostMapping(value="/saveProduct")
    public String saveProductData(@RequestBody Product product){

        return productRepo.saveProduct(product);

    }

    @GetMapping(value="/getProductData")
    public List<Product> getData(){

        List<Product> list=productRepo.getProductList();
        return list;
    }

}
