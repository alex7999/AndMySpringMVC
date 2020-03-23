package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.*;
import com.andMySpringMVC.springmvc.service.*;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;



    @RequestMapping(value = "/ticket/buy", method = RequestMethod.POST)
    public Ticket buyTicket(int session_id, int row, int position){
        return ticketService.buyTicket(session_id, row, position);
    }

    @RequestMapping(value = "/ticket/price", method = RequestMethod.GET)
    public Money getPrice(int session_id, int row, int position){
        return ticketService.getPriceTicket(session_id, row, position);
    }

    @RequestMapping(value = "/ticket/list", method = RequestMethod.GET)
    public List<Ticket> allTicket(){
        return ticketService.allTickets();
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public String exceptionResp(ConstraintViolationException e, HttpServletResponse response) {
        return "ticket already sold";
    }

}
