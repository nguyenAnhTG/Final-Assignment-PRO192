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
import Sub.Function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PatientList extends Vector<Patient> implements Function{
    Scanner sc = new Scanner(System.in);

    public PatientList() {
    }
    

    @Override
    public void AddFromFile(String fName) {
        File f = new File(fName);
        if(!f.exists()) return;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while((details=bf.readLine())!=null){
                StringTokenizer stk = new StringTokenizer(details, ",");
                String ID = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                String sex = stk.nextToken();
                int birth = Integer.parseInt(stk.nextToken());                
                long phone=Long.parseLong(stk.nextToken()); 
                String address = stk.nextToken();
                String diseaseName = stk.nextToken();
                
                Patient bn = new Patient(ID, name, sex, birth, phone, address, diseaseName);
                this.add(bn);
               
                
            }
            bf.close();fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void SaveToFile(String fName) {
        if(this.isEmpty()){
            System.out.println("No data found!");
            return;
        }
        
        
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Patient x: this){
                pw.print(x.getID()+","+x.getName()+","+x.getSex()+","+x.getBirth()+","+x.getPhone()+","+x.getAddress()+","+x.getDiseaseName()+"\n");
            }
            System.out.println("Save to file successfully!");
            pw.close();fw.close();
        } catch (IOException ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void addnew() {
        String newID, newName, newSex, newAdd, newDisea;
        int newBirth;
        long newPhone;
        
        System.out.println("-==============Enter new info of Patient==============-");
        newID=autoGenerateID("Patient");
        System.out.print("\n\tName: ");
        newName=sc.nextLine().toUpperCase();
        System.out.print("\tSex: ");
        newSex=sc.nextLine().toUpperCase();
        System.out.print("\tBirth: ");
        newBirth=Integer.parseInt(sc.nextLine());
        System.out.print("\tPhone: ");
        newPhone=Long.parseLong(sc.nextLine());
        System.out.print("\tAddress: ");
        newAdd=sc.nextLine();
        System.out.print("\tName of Disease: ");
        newDisea=sc.nextLine().toUpperCase();
        
        this.add(new Patient(newID, newName, newSex, newBirth, newPhone, newAdd, newDisea));
        System.out.println("New Patient have been added successfully!");
    }

    @Override
    public int find(String aId) {
        for(int i=0;i<this.size();i++){
            if(this.get(i).getID().equalsIgnoreCase(aId)) return i;
        }
        return -1;
    }

    @Override
    public void display() {
        if(this.size()==0){
            System.out.println("No data found!");
            return;
        }
        
        System.out.println("-==================================INFORMATION OF ALL PATIENTS==================================-\n");
        String s=String.format("%-8s%-20s%-6s%-7s%-15s%-15s%-20s\n", "ID","NAME","SEX","BITRH","PHONE","ADDRESS","DESEASE");
        System.out.println(s);
        for(Patient x: this){
            System.out.println(x);
        }
    }

    @Override
    public void update() {
        String newID;
        int tmp1,tmp2;
        //tmp1 dung de luu vi tri cua doctor, sau do se dc dung de update  
        //tmp2 la de test duplicate o phia duoi
        boolean valid=false;
        System.out.println("Enter the ID of Patien you want to update...");
        do {  //check valid id          
            newID=sc.nextLine().toUpperCase();
            tmp1 = find(newID);
            valid = newID.matches("^BN\\d{3}$");
            if(!valid) System.out.println("The ID is invalid! (**hint form ID: BN + 3 digits)");
        } while (!valid);
        if(tmp1<0) {
            System.out.println("ID Patient does not exist");
            return;
        }
        System.out.println("Start updating.....");
        Scanner sc=new Scanner(System.in);
        System.out.println("Old information: ");
        System.out.println(this.get(tmp1).toString());
        newID=autoGenerateID("Patient");
        System.out.println("");
        this.get(tmp1).setID(newID);
        System.out.println("");
        this.get(tmp1).update();
    }

    @Override
    public void remove() {
        String rID, name;
        System.out.print("Enter ID Patient u want to remove: ");
        rID=sc.nextLine().toUpperCase();
        int tmp=find(rID);
        if(tmp<0) System.out.println("ID Patient is not exist");
        else{
            name=this.get(tmp).getName();
            rID=this.get(tmp).getID();
            this.remove(tmp);
            System.out.println("Patient " +name+" with ID "+rID+  "has been removed successfully!");
        }
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
                System.out.format("\tID of this %s is(automatically generated): ",typeID);
                System.out.print(newID);
                inValid=false;
                }
            } while (inValid);
        return newID;
    }
    
    public String getNameP(String gId){
        int tmp=find(gId);
        return this.get(tmp).getName();
    }
    
    public String getDeseaseP(String gId){
        int tmp=find(gId);
        return this.get(tmp).getDiseaseName();
    }
}
