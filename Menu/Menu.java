import BN.Patient;
import BN.PatientList;
import BV.Doctor;
import BV.DoctorList;
import BN.Drug;
import BN.DrugList;
import BN.Order;
import BN.SortDrugByPrice;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.util.Collections;

import java.util.Scanner;

public class Menu {

    static void menuMain() {
        System.out.println("-==========Menu==========-");
        System.out.println("-= 1. QL Bác sĩ         =-");
        System.out.println("-= 2. QL Bệnh Nhân      =-");
        System.out.println("-= 3. QL Thuốc          =-");
        System.out.println("-= 4. Exit              =-");
        System.out.println("-========================-");
    }

    static void menuSub(int luachon) {
        switch (luachon) {
            case 1:
                System.out.println("-==========QL Bác sĩ==========-");
                System.out.println("-= 1. Thêm Bác sĩ mới        =-");
                System.out.println("-= 2. Xóa Bác sĩ             =-");
                System.out.println("-= 3. Hiển thị tất cả Bác sĩ =-");
                System.out.println("-= 4. Lưu vào File           =-");
                System.out.println("-= 5. Trở lại                =-");
                System.out.println("-=============================-");
                break;
            case 2:
                System.out.println("-==========QL Bệnh nhân==========-");
                System.out.println("-= 1. Thêm Bệnh nhân mới        =-");
                System.out.println("-= 2. Viết đơn thuốc            =-");
                System.out.println("-= 3. Xóa Bệnh nhân(nếu cần)    =-");
                System.out.println("-= 4. Hiển thị tất cả BN        =-");
                System.out.println("-= 5. Lưu vào File              =-");
                System.out.println("-= 6. Trở lại                   =-");
                System.out.println("-================================-");
                break;
            case 3:
                System.out.println("-==========  QL Thuốc  ==========-");
                System.out.println("-= 1. Thêm Thuốc mới            =-");
                System.out.println("-= 2. Xóa Thuốc(nếu cần)        =-");
                System.out.println("-= 3. Hiển thị tất cả số Thuốc  =-");
                System.out.println("-= 4. Lưu vào File              =-");
                System.out.println("-= 5. Trở Lại                   =-");
                System.out.println("-================================-");
                break;
        }
    }

