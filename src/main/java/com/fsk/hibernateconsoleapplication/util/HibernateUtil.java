/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsk.hibernateconsoleapplication.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author FSK
 */
public class HibernateUtil {
    
    private static final SessionFactory SESSION_FACTORY;
    
    static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        }catch(Throwable ex) {
            System.err.println("Initial Session Factory Creation Failed.." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
