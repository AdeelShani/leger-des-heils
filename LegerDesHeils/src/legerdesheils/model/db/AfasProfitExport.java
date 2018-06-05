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
public class AfasProfitExport {
    private String username,username_pre2000,parentcontainer,creationdate,modificationdate,nummer;
    private int disabled;
    
    public AfasProfitExport(String username,String username_pre2000,String parentcontainer,String creationdate,String modificationdate, int disabled, String nummer){
        this.username = username;
        this.username_pre2000 = username_pre2000;
        this.parentcontainer = parentcontainer;
        this.creationdate = creationdate;
        this.modificationdate = modificationdate;
        this.disabled = disabled;
        this.nummer = nummer;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsername_pre2000(){
        return username_pre2000;
    }
    
     public void setUsername2000(String username2000){
        this.username_pre2000 = username2000;
    }
     
    public String getParentcontainer(){
        return parentcontainer;
    }
    
    public void setParentconatiner(String parentcontainer){
        this.parentcontainer = parentcontainer;
    }
}
