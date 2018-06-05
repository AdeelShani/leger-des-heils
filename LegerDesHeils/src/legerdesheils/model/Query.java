/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils.model;
import java.util.*;
/**
 *
 * @author test
 */
public class Query {
    ArrayList<String> querys;
    
    
    public Query(){
        querys = new ArrayList<String>();
    
    querys.add("SELECT P.ID, PC.Code\n" +
                    "FROM Medewerker W\n" +
                    "JOIN Persoon P\n" +
                    "ON W.PersoonID = P.ID\n" +
                    "JOIN PersoonCodes PC\n" +
                    "ON P.ID = PC.PersoonID\n" +
                    "JOIN [AD-Export] A\n" +
                    "ON PC.Code = A.Username_Pre2000\n" +
                    "WHERE PC.Code != 'Andere Code'\n" +
                    "AND A.Disabled = 0\n" +
                    "AND PC.CodesoortenID != 981");
    querys.add("SELECT EmployeeUsername\n" +
                    "FROM [AfasProfit-Export] AFAS\n" +
                    "JOIN [AD-Export] AD\n" +
                    "ON AFAS.EmployeeUsername = AD.Username_Pre2000\n" +
                    "WHERE AD.Disabled = 0\n" +
                    "AND AFAS.ContractEndDate > ContractStartDate");
    querys.add("SELECT Username_Pre2000 FROM [AD-Export] WHERE Username_Pre2000 NOT IN (SELECT PC.Code FROM Medewerker M JOIN Persoon ON P.ID = M.PersoonID JOIN PersoonCodes PC ON PC.PersoonID = P.ID)");
    querys.add("SELECT Username_Pre2000\n" +
                    "FROM [AD-Export]\n" +
                    "WHERE Username_Pre2000 NOT IN\n" +
                    "(SELECT EmployeeUsername\n" +
                    "FROM [AfasProfit-Export]\n" +
                    "WHERE Username_Pre2000 = EmployeeUsername)");
    querys.add("SELECT P.ID, AFAS.EmployeeUsername\n" +
                    "FROM [AfasProfit-Export] AFAS\n" +
                    "JOIN PersoonCodes PC\n" +
                    "ON AFAS.EmployeeUsername = PC.Code\n" +
                    "JOIN Persoon P\n" +
                    "ON PC.PersoonID = P.ID\n" +
                    "WHERE AFAS.ContractEndDate > AFAS.ContractStartDate\n" +
                    "AND PC.CodesoortenID = 981");
    querys.add("SELECT P.ID, PC.Code\n" +
                    "FROM Medewerker M\n" +
                    "JOIN Persoon P\n" +
                    "ON M.PersoonID = P.ID\n" +
                    "JOIN PersoonCodes PC\n" +
                    "ON P.ID = PC.PersoonID\n" +
                    "WHERE Code NOT IN\n" +
                    "(SELECT Username_Pre2000 \n" +
                    "FROM [AD-Export]\n" +
                    "WHERE Code not like '%Andere Code%')");
    querys.add("SELECT P.ID, PC.Code\n" +
                    "FROM Medewerker M\n" +
                    "JOIN Persoon P\n" +
                    "ON P.ID = M.PersoonID\n" +
                    "JOIN PersoonCodes PC\n" +
                    "ON P.ID = PC.PersoonID\n" +
                    "LEFT JOIN [AfasProfit-Export] AFAS\n" +
                    "ON AFAS.EmployeeUsername = PC.Code\n" +
                    "WHERE AFAS.EmployeeUsername IS NULL\n" +
                    "AND PC.Code != 'Andere Code'");
    querys.add("SELECT P.ID\n" +
                    "FROM Medewerker M\n" +
                    "JOIN Persoon P\n" +
                    "ON M.PersoonID = P.ID\n" +
                    "JOIN PersoonCodes PC\n" +
                    "ON P.ID = PC.PersoonID\n" +
                    "WHERE PC.Code = 'Andere Code'\n" +
                    "OR PC.Code IS NULL");
    querys.add("SELECT EmployeeUsername baAccount \n" +
                    "FROM [AfasProfit-Export] \n" +
                    "WHERE [EmployeeUsername] NOT IN \n" +
                    "(\n" +
                    "SELECT [Username_Pre2000] \n" +
                    "FROM [AD-Export] \n" +
                    "WHERE [Username_Pre2000] = [EmployeeUsername])");
    querys.add("SELECT EmployeeUsername baAccount \n" +
                    "FROM [AfasProfit-Export] \n" +
                    "WHERE [EmployeeUsername] NOT IN \n" +
                    "(\n" +
                    "SELECT [Username_Pre2000] \n" +
                    "FROM [AD-Export] \n" +
                    "WHERE [Username_Pre2000] = [EmployeeUsername])");
    
    }
    public String getQuery1(int i){
        return querys.get(i);
    }
    
    public int getQlistSize(){
        return querys.size();
    }
}
