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
    private int birth;
    private long phone;
    private String address;

    public Information() {
    }

    public Information(String ID, String name, String sex, int birth, long phone, String address) {
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

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
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