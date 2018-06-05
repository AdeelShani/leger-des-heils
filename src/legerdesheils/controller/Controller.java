/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils.controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import legerdesheils.model.Query;
import legerdesheils.model.Database;
import legerdesheils.view.Display;

/**
 * @author SA Ragunath 
 **/
public class Controller {
    private boolean running = false;
    private int state = 0;
    
    private Display display;
    
    private Database leger;
    private String legerdbfile = "database.properties"; 
   
    private Database signaalDb;
    private String signaaldbfile = "sinaal.properties";
   
    private Query qlist;
    
    public int width, height;
    public String title;
    
    public Controller(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }
    
    private void init(){
        display = new Display(title, width, height);
        leger = new Database(legerdbfile);
        signaalDb = new Database(signaaldbfile);
        qlist = new Query();
    }
    
    
    private void vindSignaal(){
       try {
            for(int i=0; i<qlist.getQlistSize(); i++){
                leger.queryexe("USE AuditBlackBox;",qlist.getQuery1(i),i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void vindImpact(){
        
    }
    
    private void sendQuery(){
        try {
            for(int i=0; i<qlist.getQlistSize(); i++){
                leger.queryexe("USE AuditBlackBox;",qlist.getQuery1(i),i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void start(){
        if(running){
                return;
                
        }else{
            running = true;
            init();
            loop();
        }
    }
    
    public void loop(){
            sendQuery();
    } 
}
