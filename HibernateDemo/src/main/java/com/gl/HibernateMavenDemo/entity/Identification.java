package com.gl.HibernateMavenDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


/* Every Employee will have an identification - Aadhar or driving license etc
* Identification class will take details from every employee
* One employee will have exactly one ID Proof
* This is a 'has a relationship'
* Either email from employee can be a foreign key to identification or
* Identification proof 'id' can be a forieng key to employee table == > either ways are possible
* While loading the employee details  - i would just need the proof id => as i wont be changing the id often
* */
@Entity
@Table(name="identity")
public class Identification {
    @Id
    private String id;
    private String fullname;
    private String bdate;
    //'mapped by' attribute is very important for bidirectional mapping
    @OneToOne(mappedBy ="identification") //map using property
    private Employee emp; //This will create a column emp_emailId
    //Therefore we need to tell hibernate no need to create column as column locailly is not needed
    //This is what happens if we leave hibenrate tp handle things #drawback of hibernate
    public Identification() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
}