    public static void main(String[] args) {
        String fileDoctor = "Doctors.txt";
        String fileDrug = "Drugs.txt";
        String filePatient = "Patiens.txt";
        String fileDon = "Orders.txt";

        PatientList lPatient = new PatientList();
        DrugList lDrug = new DrugList();
        DoctorList lDoctor = new DoctorList();
        Order lDon = new Order();

        lDoctor.AddFromFile(fileDoctor);
        lPatient.AddFromFile(filePatient);
        lDrug.AddFromFile(fileDrug);
        lDon.AddFromFile(fileDon);

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
        options0.add("-=    Exit              =-");
        options0.add("-========================-");
        
        
        options1.add("-==========QL Bác sĩ==========-");
        options1.add("-=      Thêm Bác sĩ mới        =-");
        options1.add("-=      Xóa Bác sĩ             =-");
        options1.add("-=      Update Bác sĩ             =-");
        options1.add("-=      Hiển thị tất cả Bác sĩ =-");
        options1.add("-=      Lưu vào File           =-");
        options1.add("-=      Trở lại                =-");
        options1.add("-=============================-");
        
        
        options2.add("-==========QL Bệnh nhân==========-");
        options2.add("-=        Thêm bệnh nhân mới        =-");
        options2.add("-=        Xóa Bệnh nhân(nếu cần)    =-");
        options2.add("-=        Update bệnh nhân        =-");
        options2.add("-=        Hiển thị tất cả BN        =-");
        options2.add("-=        Lưu vào File              =-");
        options2.add("-=        Trở lại                   =-");
        options2.add("-================================-");

                
        options3.add("-==========  QL Thuốc  ==========-");
        options3.add("-=        Thêm Thuốc mới            =-");
        options3.add("-=        Xóa Thuốc(nếu cần)        =-");
        options3.add("-=        Update Thuốc mới            =-");
        options3.add("-=        Hiển thị tất cả số Thuốc  =-");
        options3.add("-=        Sắp xếp các loại thuốc theo thứ tự tăng dần của giá             =-");
        options3.add("-=        Lưu vào File              =-");
        options3.add("-=        Trở Lại                   =-");
        options3.add("-================================-");
        
        Scanner sc=new Scanner(System.in);

        do {

            choice=options0.getUserChoice();
            if (choice == 4) {
                return;
            }


            boolean dem = true;

            do {
                //choice la chon menu lon, luachon la chon menu nho

                if (choice == 1) {
                    luachon=options1.getUserChoice();
                    switch (luachon) {
                        case 1:
                            lDoctor.addnew();
                            dem = true;
                            break;
                        case 2:
                            lDoctor.remove();
                            dem = true;
                            break;
                        case 3:
                            lDoctor.update();
                            dem=true;
                            break;
                        case 4:
                            lDoctor.display();
                            dem=true;
                            break;
                        case 5:
                            lDoctor.SaveToFile(fileDoctor);
                            dem = false;
                            break;
                        default:
                            luachon = -1;
                            if (dem) {
                                System.out.print("Bạn muốn lưu vào file không(C/K)? ");
                                //Scanner sc1 = new Scanner(System.in);
                                ans = sc.nextLine().toUpperCase();
                                if (ans.startsWith("C")) {
                                    lDoctor.SaveToFile(fileDoctor);
                                }
                                System.out.println("Đã được lưu vào File!!");
                            }
                            break;

                    }
                } else if (choice == 2) {
                    //System.out.println("code Quản lý BN");
                    luachon=options2.getUserChoice();
                            
                    switch (luachon) {
                        case 1:
                            lPatient.addnew();
                            dem = true;
                            break;
                        case 2:
                            lPatient.remove();
                            dem = true;
                            break;
                        case 3:
                            lPatient.update();
                            dem=true;
                            break;
                        case 4:
                            lPatient.display();
                            break;
                        case 5:
                            lPatient.SaveToFile(filePatient);
                            lDon.SaveToFile(fileDon);
                            dem = false;
                            break;
                        default:
                            luachon = -1;
                            if (dem) {
                                System.out.print("Bạn có muốn lưu vào File không(C/K)? ");
                                ans = sc.nextLine().toUpperCase();
                                if (ans.startsWith("C")) {
                                    lPatient.SaveToFile(filePatient);
                                    lDon.SaveToFile(fileDon);
                                }
                                System.out.println("Đã được lưu vào File!!");
                            }
                            break;
                    }
                } else if (choice == 3) {
                    //System.out.println("code QL thuốc");
                    luachon=options3.getUserChoice();

                    switch (luachon) {
                        case 1: //thêm thuốc
                            lDrug.addnew();
                            dem = true;
                            break;
                        case 2: // xóa thuốc
                            lDrug.remove();
                            dem = true;
                            break;
                        case 3: // xóa thuốc
                            lDrug.update();
                            dem = true;
                            break;
                        case 4: //hiển thị
                            lDrug.display();
                            break;
                        case 5:
                            Collections.sort(lDrug, new SortDrugByPrice());
                            lDrug.display();
                            dem = true;
                            break;
                        case 6: //lưu file
                            lDrug.SaveToFile(fileDrug);
                            dem = false;
                            break;
                        default: // Back
                            luachon = -1;
                            if (dem) {
                                System.out.print("Bạn có muốn lưu vào File không(C/K)? ");

                                ans = sc.nextLine().toUpperCase();
                                if (ans.startsWith("C")) {
                                    lDrug.SaveToFile(fileDrug);
                                }
                                System.out.println("Đã được lưu vào File!!");
                            }
                            break;
                    }

                } else {
                    tmp = false;
                    return;
                }
                System.out.println("\n");
            } while (luachon > 0 && luachon < 7);
            System.out.println("\n\n\n");
        } while (tmp = true);

    }
}
