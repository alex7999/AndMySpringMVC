package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.dao.PaymentsDAO;
import com.andMySpringMVC.springmvc.model.Payments;
import com.andMySpringMVC.springmvc.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsServiceImpl implements PaymentsService {
    @Autowired
    PaymentsDAO paymentsDAO;


    @Override
    public List<Payments> allPayments() {
        return paymentsDAO.allPayments();
    }

    @Override
    public boolean add(Payments payments) {
        return paymentsDAO.add(payments);
    }

    @Override
    public void delete(Payments payments) {
        paymentsDAO.delete(payments);
    }

    @Override
    public void edit(Payments payments) {
        paymentsDAO.edit(payments);
    }

    @Override
    public Payments getById(int id) {
        return paymentsDAO.getById(id);
    }
}
