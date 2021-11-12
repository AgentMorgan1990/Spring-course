package ru.gb.spring.data;

public class Product {
    private Long id;
    private String title;
    private double coast;

    public Product() {
    }

    public Product(Long id, String title, double coast) {
        this.id = id;
        this.title = title;
        this.coast = coast;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCoast() {
        return coast;
    }
}
