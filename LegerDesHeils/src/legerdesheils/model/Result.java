/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils.model;

import java.awt.List;
import java.util.ArrayList;
import legerdesheils.model.db.Signaal;

/**
 *
 * @author test
 */
public class Result {
   // type , output, date 
    private String type;
    private ArrayList<Signaal> signals;
    
    public Result(String type, ArrayList<Signaal> signals) {
        this.type = type;
        this.signals = signals;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Signaal> getSignals() {
        return signals;
    }
}
