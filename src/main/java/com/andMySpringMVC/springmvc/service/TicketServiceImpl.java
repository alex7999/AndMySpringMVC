package com.andMySpringMVC.springmvc.service;

import com.andMySpringMVC.springmvc.dao.TicketDAO;
import com.andMySpringMVC.springmvc.model.*;
import org.hibernate.boot.model.source.internal.hbm.CompositeIdentifierSingularAttributeSourceManyToOneImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDAO ticketDAO;

    @Autowired
    SessionFilmService sessionFilmService;

    @Autowired
    PlaceService placeService;

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @Autowired
    PaymentsService paymentsService;

    @Override
    @Transactional
    public List<Ticket> allTickets() {
        return ticketDAO.allTickets();
    }

    @Override
    @Transactional
    public void add(Ticket ticket) {
        ticketDAO.add(ticket);
    }

    @Override
    @Transactional
    public void delete(Ticket ticket) {
        ticketDAO.delete(ticket);
    }

    @Override
    @Transactional
    public void edit(Ticket ticket) {
        ticketDAO.edit(ticket);
    }

    @Override
    @Transactional
    public Ticket getById(int id) {
        return ticketDAO.getById(id);
    }

    @Override
    @Transactional
    public Ticket buyTicket(int session_id, int row, int position) {
        Ticket ticket = new Ticket();
        SessionFilm sessionFilm = sessionFilmService.getById(session_id);
        Place place = placeService.getByPlace(sessionFilm.getHall(), row, position);
        User user = userService.getCurrentUser();

        return buyTicketUser( sessionFilm,  place,  user);
    }

    @Override
    @Transactional
    public Ticket buyTicketUser(SessionFilm sessionFilm, Place place, User user){
        Ticket ticket = new Ticket();
        Money money = getPriceTicket( sessionFilm,  place,  user);
        ticket.setPlace(place);
        ticket.setSessionFilm(sessionFilm);
        ticket.setUser(user);
        ticket.setMoney(money);
        ticketDAO.add(ticket);
        createPayments(user, money);
        return ticket;
    }

    @Override
    @Transactional
    public Money getPriceTicket(int session_id, int row, int position){

        Money money = null;
        SessionFilm sessionFilm = sessionFilmService.getById(session_id);
        Place place = placeService.getByPlace(sessionFilm.getHall(), row, position);
        User user = userService.getCurrentUser();

        //вычислим цену с учетом коэффициентов
        money = getPricePlace(sessionFilm, place, user);

        // вычислим скидку или кэшбэк если это секта
        getPriceSect(user, money);

        return money;
    }

    @Transactional
    public Money getPriceTicket(SessionFilm sessionFilm, Place place, User user){

        Money money = null;

        //вычислим цену с учетом коэффициентов
        money = getPricePlace(sessionFilm, place, user);

        // вычислим скидку или кэшбэк если это секта
        getPriceSect(user, money);

        return money;
    }

    public Money getPricePlace(SessionFilm sessionFilm, Place place, User user){

        Money money = null;

        //вычислим цену с учетом коэффициентов
        if (sessionFilm != null && place != null && user != null) {
            money = sessionFilm.getFilm().getMoney();
            BigDecimal price = money.getAmount();
            BigDecimal coefSession = BigDecimal.valueOf(sessionFilm.getCoef());
            BigDecimal coefPlace = BigDecimal.valueOf(place.getCoef());
            price = price.multiply(coefSession).multiply(coefPlace);
            money.setAmount(price);
        };

        return money;
    }

    public Money getPriceSect(User user, Money money){
        int sizeChain = 0;
        BigDecimal price = money.getAmount();

        if (user != null && money != null){
            List<Integer> parent = new ArrayList<Integer>();
            parent.add(user.getId());
            sizeChain = lengthChain(parent, sizeChain);

//            List<User> listChildren = user.getChildren();
//
//            if (listChildren.size() > 0)
//            System.out.println(listChildren.get(0));
            //если секта стоимость билета 150%
            if ( user.getSect() != null || sizeChain != 0){
                price = price.multiply(BigDecimal.valueOf(1.5));
            }

            if (sizeChain > 0 ){//&& sizeChain <= 10 по идее 11й пойдет минусом и это будет кэшбэк
                double discount = sizeChain * 0.1;//10%
                price = price.subtract(price.multiply(BigDecimal.valueOf(discount)));
            }

            money.setAmount(price);
        }

        return money;
    }

    public int lengthChain(List<Integer> parent, int sizeChain){

        List<Integer> children = userService.getChildren(parent);
        if (children.size() > 0){
            sizeChain++;
            sizeChain = lengthChain(children, sizeChain);
        } else {
            return sizeChain;
        }
        return sizeChain;
    }

    private void createPayments(User user, Money money){
        Account accountDT;
        Account accountCT;
        BigDecimal amount = money.getAmount();
        if (amount.longValue() > 0){
            accountDT = accountService.getById(1);
            accountCT = user.getAccount();
        }else{
            amount = amount.negate();
            money.setAmount(amount);
            accountDT = user.getAccount();
            accountCT = accountService.getById(1);
        }

        accountService.deposit(accountDT, money);

        accountService.withdraw(accountCT,money);

        Payments payments = new Payments();
        payments.setAccountDT(accountDT);
        payments.setAccountCT(accountCT);
        payments.setData(LocalDateTime.now());
        payments.setMoney(money);
        paymentsService.add(payments);

    }
}
