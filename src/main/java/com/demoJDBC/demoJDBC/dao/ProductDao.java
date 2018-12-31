package com.demoJDBC.demoJDBC.dao;

import com.demoJDBC.demoJDBC.modal.Product;
import com.demoJDBC.demoJDBC.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class ProductDao  implements ProductRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

@Autowired
  private   Logger logger;

    @Override
    public String saveProduct(Product product) {
        String sql="insert into product values(?,?,?,?)";
       Integer a= jdbcTemplate.update(sql,new Object[]{product.getId(),product.getProductName(),product.getProductDetails(),product.getQuantity()});
        logger.info("=====********message send successfully"+a);
        if (a==1){
            return "Data inserted";

        }else {
            return "Data not inserted";
        }


    }


    public List<Product> getProductList() {
        String sql="select * from product";
        List<Product> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Product.class));
        return list;
    }



}
