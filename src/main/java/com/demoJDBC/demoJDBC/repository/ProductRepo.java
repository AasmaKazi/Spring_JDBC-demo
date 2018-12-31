package com.demoJDBC.demoJDBC.repository;

import com.demoJDBC.demoJDBC.modal.Product;

import java.util.List;

public interface ProductRepo {

    String saveProduct(Product product);
List<Product> getProductList();
}
