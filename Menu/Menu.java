/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
import BN.*;
import BV.*;
import BV.DoctorList;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.util.Collections;

import java.util.Scanner;
import java.util.Vector;

public class Menu {


    public static void main(String[] args) {
        String fileDoctors = "Doctors.txt";
        String fileDrugs = "Drugs.txt";
        String filePatients = "Patiens.txt";
        String fileOrders = "Orders.txt";

        PatientList lPatients = new PatientList();
        DrugList lDrugs = new DrugList();
        DoctorList lDoctors = new DoctorList();
        OrderList lOrders = new OrderList();
                

        lDoctors.AddFromFile(fileDoctors);
        lPatients.AddFromFile(filePatients);
        lDrugs.AddFromFile(fileDrugs);
        lOrders.AddFromFile( fileOrders);

        boolean tmp = true;
        int luachon,choice;
        String ans;
        
        Options options0= new Options();
        Options options1= new Options();
        Options options2= new Options();
        Options options3= new Options();
        Options options4= new Options();
        
        options0.add("-==========Menu==========-");
        options0.add("-=    QL Bác sĩ         =-");
        options0.add("-=    QL Bệnh Nhân      =-");
        options0.add("-=    QL Thuốc          =-");
        options0.add("-=    QL Đơn thuốc      =-");
        options0.add("-=    Exit              =-");
        options0.add("-========================-");
        
        
        options1.add("-==========QL Bác sĩ==========-");
        options1.add("-=      Thêm Bác sĩ mới        =-");
        options1.add("-=      Xóa Bác sĩ             =-");
        options1.add("-=      Update Bác sĩ          =-");
        options1.add("-=      Hiển thị tất cả Bác sĩ =-");
        options1.add("-=      Lưu vào File           =-");
        options1.add("-=      Trở lại                =-");
        options1.add("-=============================-");
        
        
        options2.add("-==========QL Bệnh nhân==========-");
        options2.add("-=        Thêm bệnh nhân mới        =-");
        options2.add("-=        Xóa Bệnh nhân             =-");
        options2.add("-=        Update bệnh nhân          =-");
        options2.add("-=        Hiển thị tất cả BN        =-");
        options2.add("-=        Lưu vào File              =-");
        options2.add("-=        Trở lại                   =-");
        options2.add("-================================-");

                
        options3.add("-===================================  QL Thuốc  ===================================-");
        options3.add("-=                    Thêm Thuốc mới                                              =-");
        options3.add("-=                    Xóa Thuốc                                                   =-");
        options3.add("-=                    Update Thuốc mới                                            =-");
        options3.add("-=                    Hiển thị tất cả các loại Thuốc                              =-");
        options3.add("-=                    Sắp xếp các loại th1uốc theo thứ tự tăng dần của giá        =-");
        options3.add("-=                    Lưu vào File                                                =-");
        options3.add("-=                    Trở Lại                                                     =-");
        options3.add("-==================================================================================-");
        
        options4.add("-===================================  QL Đơn thuốc  ===================================-");
        options4.add("-=                    Thêm Đơn thuốc mới                                              =-");
        options4.add("-=                    Hiển thị thông tin 1 Đơn thuốc theo ID của đơn                  =-");
        options4.add("-=                    Hiển thị thông tin tất cả Đơn thuốc theo ID của bệnh nhân       =-");
        options4.add("-=                    Hiển thị thông tin tất cả Đơn thuốc                             =-");
        options4.add("-=                    Xóa 1 Đơn thuốc                                                 =-");
        options4.add("-=                    Lưu vào File                                                    =-");
        options4.add("-=                    Trở lại                                                         =-");
        options4.add("-======================================================================================-");
                
        Scanner sc=new Scanner(System.in);

        do {

            choice=options0.getUserChoice();
            //options0 la menu chinh

            boolean dem = true;

            do {
                //choice la chon menu lon, luachon la chon menu nho

                if (choice == 1) {
                    luachon=options1.getUserChoice();
                    switch (luachon) {
                        case 1:
                            lDoctors.addnew();
                            dem = true;
                            break;
                        case 2:
                            lDoctors.remove();
                            dem = true;
                            break;
                                    
                        case 3:
                            lDoctors.update();
                            dem=true;
                            break;
                        case 4:
                            lDoctors.display();
                            dem=true;
                            break;
                        case 5:
                            lDoctors.SaveToFile(fileDoctors);
                            dem = false;
                            break;
                        default:
                            luachon = -1;
                            defaultMethod(dem, "Doctor", lDoctors, fileDoctors);
                            break;

                    }
                } else if (choice == 2) {
                    //System.out.println("code Quản lý BN");
                    luachon=options2.getUserChoice();
                            
                    switch (luachon) {
                        case 1:
                            lPatients.addnew();
                            dem = true;
                            break;
                        case 2:
                            lPatients.remove();
                            dem = true;
                            break;
                        case 3:
                            lPatients.update();
                            dem=true;
                            break;
                        case 4:
                            lPatients.display();
                            break;
                        case 5:
                            lPatients.SaveToFile(filePatients);
                            
                            dem = false;
                            break;
                        default:
                            luachon = -1;
                            
                            defaultMethod(dem, "Patient", lPatients, filePatients);
                            
                            break;
                    }
                } else if (choice == 3) {
                    //System.out.println("code QL thuốc");
                    luachon=options3.getUserChoice();

                    switch (luachon) {
                        case 1: //thêm thuốc
                            lDrugs.addnew();
                            dem = true;
                            break;
                        case 2: // xóa thuốc
                            lDrugs.remove();
                            dem = true;
                            break;
                        case 3: // xóa thuốc
                            lDrugs.update();
                            dem = true;
                            break;
                        case 4: //hiển thị
                            lDrugs.display();
                            break;
                        case 5:
                            Collections.sort(lDrugs, new SortDrugByPrice());
                            lDrugs.display();
                            dem = true;
                            break;
                        case 6: //lưu file
                            lDrugs.SaveToFile(fileDrugs);
                            dem = false;
                            break;
                        default: // Back
                            luachon = -1;
                            
                            defaultMethod(dem, "Drug", lDrugs, fileDrugs);
                            
                            break;
                    }

                } else if(choice==4) {
                    luachon=options4.getUserChoice();
                    switch(luachon){
                        case 1: 
                            lOrders.addNewOrder(lDoctors, lPatients, lDrugs);
                            dem=true;
                            break;
                        case 2:
                            lOrders.displayAnOrderByID();
                            dem=true;
                            break;
                        case 3:
                            lOrders.displayOrdersByPatientID();
                            dem=true;
                            break;
                        case 4:
                            lOrders.displayallOrderss();
                            dem=true;
                            break;
                        case 5:
                            lOrders.remove();
                            dem=true;
                            break;
                        case 6:
                            lOrders.SaveToFile(fileOrders);
                            dem=false;
                            break;
                        default:
                            luachon=-1;
                                    
                            defaultMethod(dem, "Order", lOrders, fileOrders);
                            
                            break;
                            }
                    }
                else{
                    
                    tmp = false;
                    return;
                }
                System.out.println("\n");
            } while (luachon > 0 && luachon < 7);//while nay la cho submenu, neu bien lua chon k thoa man thi se out ra menu lon
            System.out.println("\n\n\n");
        } while (tmp = true);//while nay la cho mainmenu, neu tmp =false tuc la choice > 4 thi se out chuong tring luon

    }
    
    public static void defaultMethod(boolean dem,String type,Object list,String fileName){
        String ans;
        Scanner sc=new Scanner(System.in);
        if(dem==false) return;
        else{
            System.out.print("Do you want to save to the file? (Y/N) ");

            ans = sc.nextLine().toUpperCase();
            if (ans.startsWith("Y")) {
                if(type.equals("Doctor")){
                    ((DoctorList) list).SaveToFile(fileName);
    
                }
                else if(type.equals("Patient")){
                    ((PatientList) list).SaveToFile(fileName);
                    
                }
                else if(type.equals("Drug")){
                    ((DrugList) list).SaveToFile(fileName);
                    
                }
                else
                    ((OrderList)list).SaveToFile(fileName);
            
            }
            
        }
    }
}