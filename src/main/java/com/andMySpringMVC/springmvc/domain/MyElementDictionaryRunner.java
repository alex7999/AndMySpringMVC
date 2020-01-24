package com.andMySpringMVC.springmvc.domain;

import com.andMySpringMVC.springmvc.domain.MyElementDictionary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MyElementDictionaryRunner {

    private SessionFactory sessionFactory;

    public  MyElementDictionary getFirstElementDictionary() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        //MyElementDictionaryRunner myElementDictionaryRunner = new MyElementDictionaryRunner();


        /**
         * List developers
         */
        List<MyElementDictionary> dictionary = this.listDictionary();//myElementDictionaryRunner.listDictionary();
        for (MyElementDictionary elementDictionary : dictionary) {
            return elementDictionary;
        }

        return null;

    }

    public List<MyElementDictionary> listDictionary() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<MyElementDictionary> dictionary = session.createQuery("FROM MyElementDictionary").list();

        transaction.commit();
        session.close();
        return dictionary;
    }

}
