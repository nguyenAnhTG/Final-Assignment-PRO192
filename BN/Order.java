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
public class Order {
    private String orderID, patientID,doctorID,drugID,diease,nameDrug;
    private double priceDrug,totalPrice,temporaryPrice;
    private int quantity;

    public String getDiease() {
        return diease;
    }

    public void setDiease(String diease) {
        this.diease = diease;
    }
    
    

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public String getNameDrug() {
        return nameDrug;
    }

    public void setNameDrug(String nameDrug) {
        this.nameDrug = nameDrug;
    }

    public double getPriceDrug() {
        return priceDrug;
    }

    public void setPriceDrug(double priceDrug) {
        this.priceDrug = priceDrug;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTemporaryPrice() {
        return temporaryPrice;
    }

    public void setTemporaryPrice(double temporaryPrice) {
        this.temporaryPrice = temporaryPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
    
}
