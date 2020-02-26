package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.Place;
import com.andMySpringMVC.springmvc.model.SessionFilm;
import com.andMySpringMVC.springmvc.model.Ticket;
import com.andMySpringMVC.springmvc.model.User;
import com.andMySpringMVC.springmvc.service.PlaceService;
import com.andMySpringMVC.springmvc.service.SessionFilmService;
import com.andMySpringMVC.springmvc.service.TicketService;
import com.andMySpringMVC.springmvc.service.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @Autowired
    SessionFilmService sessionFilmService;

    @Autowired
    PlaceService placeService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/ticket/buy", method = RequestMethod.POST)
    public String buyTicket(int session_id, int row, int position){
        Ticket ticket = new Ticket();
        SessionFilm sessionFilm = sessionFilmService.getById(session_id);
        Place place = placeService.getByPlace(sessionFilm.getHall().getId(), row, position);
        ticket.setPlace(place);
        ticket.setSessionFilm(sessionFilm);
        User user = userService.getCurrentUser();
        ticket.setUser(user);
        ticketService.add(ticket);

        return "Your ticket number " + ticket.getId();
    }

    @RequestMapping(value = "ticket/list", method = RequestMethod.GET)
    public List<Ticket> allTicket(){
        return ticketService.allTickets();
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public String exceptionResp(ConstraintViolationException e, HttpServletResponse response) {
        return "ticket already sold";
    }
}
