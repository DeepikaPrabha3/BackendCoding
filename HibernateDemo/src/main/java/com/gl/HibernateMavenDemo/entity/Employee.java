package com.gl.HibernateMavenDemo.entity;

import jakarta.persistence.*;


@Entity
@Table(name="employee")
public class Employee {
    @Id
    private String emailId;
    private String employeeName;
    private String phone;


    //unidirectional
    @OneToOne
    @JoinColumn(name="identity_id")// if we want a userdefined colmn name
    //By default it is 'propertyname_id' - eg:'identification_id'
    private Identification identification;
    public Employee() {
    }

    public Employee(String emailId, String employeeName, String phone) {
        this.emailId = emailId;
        this.employeeName = employeeName;
        this.phone = phone;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emailId='" + emailId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }
}
