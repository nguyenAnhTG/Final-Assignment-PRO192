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
import BV.DoctorList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderList  implements Function{

  
    Scanner sc = new Scanner(System.in);
    ArrayList<String> list=new ArrayList<>();
    
    //format du lieu cua 1 order nhu sau
    //orderID,patientID,doctorID,disease,name drug,price drug,quantity,totalPrice
    //rieng phan name drug,price drug,quantity co the dc lap lai nhieu lan
    
    public OrderList() {
    } 

    @Override
    public void AddFromFile(String fName) {
        String S="",nameDrug="",priceDrug="",quantity="",orderID,patientID,doctorID,dease;
        double totalPrice=0;
        File f= new File(fName);
        if(!f.exists()) return;
        try {
            FileReader fr =  new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while((details=bf.readLine())!=null){
                String[] arr=details.split(",");
                orderID=arr[0]+",";
                patientID=arr[1]+",";
                doctorID=arr[2]+",";
                dease=arr[3]+",";
                for(int i=4;i<arr.length-1;i+=3){
                    nameDrug=arr[i];
                    priceDrug=arr[i+1];
                    quantity=arr[i+2];
                    S+=nameDrug+","+priceDrug+","+quantity+",";
                }
                totalPrice=Double.parseDouble(arr[arr.length-1]);
                list.add(orderID+patientID+doctorID+dease+S+totalPrice);
                S="";

            }
            
            bf.close();fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OrderList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void SaveToFile(String fName) {
        if(list.isEmpty()) {
            System.out.println("List rỗng");
            return;
        }
        File f=new File(fName);
        try {
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0; i<list.size();i++){
                pw.print(list.get(i)+"\n");
            }
            System.out.println("Save to file successfully!");
            pw.close();fw.close();
        } catch (IOException ex) {
            Logger.getLogger(OrderList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void addNewOrder(DoctorList dList,PatientList pList, DrugList drList){
        Random rand= new Random();
        String patientID,doctorID,dease,drugID,s="",s1="";
        int quantity;
        boolean flag=true;
        
        double price,totalPrice=0;
          
            do {                
                String checkOrderID= "OD"+Integer.toString((int)Math.floor(Math.random()*(999-100+1)+100));
            if(checkOrderID(checkOrderID)) 
                continue;
            else{
                System.out.println("ID of that Order is (automatically generated): "+checkOrderID);
                s=checkOrderID;
                flag=false;
                }
            } while (flag);
                

                do {
                    
                    pList.display();
                    System.out.println("Enter the patient ID:");
                    patientID=sc.nextLine().toUpperCase();
                    if(pList.find(patientID)<0){
                        System.out.println("This patient id does not exist");
                    }
                    else{
                        s+=","+patientID;
                        flag=false;
                    }
                } while (flag);
                
                
                
                flag=true;
                
                
                do {    
                    dList.display();
                    System.out.println("Enter the Doctor ID:");
                    doctorID=sc.nextLine().toUpperCase();
                    if(dList.find(doctorID)<0){
                        System.out.println("This Doctor id does not exist");

                    }
                    else{
                        s+=","+doctorID;
                        flag=false;
                    }
                } while (flag);
                
                
                flag=true;
                s+=","+pList.getDeseaseP(patientID);
                
                
                
                do {
                    System.out.println("Choose the drug and the quantity:");
                    drList.display();
                    System.out.println("Enter the Drug ID:");
                    drugID=sc.nextLine().toUpperCase();
                    if(drList.find(drugID)<0){
                        System.out.println("This Drug id does not exist");
                        
                    }
                    else{
                        s1+=","+drList.get(drList.find(drugID)).getName().toUpperCase();
                        s1+=","+drList.get(drList.find(drugID)).getPrice();
                        System.out.println("Enter the quantity:");
                        quantity=sc.nextInt();
                        s1+=","+quantity;
                        price=drList.get(drList.find(drugID)).getPrice()*quantity;
                        totalPrice+=price;
                        System.out.println("Do you want to add more drug? (Y/N)");
                        sc=new Scanner(System.in);
                        char answer=sc.nextLine().toUpperCase().charAt(0);
                        if(answer=='N')
                            flag=false;
                        if(answer=='Y')
                            flag=true;
                    }
                } while (flag);
                s=s+s1+","+totalPrice;
                list.add(s);
                System.out.println("A new order has been added successfully!");
                //orderID,patientID,doctorID,disease,name drug,price drug,quantity,totalPrice

    }
    
    public boolean checkOrderID(String givenID){
        for(int i=0;i<list.size();i++){
            if(givenID.equals(list.get(i).substring(0, 5))) return true;
        }
        return false;
    }
    
    public boolean checkPatientID(String givenID){
        for(int i=0;i<list.size();i++){
            if(givenID.equals(list.get(i).substring(6, 11))) return true;
        }
        return false;
    
    }
    
    public void displayAnOrderByID(){
        System.out.println("Enter the Order ID: ");
        String givenID=sc.nextLine().toUpperCase();
        if(!checkOrderID(givenID))
            System.out.println("This Order id does not exist");
        else{
            System.out.println("-==================================INFORMATION OF THIS ORDER==================================-\n");
            for(int i=0;i<list.size();i++){
                if(givenID.equals(list.get(i).substring(0, 5))){
                    FormatDisplay(list.get(i));
                    break;
                }
                    
            }
            System.out.println("-=============================================================================================-\n");
        }
    }
    
    public void displayOrdersByPatientID(){
        System.out.println("Enter the Patient ID: ");
        String givenID=sc.nextLine().toUpperCase();
        if(!checkPatientID(givenID))
            System.out.println("This Patient id does not exist");
        else{
            System.out.println("-===========================DISPLAY ALL ORDERS BY PATIENT ID===================================-\n");
            for(int i=0;i<list.size();i++){
                if(givenID.equals(list.get(i).substring(6, 11)))
                    FormatDisplay(list.get(i));
            }
            System.out.println("-=============================================================================================-\n");
        }
    }
    
    public void displayallOrderss(){
        System.out.println("-==================================INFORMATION OF ALL ORDERS==================================-\n");
        for(int i=0;i<list.size();i++){
            FormatDisplay(list.get(i));
        }
        System.out.println("-=====================================================================================================-\n");
    }
    
    public void FormatDisplay(String s){
        String[] arr=s.split(",");
        System.out.format("%-10s%-15s%-15s%-20s\n","ORDERID","PATIENTID","DOCTORID","DISEASE");
        System.out.format("%-10s%-15s%-15s%-20s\n\n",arr[0],arr[1],arr[2],arr[3]);
        System.out.format("%-15s%-10s%-5s\n","NAMEDRUG","PRICE","QUANTITY");
        for (int i = 4; i < arr.length-1;i+=3 ) {
            System.out.format("%-15s%-10s%-5s\n",arr[i],arr[i+1],arr[i+2]);
        }
        System.out.format("\n%-10s","TOTAL PRICE\n");
        System.out.format("%-10s\n\n\n",arr[arr.length-1]);
    }

    @Override //không cần
    public void addnew() {
        
    }

    @Override //không cần vi co 2 ham checkPatientID va checkOrderID roi
    public int find(String aId) {
      return -1;
    }

    @Override// khong can vi co 2 ham display phia tren roi
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //khong can 
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove() {
        String givenID="";
        System.out.println("Enter the Order ID");
        givenID=sc.nextLine().toUpperCase();
        if(!checkOrderID(givenID))
            System.out.println("This Order id does not exist");
        else{
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                if(((String)iter.next()).substring(0, 5).equals(givenID)){
                    iter.remove();
                    System.out.println("Order " + givenID+" has been removed successfully!");
                    break;
                }
                
            }
       
        }
 
    }

    @Override
    public boolean checkID(String givenID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String autoGenerateID(String typeID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
