/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BN;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Drug {
    private String name,ID;
    
    private double price;

    public Drug() {
    }

    public Drug(String ID, String name, double price) {
        this.ID=ID;
        this.name = name;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String s = String.format("%-8s%-15s%-10s",getID(),getName(),getPrice());
        return s;
    }
    
    //String ID, String name,double weight, int price
    public void update(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new name");
        this.setName(sc.nextLine().toUpperCase());
        System.out.println("Enter new price");
        this.setPrice(sc.nextDouble());
        System.out.println("Update successfully!");
              
    }
    
}