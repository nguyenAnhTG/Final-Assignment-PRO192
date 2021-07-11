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
    
    private String specialized;

    public Doctor() {
    }


    Doctor(String ID, String name, String sex, int birth, long phone, String address, String specialized) {
        super(ID, name, sex, birth, phone, address);
        this.specialized = specialized;
    }

   
    
    
    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }
    
    @Override
    public String toString() {
        
        
        String s="";
        s+=String.format("%-8s%-20s%-6s%-7s%-15s%-15s%-20s\n", getID(),getName(),getSex(),getBirth(),getPhone(),getAddress(),getSpecialized());
        
        return s;
    } 

    public void update(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new name");
        this.setName(sc.nextLine().toUpperCase());
        System.out.println("Enter new sex");
        this.setSex(sc.nextLine().toUpperCase());
        System.out.println("Enter new birth");
        this.setBirth(sc.nextInt());
        System.out.println("Enter new phone");
        this.setPhone(sc.nextLong());
        sc=new Scanner(System.in);
        System.out.println("Enter new address");
        this.setAddress(sc.nextLine().toUpperCase());
        System.out.println("Enter new specilaization");
        this.setSpecialized(sc.nextLine().toUpperCase()); 
        System.out.println("Update successfully!");
    }
    
}
