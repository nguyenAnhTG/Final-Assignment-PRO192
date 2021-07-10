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
import BN.Patient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Order extends Drug implements Function{
    Scanner sc = new Scanner(System.in);
    ArrayList list = new ArrayList();
    public Order() {
    } 

    @Override
    public void AddFromFile(String fName) {
        File f= new File(fName);
        if(!f.exists()) return;
        try {
            FileReader fr =  new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while((details=bf.readLine())!=null){
                StringTokenizer stk=new StringTokenizer(details,",");
                String ID=stk.nextToken().toUpperCase();
                String name=stk.nextToken().toUpperCase();
                String desease=stk.nextToken();
                String drug=stk.nextToken();
                list.add(ID + "," +name+ "," +desease+ "," +drug);
                
            }
            bf.close();fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void SaveToFile(String fName) {
        if(list.isEmpty()) {
            System.out.println("Arr rỗng");
            return;
        }
        File f=new File(fName);
        try {
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0; i<list.size();i++){
                pw.print(list.get(i)+"\n");
            }
            pw.close();fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addNewD(String aId, String aName, String aDes, Object m){
        System.out.println("\tName: " + aName);
        System.out.println("\tDesease: " + aDes);
        System.out.println("--Drug List: --");
        System.out.println("**Hint form: Drug name1(weight) - Drug name2(weight) ");
        String drug=sc.nextLine();
        list.add(aId+"," + aName+","+aDes+","+drug);
        
        System.out.println("Đơn thuốc đã được thêm!");
    }

    @Override //không cần
    public void addnew() {
    
    }

    @Override //không cần
    public int find(String aId) {
      return -1;
    }

    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
