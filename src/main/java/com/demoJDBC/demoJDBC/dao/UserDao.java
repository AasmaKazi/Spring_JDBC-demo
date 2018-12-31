package com.demoJDBC.demoJDBC.dao;

import com.demoJDBC.demoJDBC.modal.Product;
import com.demoJDBC.demoJDBC.modal.User;
import com.demoJDBC.demoJDBC.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.logging.Logger;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Object;

@Repository
public class UserDao implements UserRepo {

@Autowired
    private JdbcTemplate jdbcTemplate;
@Autowired
    Logger logger;


@Override
public User save(User user){

    String sql="insert into user values (?,?,?,?,?,?)";
   Integer a= jdbcTemplate.update(sql,new Object[]{user.getId(),user.getUserName(),user.getContactNum(),user.getEmail(),user.getPassword()});
    logger.info("save data successfully******************"+a);
    return user;
}



public List<User> getUserList(){

    String sql="select * from user";
   List<User> list =jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));

    return list;
}


public String update(Integer id,String userName){

    String sql="update user set userName=? where id=?";
    jdbcTemplate.update(sql,new Object[]{userName,id},new int[]{Types.VARCHAR,Types.INTEGER});

    return "Update data successfully";

}

public String delete(Integer id){

    String sql="delete from user where id=?";
    jdbcTemplate.update(sql,new Object[]{id},new int[]{Types.INTEGER});

    return "Deleted data ";

}

public String saveDataProduct(User user){

    String sql="select * from product where id=?" ;

    Product productAdd=jdbcTemplate.queryForObject(sql,new Object[]{user.getProduct().getProductName()},Product.class);

    logger.info("save data successfully******************"+productAdd);

    if (productAdd==null){
        String sql1= "insert into product values(?,?,?,?)";
jdbcTemplate.update(sql1,new Object[]{user.getProduct().getId(),user.getProduct().getProductName(),user.getProduct().getProductDetails(),user.getProduct().getQuantity()});

        String sql2="insert into user values(?,?,?,?,?)";
        jdbcTemplate.update(sql2,new Object[]{user.getId(),user.getUserName(),user.getContactNum(),user.getEmail(),user.getPassword()});
    }
    else
    {

        String sql2="insert into user values(?,?,?,?,?)";
        jdbcTemplate.update(sql2,new Object[]{user.getId(),user.getUserName(),user.getContactNum(),user.getEmail(),user.getPassword()});

    }

   return "Product added successfully";
}



//    public String updateData(Integer id){
//
//
//    String sql="select * from user where id=?";
//
//    User userUpdate=jdbcTemplate.query(sql,new Object[]{id},new int[]{Types.INTEGER});
//
//    String updateData="update user set userName=?, contactNum=?, email=? ,password=?,product=? where id=?";
//    jdbcTemplate.update(sql,new BeanPropertyRowMapper<>(User.class));
//
//
//
//    }
}
