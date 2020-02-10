package com.andMySpringMVC.springmvc.configuration;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Transactional
//@WebAppConfiguration
public class AndMySpringMVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                SecurityConfig.class, HibernateConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};//
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}