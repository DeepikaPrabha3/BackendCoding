package com.gl.HibernateMavenDemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int sid;
    private  String name;
    private  String technology;

    //one to one residential address
    //we will get one table -'student' with its columns -sid,name,technology and address as embedded
    //will not create a separate address table but will add all columns  of Address in the student table itself
    @Embedded
    private Address address;
    @ElementCollection//one student can have many certificates that can be uploaded
    @JoinTable(name="certificates",joinColumns = @JoinColumn(name = "studid"))
    @Column(name = "cert")
    private List<String> certificates;//'ElementCollection' is used when u have list of primitives(Integer,String etc)
                    //Use 'OneToMany' for list of References

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }
}
