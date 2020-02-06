package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.Role;
import com.andMySpringMVC.springmvc.service.RoleService;
import com.andMySpringMVC.springmvc.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class AndMySpringMVCRestControllerRole {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to Saha Rest api.";
    }


    @RequestMapping(value = "/role/list/", method = RequestMethod.GET)
    public List<Role> allRoles() {//List<Role> allRoles() {//REST Endpoint.

        List<Role> roles = roleService.allRoles();

        return roles;
    }

    @RequestMapping(value = "/role/getById/{id}", method = RequestMethod.GET)
    public Role getById(@PathVariable int id) {

        Role role = roleService.getById(id);

        return role;
    }

    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
    public Role addRole(@ModelAttribute("role, name, id") String discriminator, String name, int id) {
        Role roleObj = new Role( name, 2);

        roleService.add(roleObj);
        return roleObj;
    }


    @RequestMapping(value = "/role/edit", method = RequestMethod.PUT)
    public Role editRole(@ModelAttribute("role, name, id") String discriminator, String name, int id) {
        Role roleObj = roleService.getById(id);
        roleObj.setName(name);
        roleService.edit(roleObj);
        return roleObj;
    }

    @RequestMapping(value = "/role/delete/{id}", method = RequestMethod.DELETE)
    public String deleteRole(@PathVariable int id) {
        Role roleObj = roleService.getById(id);
        roleService.delete(roleObj);
        return roleObj.toString();
    }
}