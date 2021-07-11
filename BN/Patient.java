/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BN;

/**
 *
 * @author ADMIN
 */
import Sub.Information;
import java.util.Scanner;



public class Patient extends Information{
    private String diseaseName;
    

    public Patient() {
    }

    public Patient(String ID, String name, String sex, long birth, int phone, String address, String diseaseName) {
        super(ID, name, sex, birth, phone, address);
        this.diseaseName = diseaseName;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return  s + " ||  " + diseaseName ;
    }
    
    @Override
    public void print() {
        super.print(); 
        System.out.printf("%s",diseaseName);
    }
    
    public void update(){
        //String ID, String name, String sex, long birth, int phone, String address, String diseaseName
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
        System.out.println("Enter new desease name");
        this.setDiseaseName(sc.nextLine().toUpperCase());
    }
}
