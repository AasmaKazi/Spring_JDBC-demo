package com.demoJDBC.demoJDBC.repository;

import com.demoJDBC.demoJDBC.modal.User;

import java.util.List;

public interface UserRepo {


    User save(User user);
    List<User> getUserList();
String update(Integer id, String userName);
String delete(Integer id);
String saveDataProduct(User user);

//    String updateData(Integer id);
}