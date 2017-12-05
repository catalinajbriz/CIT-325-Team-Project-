/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lotterys;

/**
 *
 * @author wwang2015
 * 
 */
public abstract class selectednumbers {
protected String snum1;
protected String snum2;
protected String snum3;
protected String snum4;
protected String snum5;
protected String snum6;

public selectednumbers (String snum1,String snum2,String snum3,String snum4,String snum5,String snum6)
{
    this.snum1 = snum1;
    this.snum2 = snum2;
    this.snum3 = snum3;
    this.snum4 = snum4;
    this.snum5 = snum5;
    this.snum6 = snum6;
}
public String gersnum1(){
    return snum1;
}
 
public void setsnum1(String snum1){
    this.snum1 = snum1;
}
public String gersnum2(){
    return snum2;
}
 
public void setsnum2(String snum1){
    this.snum2 = snum2;
}
    
public String gersnum3(){
    return snum3;
}
 
public void setsnum3(String snum3){
    this.snum3 = snum3;
}
    
public String gersnum4(){
    return snum4;
}
 
public void setsnum4(String snum4){
    this.snum4 = snum4;
}
    
public String gersnum5(){
    return snum5;
}
 
public void setsnum5(String snum5){
    this.snum5 = snum5;
}
    
public String gersnum6(){
    return snum1;
}
 
public void setsnum6(String snum1){
    this.snum6 = snum6;
}
    
}
    

    
