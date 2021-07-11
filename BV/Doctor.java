/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BV;

/**
 *
 * @author ADMIN
 */
import Sub.Information;
import java.util.Scanner;


public class Doctor extends Information {
    private String positon;
    private String specialized;

    public Doctor() {
    }

    public Doctor(String ID, String name, String sex, long birth, int phone, String address, String positon, String specialized) {
        super(ID, name, sex, birth, phone, address);
        this.positon = positon;
        this.specialized = specialized;
    }

    public String getPosition() {
        return positon;
    }

    public void setPosition(String positon) {
        this.positon = positon;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }
    
    @Override
    public String toString() {
        String s= super.toString();
        s=s+ " ||   " + getPosition() + ": " + getSpecialized();
        return s;
    } 
    
    @Override
    public void print() {
        String infoD= getPositon()+","+getSpecialized();
        super.print();
        System.out.printf(" %s", infoD);
    }

    public void update(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new name");
        this.setName(sc.nextLine().toUpperCase());
        System.out.println("Enter new sex");
        this.setSex(sc.nextLine().toUpperCase());
        System.out.println("Enter new birth");
        this.setBirth(sc.nextLong());
        System.out.println("Enter new phone");
        this.setPhone(sc.nextInt());
        System.out.println("Enter new address");
        this.setAddress(sc.nextLine().toUpperCase());
        System.out.println("Enter new posiont");
        this.setPosition(sc.nextLine().toUpperCase());
        System.out.println("Enter new specilaization");
        this.setSpecialized(sc.nextLine().toUpperCase());        
    }
    
}
