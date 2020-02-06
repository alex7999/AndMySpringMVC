package com.andMySpringMVC.springmvc.controller;

//import com.andMySpringMVC.springmvc.domain.MyElementDictionary;
//import com.andMySpringMVC.springmvc.domain.MyElementDictionaryRunner;
import com.andMySpringMVC.springmvc.model.Role;
import com.andMySpringMVC.springmvc.model.User;
import com.andMySpringMVC.springmvc.service.RoleService;
import com.andMySpringMVC.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AndMySpringMVCRestControllerUser {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/user/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to Controller user.";
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> allUser(){

        return userService.allUser();

    }

    @RequestMapping(value = "/user/getById/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public User addUser(String nameS, int role_id) {//@ModelAttribute("names, role_id")

        User userObj = new User(nameS, roleService.getById(role_id));

        userService.add(userObj);
        return userObj;
    }


    @RequestMapping(value = "/user/edit", method = RequestMethod.PUT)
    public User editRole(int id, String name, int role_id) {// @ModelAttribute("user") User user
        User userObj = userService.getById(id);
        userObj.setRole(roleService.getById(role_id));
        userObj.setName(name);
        userService.edit(userObj);
        return userObj;//""+id  +"  " +name + "   "+role_id;
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    public String deleteRole(@PathVariable int id) {
        User userObj = userService.getById(id);
        userService.delete(userObj);
        return userObj.toString();
    }

}