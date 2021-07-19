/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsk.hibernateconsoleapplication.main;

import com.fsk.hibernateconsoleapplication.entity.Employee;
import com.fsk.hibernateconsoleapplication.service.EmployeeService;

/**
 * @author FSK
 */
public class Main {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Employee e = new Employee();
        e.setName("Furkan");
        e.setSurname("sadasdasd");
        e.setIdentityNumber("12345678910");
        e.setPhoneNumber("+905534664698");
        e.setEmail("furkansahinkulaksiz@gmail.com");
        //employeeService.save(e);


        employeeService.update(e);

//        for(Employee item : employeeService.list(new Employee())) {
//            System.out.println(item.getId() + ". " + item.getName() + " " + item.getSurname() + " " + item.getIdentityNumber() + " " + item.getPhoneNumber() + " " + item.getPhoneNumber());
//        }

        //employeeService.list(e);
    }

}
