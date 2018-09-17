
package javamysql;

import java.sql.*;
import static javamysql.FindParts.output;

public class CarList {
    
    static String output;

    public CarList() {
    }
    
    public  void queryStatement(Connection con) {
        try {
            Statement stmt = con.createStatement();
            String qry = "select * from car";
            ResultSet rs = stmt.executeQuery(qry);

            output = ("List of Cars\nregNum\tbrand\ttype\tyear\townerID\temployeeID\n");  
            while( rs.next()) { 
                output = output + ( rs.getString("regNum"));     
                output = output + ("\t" + rs.getString(2));          
                output = output + ("\t" + rs.getString(3));
                output = output + ("\t" + rs.getString(4)); 
                output = output + ("\t" + rs.getString(5)); 
                output = output + ("\t" + rs.getString(6)); 
                output = output + ("\n");      
            }
        rs.close();
        stmt.close();
        }
        catch (Exception io) {
                System.out.println("error"+io);
        }  
    }   
}
