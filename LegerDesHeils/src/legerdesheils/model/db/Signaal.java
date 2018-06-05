/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils.model.db;

/**
 *
 * @author test
 */
public class Signaal {
    private int id, tabelid,code;
    private String employeeusername,username_pre2000,afkomstVan;
   
    public Signaal(int tabelid, int code, String employeeUsername, String username_pre2000 ,String afkomstVan){
        this.tabelid = tabelid;
        this.username_pre2000 = username_pre2000;
        this.employeeusername = employeeUsername; // baacount 
        this.code = code;
        this.afkomstVan = afkomstVan;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getTabelid(){
        return tabelid;
    }
    
    public void setTabelid(int tabelid){
        this.tabelid = tabelid;
    }
    
    public int getCode(){
        return code;
    }
    
    public void setCode(int code){
        this.code = code;
    }
    
    public String getEmployeeusername(){
        return employeeusername;
    }
    
    public void setEmployeeusername(String employee){
        this.employeeusername = employee;
    }
    
    public String getUsername_pre2000(){
        return username_pre2000;
    }
    
     public void setUsername2000(String username2000){
        this.username_pre2000 = username2000;
    }
     
    public String getAfkomstVan(){
        return afkomstVan;
    }
    
    public void setAfkomstVan(String afkomst){
        this.afkomstVan = afkomst;
    }
}
