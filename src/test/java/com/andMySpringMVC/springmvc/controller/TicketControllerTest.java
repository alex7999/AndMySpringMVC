package com.andMySpringMVC.springmvc.controller;

import com.andMySpringMVC.springmvc.model.Money;
import com.andMySpringMVC.springmvc.model.Ticket;
import com.andMySpringMVC.springmvc.service.TicketService;
import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_fr;
import org.jcp.xml.dsig.internal.dom.ApacheOctetStreamData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class TicketControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private TicketController ticketController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders
                .standaloneSetup(ticketController)
                .build();
    }

    @Test
    public void buyTicket() throws Exception {
        Ticket ticket = new Ticket();
        ticket.setId(1);
        when(ticketService.buyTicket(1,1,1)).thenReturn(ticket);
        mockMvc.perform(post("/ticket/buy")
                .param("session_id", "1")
                .param("row", "1")
                .param("position", "1"))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$.id").value(1));

        verify(ticketService,times(1)).buyTicket(1,1,1);
    }

    @Test
    public void getPrice() throws Exception {
        Money money = new Money();
        money.setAmount(BigDecimal.valueOf(11));
        when(ticketService.getPriceTicket(10,10,10)).thenReturn(money);
        mockMvc.perform(get("/ticket/price")
                .param("session_id", "10").param("row", "10").param("position", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount").value(11));
        verify(ticketService,times(1)).getPriceTicket(10,10,10);
    }

    @Test
    public void allTicket() throws Exception {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket());
        tickets.add(new Ticket());

        when(ticketService.allTickets()).thenReturn(tickets);
        mockMvc.perform(get("/ticket/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

}