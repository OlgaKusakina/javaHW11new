package ru.netology.domain;



public class Smartphone extends Product {

    private String manufacture;



    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);

        this.manufacture = manufacturer;
    }
}