package com.example.taxiservice.model;

public class Manufacturer {
    private Long id;
    private String name;

    private String country;

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }
    public Manufacturer() {}
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
}
