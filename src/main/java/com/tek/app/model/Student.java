package com.tek.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer rollId;
    private String firstName;
    private String lastName;
    private String address;


    public Student() {
        super();
    }

    public Integer getRollId() {
        return rollId;
    }

    public void setRollId(Integer rollId) {
        this.rollId = rollId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollId=" + rollId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

