package legerdesheils.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import legerdesheils.model.db.Signaal;
/**
 * orgineel gebruikt
 * 
 * Demonstration of connection setup to MySQL server with<br>
 * - 3x try/catch<br>
 * - Connection object, parameters in separate file "database.properties"<br>
 * - Statement object<br>
 * - ResultSet printed with method that reads the metadata and prints columns with headers
 *
 * @author W Pijnacker Hordijk
 * 
 * herschreven door 
 * 
 * @author SA Ragunath
 */

public class Database {
    private String propertiesFile ;
    private String qryUse;
    private Connection conn;
    private Statement stat;
    private int count;
    private ArrayList<Signaal> sinaallist;

    public Database(String p) {
        propertiesFile = p;
        count = 0;
        try {
            SimpleDataSource.init(propertiesFile);
            conn = SimpleDataSource.getConnection();
            System.out.println("verbinding gemaakt...");
        } 
        
        catch (SQLException e) {
            System.out.println("Fout: " + e.getMessage());
        }
        
        catch (IOException e) {
            System.out.println("Fout: kan " + propertiesFile + " niet openen.");
        }
        
        catch (ClassNotFoundException e) {
            System.out.println("Fout: JDBC-driver niet gevonden.");
        }
    }
    
    
    public void queryexe(String db,String qry,int type) throws SQLException{
        try {
            stat = conn.createStatement();

            qryUse = db;    

            stat.execute(qryUse);
            System.out.println("database gevonden...");

            String qrySelect = qry;
            ResultSet r = stat.executeQuery(qrySelect);
            
            for(int i =1; i<r.getMetaData().getColumnCount()+1; i++){
                System.out.println(i+" "+r.getMetaData().getColumnName(i));
            } 
            
            saveres(r, type); // map the result set and save it as a signal obj
            showResultSet(r);
            
            count++;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void saveres(ResultSet r, int type) throws SQLException{
        ResultSetMetaData metaData = r.getMetaData();   
        
        //for(int i=0; i< metaData.getColumnCount(); i++){
        while(r.next()){
            try{
                switch(type){
                case 1:
                    sinaallist.set(count, new Signaal(r.getInt("ID"),
                                            r.getInt("code"),
                                            null,
                                            null,
                                            "Medewerker"));
                    break;
                case 2:
                    sinaallist.set(count, new Signaal(0,
                                            0,
                                            r.getString("employeeUsername"),
                                            null,
                                            "AfasProfit-Export"));
                    break;
                case 3:
                    sinaallist.set(count, new Signaal(0,
                                            2,
                                            null,
                                            r.getString("username_pre2000"),
                                            "AD-Export"));
                    break;
                case 4:
                    sinaallist.set(count, new Signaal(0,
                                            2,
                                            null,
                                            r.getString("username_pre2000"),
                                            "AD-Export"));
                    break;
                case 5:
                    sinaallist.set(count, new Signaal(0,
                                            r.getInt("code"),
                                            r.getString("employeeUsername"),
                                            null,
                                            "AfasProfit-Export"));
                    break;
                case 6:
                    sinaallist.set(count, new Signaal(r.getInt("ID"),
                                            r.getInt("code"),
                                            null,
                                            null,
                                            "Medewerker"));
                    break;
                case 7:
                    sinaallist.set(count, new Signaal(r.getInt("ID"),
                                            r.getInt("code"),
                                            null,
                                            null,
                                            "Medewerker"));
                    break;
                case 8:
                    sinaallist.set(count, new Signaal(r.getInt("ID"),
                                            0,
                                            null,
                                            null,
                                            "Medewerker"));
                    break;
                case 9:
                    sinaallist.set(count, new Signaal(0,
                                            0,
                                            r.getString("employeeUsername"),
                                            null,
                                            "AfasProfit-Export"));
                    break;
                case 10:
                    sinaallist.set(count, new Signaal(0,
                                            0,
                                            r.getString("employeeUsername"),
                                            null,
                                            "AfasProfit-Export"));
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                
            }
            }catch(SQLException e){
                //System.out.println(e);
            }

/* id,  tabelid,  code,  employeeUsername,  username_pre2000 , afkomstVan
            try{
            sinaallist.set(count, new Signaal(r.getInt("id"),
                                            r.getInt("tabelid"),
                                            r.getInt("code"),
                                            r.getString("employeeUsername"),
                                            r.getString("username_pre2000"),
                                            r.getString("afkomstVan")));
            }catch(SQLException e){
                System.out.println(e);
            }*/
        }
    }
    
    public void closeconnection(){
        
        try {
            conn.close();
            System.out.println("... verbinding afgesloten.");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    /**
     * Prints a result set.
     * @param result the result set
     * @author W. Pijnacker Hordijk
     * source: BJLO
     */
    public static void showResultSet(ResultSet result) throws SQLException {
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();
        int columnGap = 1;
        int[] cWidths = new int[columnCount]; // array containing width per column

        // print the column label with gaps between columns using
        // either the label or width of the column, whichever is larger
        for (int i = 1; i <= columnCount; i++) {
            if (metaData.getColumnDisplaySize(i) > metaData.getColumnLabel(i).length()) {
                cWidths[i - 1] = metaData.getColumnDisplaySize(i) + columnGap;
            } else {
                cWidths[i - 1] = metaData.getColumnLabel(i).length() + columnGap;
            }

            System.out.format("%-" + cWidths[i - 1] + "s", metaData.getColumnLabel(i));
        }
        System.out.println();

        // print separation line between header and table rows
        for (int i = 1; i <= columnCount; i++) {
            for (int j = 1; j <= cWidths[i - 1] - columnGap; j++) {
                System.out.print("=");
            }
            for (int j = 1; j <= columnGap; j++){
                System.out.print(" ");
            }
        }
        System.out.println();

        // print the rows of the table
        // save the data 
        while (result.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.format("%-" + cWidths[i - 1] + "s", result.getString(i));
            }
            System.out.println();
        }
    }
}
