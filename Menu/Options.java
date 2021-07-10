
import java.util.Scanner;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Options extends Vector<String> {
    public Options() {
        super();
    }

    public int getUserChoice(){
        System.out.println(this.get(0));
        
        for(int i=1;i<this.size()-1;i++){
            System.out.println(i+" "+ (this.get(i)));
        }
        System.out.println(this.get(this.size()-1));
        System.out.println("\nSelect your choice....");
        
        Scanner sc=new Scanner(System.in);
        return sc.nextInt();
        
    }
}
