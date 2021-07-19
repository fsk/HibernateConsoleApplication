/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsk.hibernateconsoleapplication.util;

import com.fsk.hibernateconsoleapplication.entity.Employee;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author FSK
 */
public class DBConn<T> implements DBOperation<T> {

    private Session session;
    private Transaction transaction;

    private void openSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    private void closeSession() {
        transaction.commit();
        session.close();
    }

    @Override
    public void save(T t) {
        try {
            openSession();
            session.save(t);
            closeSession();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while Save.");
        }
    }

    @Override
    public void update(T t) {
        try {
            openSession();
            session.update(t);
            closeSession();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("Error while Update.");
        }
    }

    @Override
    public void delete(T t) {
        try {
            openSession();
            session.delete(t);
            closeSession();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while Delete.");
        }
    }

    @Override
    public List<T> list(T t) {
        List<T> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(t.getClass());
        list = criteria.list();
        session.close();
        return list;
    }
    
    

    @Override
    public List<T> search(String columnName, String value, T t) {
        List<T> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(t.getClass());
        criteria.add(Restrictions.like(columnName, "%" + value + "%"));
        list = criteria.list();
        session.close();
        return list;
    }
    
    

    @Override
    public T find(Long id, T t) {
        T clazz;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(t.getClass());
        criteria.add(Restrictions.eq("id", id));
        if(criteria.list() == null) {
            return null;
        }else {
            clazz = (T) criteria.list().get(0);
        }
        session.close();
        return clazz;
    }
    
    

    @Override
    public List<T> advancedList(T t) {
        List<T> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(t.getClass());
        
        //Reflections -> Sınıflar üstünde çalışır. Bir sınıfı alır. Üzerindeki değerleri okur.
        
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        try {
            for(int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (fields[i].get(t) != null) {
                    if(fields[i].getType() == String.class) {
                        criteria.add(Restrictions.like(fields[i].getName(), "%"+fields[i].get(t)+"%"));
                    }else {
                        criteria.add(Restrictions.eq(fields[i].getName(), fields[i].get(t)));
                    }
                }
            }
        }catch (Exception ex) {
            
        }
        
        list = criteria.list();
        session.close();
        return list;
    }

}
