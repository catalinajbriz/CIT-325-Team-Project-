package cnit.pkg325.project;

import cnit.pkg325.project.PersonInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acall_000
 */
public class PersonProject implements PersonInterface{
    
    String name;
    Address address;
    String age;
    String birthdate;

    public PersonProject(String name, Address address, String age, String birthdate) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.birthdate = birthdate;
    }
    
    public void resetName(String name){
        this.name = name;
    }
    
    public PersonProject()
    {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    
    
    
}

