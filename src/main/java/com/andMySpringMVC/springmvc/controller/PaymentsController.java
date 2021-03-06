package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.Payments;
import com.andMySpringMVC.springmvc.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentsController {
    @Autowired
    PaymentsService paymentsService;

    @RequestMapping(value = "/payments/list", method = RequestMethod.GET)
    public List<Payments> allPayments(){
        return paymentsService.allPayments();
    }
}
