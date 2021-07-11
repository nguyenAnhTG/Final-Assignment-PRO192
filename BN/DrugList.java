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


public class DrugList extends Vector<Drug> implements Function {
    Scanner sc = new Scanner(System.in);

    public DrugList() {
    }
    
    @Override
    public void AddFromFile(String fName) {
        
        try {
            File f = new File(fName);
            if(!f.exists()) return;
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while((details=bf.readLine()) != null){
                StringTokenizer stk = new StringTokenizer(details, ",");
                String ID = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                
                int price = Integer.parseInt(stk.nextToken());
                
                Drug thuoc = new Drug(ID, name, price);
                this.add(thuoc);
            }
            bf.close();fr.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger(DrugList.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(DrugList.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }

    @Override
    public void SaveToFile(String fName) {
        if(this.isEmpty()){
            System.out.println("Arr rỗng");
            return;
        } 
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Drug x: this){
                pw.print(x.getID()+","+x.getName()+","+x.getPrice()+"\n");
            }
            pw.close();fw.close();
        } catch (IOException e) {
            Logger.getLogger(DrugList.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void addnew() {
        String newName,newID;
        double newWeight;
        int tmp,newPrice;
        boolean valid = true;
        System.out.println("---Enter new info of Drug---");
        do{
            System.out.print("\tID: ");
            newID=sc.nextLine().toUpperCase();
            tmp=find(newID);
            valid=newID.matches("^T\\d{3}$");
            if(tmp>0) System.out.println("**ID is duplicated");
            if(!valid) System.out.println("**Hint form ID: T + 3 digits");
        }while(tmp>0|| !valid);
        System.out.print("\tName: ");
        newName=sc.nextLine().toUpperCase();
        ;
        System.out.print("\tPrice(g/vnd): ");
        newPrice=Integer.parseInt(sc.nextLine());
        this.add(new Drug(newID, newName, newPrice));
        System.out.println("New Drug has been added");
    }

    @Override
    public int find(String aId) {
        for(int i=0; i<this.size();i++){
            if(this.get(i).getID().equalsIgnoreCase(aId)) return i;
        }
        return -1;
    }

    @Override
    public void display() {
        if(this.size()==0){
            System.out.println("File rỗng");
            return;
        }
        System.out.println("-----------------------");
        System.out.println("ID\tName\t\tWeight and Price");
        for(Drug x: this){
            System.out.println(x);
        }
    }

    @Override
    public void update() {
        String newID;
        int tmp1,tmp2;
        //tmp1 dung de luu vi tri cua drug, sau do se dc dung de update  
        //tmp2 la de test duplicate o phia duoi
        boolean valid=false;
        System.out.println("Enter the ID of Drug you want to update...");
        do {  //check valid id          
            newID=sc.nextLine().toUpperCase();
            tmp1 = find(newID);
            valid = newID.matches("^T\\d{3}$");
            if(!valid) System.out.println("The ID is invalid! (**hint form ID: T+ 3 digits)");
        } while (!valid);
        if(tmp1<0) {
            System.out.println("ID Drug does not exist");
            return;
        }
        System.out.println("Start updating.....");
        Scanner sc=new Scanner(System.in);
        System.out.println("Old information: ");
        System.out.println(this.get(tmp1).toString());
        System.out.println("Enter new ID: ");
        do{
            //check valid id
            newID=sc.nextLine().toUpperCase();
            tmp2 = find(newID);
            valid = newID.matches("^T\\d{3}$");
            if(tmp2>=0) System.out.println("**ID is duplicated");
            if(!valid) System.out.println("The ID is invalid! (**hint form ID: T + 3 digits)");
        }while(tmp2>=0 || (!valid));
        this.get(tmp1).update();
    }

    @Override
    public void remove() {
        String rID;
        System.out.print("Enter ID Drug u want to remove: ");
        rID=sc.nextLine().toUpperCase();
        int tmp=find(rID);
        if(tmp<0) System.out.println("Drug is not existed!!");
        else{
            this.remove(tmp);
            System.out.println("Drug: " + this.get(tmp).getName()+"  ID: "+rID+" has been removed!");
        }
    }
    
}
