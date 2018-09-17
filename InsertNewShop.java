
package javamysql;

import java.sql.*;

public class InsertNewShop {

    static String mecName;
    static String mecCity;
    static String mecScale;
    
    public InsertNewShop() {
    }
    
     public  void insert(Connection con) {
        try {
            Statement insertStmt = con.createStatement();
            String insertSQL = " Insert into mechanic values ('" + mecName + "', '" + mecCity + "', '" + mecScale + "')";
            int res = insertStmt.executeUpdate(insertSQL);
            System.out.println("The Number or records inserted is      " +res);
            insertStmt.close();
       }
        catch (Exception io) {
            System.out.println("error"+io);
       }
    }
}
