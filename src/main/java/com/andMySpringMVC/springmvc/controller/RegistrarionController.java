package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.User;
import com.andMySpringMVC.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegistrarionController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public ModelAndView registration(Model model) {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        modelAndView.addObject("userForm", new User());
        return modelAndView;
    }


    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm")  User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
//        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
//            model.addAttribute("passwordError", "Пароли не совпадают");
//            return "registration";
//        }
        try {

            userService.add(userForm);

        } catch (Exception e){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";}


        return "redirect:/";
    }
}
