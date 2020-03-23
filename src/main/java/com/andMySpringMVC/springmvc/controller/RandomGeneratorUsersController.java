package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.*;
import com.andMySpringMVC.springmvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class RandomGeneratorUsersController {
    @Autowired
    UserService userService;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    SessionFilmService sessionFilmService;

    @Autowired
    TicketService ticketService;

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/randomSect/{session_id}", method = RequestMethod.GET)
    public void createRandomChain(@PathVariable(value = "session_id") int session_id) {
        //создаем пользователя
        SessionFilm sessionFilm = sessionFilmService.getById(session_id);
        User[] users = new User[10];
        for (int i = 0; i < 10; i++) {
            users[i] = newUser(i, session_id);
        }

        for (User u :
                users) {
            int ind = rnd(0, users.length - 1);
            if (u != users[ind])
                u.setSect(users[ind]);
            userService.edit(u);
        }


        int index = 0;
        for (Place place :
                sessionFilm.getHall().getPlaces()) {
            if (index < users.length) {
                ticketService.buyTicketUser(sessionFilm, place, users[index]);
            } else {
                break;
            }

            index++;

        }

    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private User newUser(int numberUser, int session_id) {
        User user = new User();
        user.setName("RUsr" + session_id + "_" + numberUser);
        user.setUsername("RUsr" + session_id + "_" + numberUser);
        user.setPassword("" + numberUser);
        userService.add(user);
        user.setAccount(newAccount(numberUser, user));
        userService.edit(user);
        return user;
    }

    private Account newAccount(int numberUser, User user) {
        Account account = new Account();
        Money money = new Money();
        money.setAmount(BigDecimal.valueOf(500));
        money.setCurrency(currencyService.getById(30));
        account.setMoney(money);
        account.setUser(user);
        accountService.add(account);
        return account;
    }
}
