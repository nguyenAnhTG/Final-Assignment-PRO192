/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sub;

/**
 *
 * @author ADMIN
 */
public class Information {
    private String ID;  
    private String name;
    private String sex;
    private long birth;
    private int phone;
    private String address;

    public Information() {
    }

    public Information(String ID, String name, String sex, long birth, int phone, String address) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.phone = phone;
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getBirth() {
        return birth;
    }

    public void setBirth(long birth) {
        this.birth = birth;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return getID() + "\t" + getName() + "\t\t\t" + getSex() + " | " + getBirth() + " | " + getPhone() + " | " + getAddress() ;
    }
    
    
    
}