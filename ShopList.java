package javamysql;

import java.sql.*;
import static javamysql.FindParts.output;

public class ShopList {
    
    static String output;

    public ShopList() {
    }
    
    public  void queryStatement(Connection con) {
        try {
            Statement stmt = con.createStatement();
            String qry = "select * from mechanic";
            ResultSet rs = stmt.executeQuery(qry);

            output = ("List of Mechanics\nShopName\tCity\tSize(NoOfCars)\n");  
            while( rs.next()) { 
                output = output + ( rs.getString("shopName"));     
                output = output + ("\t" + rs.getString(2));          
                output = output + ("\t" + rs.getString(3));
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
