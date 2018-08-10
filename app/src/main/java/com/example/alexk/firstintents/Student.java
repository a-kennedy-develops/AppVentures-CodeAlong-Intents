package com.example.alexk.firstintents;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int iD;

    public Student(String name, int iD) {
        this.name = name;
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", iD=" + iD +
                '}';
    }
}
