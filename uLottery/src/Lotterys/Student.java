/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lotterys;


import java.io.Serializable;

public abstract class Student implements Serializable{
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected String PUID;
    protected String addr;
    protected String state;
    protected String zipCode;
    protected String country;

    public Student(String firstName, String middleName, String lastName, String PUID, String addr, String state, String zipCode, String country) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.PUID = PUID;
        this.addr = addr;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPUID() {
        return PUID;
    }

    public void setPUID(String PUID) {
        this.PUID = PUID;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
     
}
