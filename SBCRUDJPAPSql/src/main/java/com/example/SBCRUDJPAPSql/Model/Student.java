package com.example.SBCRUDJPAPSql.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // this will covert student data in table format using ORM
public class Student {
    @Id //primary key needed for table creation so we considered rno as primary key
    private int rno;
    private String name;
    private String gender;
    private String technology;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Student(int rno, String name, String gender, String technology) {
        this.rno = rno;
        this.name = name;
        this.gender = gender;
        this.technology = technology;
    }

    public Student() {
    }
}
