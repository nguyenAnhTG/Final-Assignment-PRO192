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
import Sub.Function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAPTOP VINH HA
 */
public class DoctorList extends Vector <Doctor> implements Function{
    Scanner sc = new Scanner(System.in);

    public DoctorList() {
        super();
    }

    @Override
    public void AddFromFile(String fName) {
        try {
            File f= new File(fName);
            if(!f.exists()) return;
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while((details = bf.readLine()) != null){
                StringTokenizer stk = new StringTokenizer(details, ",");
                String ID = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                String sex = stk.nextToken();
                int birth = Integer.parseInt(stk.nextToken());                
                long phone=Long.parseLong(stk.nextToken());  
                String address = stk.nextToken();

                String specialized = stk.nextToken();
                
                Doctor bs = new Doctor(ID, name, sex, birth, phone, address,  specialized);
                this.add(bs);
            }
            bf.close();
            fr.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DoctorList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoctorList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void SaveToFile(String fName){
        if(this.isEmpty()){
            System.out.println("No data found!");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Doctor x: this){
                pw.print(x.getID()+ "," + x.getName()+","+x.getSex() + "," + x.getBirth() +","+x.getPhone() + ","+x.getAddress() + ","+x.getSpecialized()+"\n");
            }
            System.out.println("Save to file successfully!");
            pw.close(); fw.close();
        } catch (IOException ex) {
            Logger.getLogger(DoctorList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void addnew() {
        long  newphone;
        int tmp;
        String newname, newID, newsex, newaddress, newspecialized;
        int newbirth;
        boolean valid=true;
        System.out.println("-==========Enter new info of Doctor==========-");
        System.out.print("\t");
        newID=autoGenerateID("Doctor");
        
        System.out.print("\n\tName: ");
        newname = sc.nextLine().toUpperCase();
        //String sex, long birth, int phone, String address, String positon, String specialized
        System.out.print("\tSex: ");
        newsex=sc.nextLine().toUpperCase();
        System.out.print("\tBirth: ");
        newbirth=Integer.parseInt(sc.nextLine());
        System.out.print("\tPhone: ");
        newphone=Long.parseLong(sc.nextLine());
        System.out.print("\tAddress: ");
        newaddress=sc.nextLine().toUpperCase();
        System.out.print("\tSpecialized: ");
        newspecialized=sc.nextLine().toUpperCase();
        this.add(new Doctor(newID, newname, newsex, newbirth, newphone, newaddress,newspecialized));
        System.out.println("New Doctor has been added successfully!");
    }


    @Override
    public void display() {
        if(this.size()==0){
            System.out.println("No data found!");
            return;
        }   
        
        //System.out.println("-----------------------------");
        System.out.println("-==================================INFORMATION OF ALL DOCTORS==================================-\n");
        String s=String.format("%-8s%-20s%-6s%-7s%-15s%-15s%-20s\n", "ID","NAME","SEX","BITRH","PHONE","ADDRESS","SPECIALIZED");
        System.out.println(s);
        for(Doctor x: this){
            System.out.println(x);
        }
    }

    @Override
    public void update() {
        String newID;
        int tmp1,tmp2;
        //boolean tmp1;
        //tmp1 dung de luu vi tri cua doctor, sau do se dc dung de update  
        //tmp2 la de test duplicate o phia duoi
        boolean valid=false;
        System.out.println("Enter the ID of Doctor you want to update...");
        do {  //check valid id          
            newID=sc.nextLine().toUpperCase();
            tmp1 = find(newID);
            valid = newID.matches("^BS\\d{3}$");
            if(!valid) System.out.println("The ID is invalid! (**hint form ID: BS + 3 digits)");
        } while (!valid);
        if(tmp1<0) {
            System.out.println("ID Doctor does not exist");
            return;
        }
        System.out.println("Start updating.....");
        Scanner sc=new Scanner(System.in);
        System.out.println("Old information: ");
        String s=String.format("%-8s%-20s%-6s%-7s%-15s%-15s%-20s\n", "ID","NAME","SEX","BITRH","PHONE","ADDRESS","SPECIALIZED");
        System.out.println(s);
        System.out.println(this.get(tmp1).toString());
        
        newID=autoGenerateID("Doctor");
        this.get(tmp1).setID(newID);
        System.out.println("");
        this.get(tmp1).update();
    }

    @Override
    public void remove() {
        String rID, name;
        System.out.print("Enter ID Doctor u want to remove: ");
        rID = sc.nextLine().toUpperCase();
        int tmp = find(rID);
        if(tmp<0) System.out.println("ID Doctor is not exist");
        else{
            name=this.get(tmp).getName();
            this.remove(tmp);
            //System.out.println("Doctor " + this.get(tmp).getName() + "  ID: " + rID + " has been removed");
            System.out.println("Doctor " + name+" with ID: " + rID + " has been removed successfully!");
        }
                       
    }
    
    public int find(String aId) {
        for(int i=0;i<this.size();i++){
            if(this.get(i).getID().equalsIgnoreCase(aId)) return i;
        }
        return -1;
    }
    
    public boolean checkID(String givenID){
        for (int i = 0; i < this.size(); i++) {
            if(givenID.equals((this.get(i).getID())))
                return true;
 
        }
        return false;
    }
    
    public String autoGenerateID(String typeID){
        String newID, type="";
        if(typeID.equals("Doctor")) type="BS";
        else if(typeID.equals("Patient")) type="BN";
        else if(typeID.equals("Drug")) type="T";
        else if(typeID.equals("Order")) type="OD";
        boolean inValid=true;
        do {                
            newID= type+Integer.toString((int)Math.floor(Math.random()*(999-100+1)+100));
            if(checkID(newID)) 
                continue;
            else{
                System.out.format("ID of this %s is(automatically generated): ",typeID);
                System.out.print(newID);
                inValid=false;
                }
            } while (inValid);
        return newID;
    }

    
    
}