package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.Role;
import com.andMySpringMVC.springmvc.model.User;
import com.andMySpringMVC.springmvc.service.RoleService;
import com.andMySpringMVC.springmvc.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// аннотация позволит Mockito проинициализировать моки внутри тестового класса
@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
//@WebMvcTest({UserController.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = WebConfig.class)
public class UserControllerTest {

    private final List<User> users = new ArrayList<>();

//    @Autowired
    private MockMvc mockMvc;

    @Mock
    UserService userService;

    @Mock
    RoleService roleService;

    @InjectMocks
    UserController userController;


    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
//        .webAppContextSetup(wac)
        .standaloneSetup(userController)
        .build();  // @Autowired private MockMvc mvc; вместо этого , но он не работает

    }

    @Test
    public void test_allUser_found() throws Exception {
//        UserService userService = mock(UserService.class);            //@Mock  UserService userService;  вместо этого
//        UserController userController = new UserController();         //@InjectMocks вместо этого
//        ReflectionTestUtils.setField(userController, "userService", userService);
//        assertEquals(1,userService.allUser().size());
        users.add(new User());
        when(userService.allUser()).thenReturn(users);
        mockMvc.perform(get("/user/list"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)));
//                .andExpect(jsonPath("$[0].role", is(24)));

        verify(userService, Mockito.times(1)).allUser(); // проверяет что userService был вызван 1 раз
    }

    @Test
    public void test_allUser_notfound() throws Exception {

        when(userService.allUser()).thenReturn(users);
        mockMvc.perform(get("/user/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(0)));

        verify(userService, Mockito.times(1)).allUser(); // проверяет что userService был вызван

    }
    @Test
    public void addUser() throws Exception {
        mockMvc.perform(post("/user/add")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param( "nameS", "admin")
                .param("role_id", "24"))
//                .andDo(print())
//                .andExpect(status().isCreated()); //201
                .andExpect(status().isOk())         //200
                .andExpect(jsonPath("$.name").value("admin"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

        verify(userService, Mockito.times(1)).add(any());
//        verify(userService).add(any());
    }

    @Test
    public void welcome() throws Exception {
        mockMvc.perform(get("/user/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception {
        User user = new User("vvv", new Role());
        user.setId(23);
        when(userService.getById(23)).thenReturn(user);
        mockMvc.perform(get("/user/getById/{id}", 23))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(23)));

        verify(userService, Mockito.times(1)).getById(23);
    }

    @Test
    public void getByUser() throws Exception {
        User user = new User("vvv", new Role());
        user.setId(23);
        when(userService.getCurrentUser()).thenReturn(user);
        mockMvc.perform(get("/user/i"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(23)));

        verify(userService, Mockito.times(1)).getCurrentUser();
    }

    @Test
    public void getByName() throws Exception {
        User user = new User("vvv", new Role());
        when(userService.findByUsername("vvv")).thenReturn(user);
        mockMvc.perform(get("/user/getByName/{username}", "vvv"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.name", is("vvv")));

        verify(userService, Mockito.times(1)).findByUsername("vvv");
    }

    @Test
    public void editUser() throws Exception {
        User user = new User("vvv", new Role());
        user.setId(11);
        Role roleNewId = new Role();
        roleNewId.setId(24);

        when(userService.getById(11)).thenReturn(user);
        when(roleService.getById(24)).thenReturn(roleNewId);
        mockMvc.perform(put("/user/edit")
                .param("id","11")
                .param( "name","vvv")
                .param( "role_id","24" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.role.id", is(24)));
        verify(userService, times(1)).edit(any());
    }

    @Test
    public void editUserCurrent() throws Exception {
        User user = new User("sss", new Role());
        user.setId(11);

        when(userService.getCurrentUser()).thenReturn(user);
        mockMvc.perform(put("/user/editCurrent")
                .param( "name","vvv"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.name", is("vvv")));
        verify(userService, times(1)).edit(any());
    }

    @Test
    public void deleteUser() throws Exception {
        User user = new User("sss", new Role());
        user.setId(11);

        when(userService.getById(11)).thenReturn(user);
        mockMvc.perform(delete("/user/delete/{id}",11))
                .andDo(print())
                .andExpect(status().isOk());
        verify(userService, times(1)).delete(any());
    }

}
