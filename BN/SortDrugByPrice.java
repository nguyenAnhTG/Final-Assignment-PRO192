/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BN;

import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
public class SortDrugByPrice implements Comparator<Drug> {

    @Override
    public int compare(Drug a, Drug b) {
        if((a.getPrice()-b.getPrice())>0) return 1;
        else if((a.getPrice()-b.getPrice())==0) return 0;
        else return -1;
    }
    
}
