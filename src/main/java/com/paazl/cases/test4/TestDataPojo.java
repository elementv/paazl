package com.paazl.cases.test4;

import java.util.Date;

public class TestDataPojo {
    private String name;
    private String city;
    private String country;
    private Integer number;
    private Date date;

    public TestDataPojo(String name, String city, String country, Integer number, Date date) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.number = number;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Integer getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }
}
