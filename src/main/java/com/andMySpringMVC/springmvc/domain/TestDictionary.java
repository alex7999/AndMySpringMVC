package com.andMySpringMVC.springmvc.domain;

import com.andMySpringMVC.springmvc.configuration.HibernateConfig;
import com.andMySpringMVC.springmvc.dao.RoleDAO;
import com.andMySpringMVC.springmvc.dao.RoleDAOImpl;
//import com.andMySpringMVC.springmvc.domain.MyElementDictionary;
import com.andMySpringMVC.springmvc.model.Role;
import com.andMySpringMVC.springmvc.model.User;
import com.andMySpringMVC.springmvc.service.RoleService;
import com.andMySpringMVC.springmvc.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

//@WebAppConfiguration
public class TestDictionary {

//        @Autowired
//        private static SessionFactory sessionFactory;

        public static void main(String[] args) {
//            try (
//                    GenericApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateConfig.class)) {
                    AnnotationConfigApplicationContext context =
                            new AnnotationConfigApplicationContext(HibernateConfig.class);
                    UserService userService = context.getBean(UserService.class);
                    RoleService roleService = context.getBean(RoleService.class);
//                    User user = new User("user1add", roleService.getById(24));
//            userService.add(user);
//                listRoles(userService.allUser());
            userService.delete(userService.getById(6));
                    context.close();


        }




        public static void   listRoles(List<User> users){
            for (User user: users
                 ) {
                System.out.println(user.toString());
            }

        }



    }
