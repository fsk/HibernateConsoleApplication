/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsk.hibernateconsoleapplication.entity;

import javax.persistence.*;

/**
 *
 * @author FSK
 */
@Table(name = "employee")
@Entity
public class Employee {
    
    @Id
    @SequenceGenerator(name = "sq_id",
                       sequenceName = "sq_id",
                       allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "sq_id")
    private Long id;
    
    @Column(name = "employe_name")
    private String name;
    
    @Column(name = "employe_surname")
    private String surname;
    
    @Column(name = "employe_phonenumber", length = 13)
    private String phoneNumber;
    
    @Column(name = "employe_identitynumber", length = 11)
    private String identityNumber;
    
    @Column(name = "employe_email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
