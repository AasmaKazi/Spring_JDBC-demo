package com.demoJDBC.demoJDBC.controller;

import com.demoJDBC.demoJDBC.dao.UserDao;
import com.demoJDBC.demoJDBC.modal.Product;
import com.demoJDBC.demoJDBC.modal.User;
import com.demoJDBC.demoJDBC.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserRepo userRepo;


    @Autowired
    private UserDao userDao;

    @PostMapping(value = "/saveUser")
    public User saveUser(@RequestBody User user){

        userRepo.save(user);

        return user;

    }

    @GetMapping(value = "/getUserList")
    public List<User> getUserList(){

List<User> list=userRepo.getUserList();

return list;

    }


    @GetMapping(value = "updateData/{id}/{userName}")
public String updateData(@PathVariable Integer id,@PathVariable String userName){

String str=userRepo.update(id,userName);
return str;

    }

    @GetMapping(value = "deleteData/{id}")
    public String deleteData(@PathVariable Integer id){

        String string=userRepo.delete(id);
        return string;
    }

@PostMapping(value = "/saveProduct")
public String saveProduct(@RequestBody User user){

Product product=user.getProduct();
 userDao.saveDataProduct(user);
return userDao.saveDataProduct(user);

}


}
