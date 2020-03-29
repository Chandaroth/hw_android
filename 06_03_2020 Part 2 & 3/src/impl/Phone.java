package impl;

import inter.IPhone;

import java.util.Scanner;

public class Phone implements IPhone {
    public boolean isUpdate;
    private int id;
    private String model;
    private int year;
    private float price;
    Scanner scanner=new Scanner(System.in);

    public Phone() {
    }

    public Phone(boolean isUpdate, int id, String model, int year, float price, Scanner scanner) {
        this.isUpdate = isUpdate;
        this.id = id;
        this.model = model;
        this.year = year;
        this.price = price;
        this.scanner = scanner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public void Add() {
        if(isUpdate==false){
            System.out.print("Enter ID: ");
            this.id=new Scanner(System.in).nextInt();
        }

        System.out.print("Enter Model:");
        this.model=new Scanner(System.in).nextLine();

        System.out.print("Enter Year:");
        this.year=new Scanner(System.in).nextInt();

        System.out.print("Enter Price:");
        this.price=new Scanner(System.in).nextFloat();
    }

    @Override
    public void Show() {
        System.out.println("ID: "+this.id);
        System.out.println("Model: "+this.model);
        System.out.println("Year: "+this.year);
        System.out.println("Price: "+this.price);
    }
}
