
package javamysql;

import java.sql.*;

public class DeleteOrder {
    
    static String ordNum;
    static String output;
    
    public DeleteOrder() {
        
    }
    
     public  void delete(Connection con) {
        try {
            Statement deleteStmt = con.createStatement();
            String deleteSQL = " Delete from  porder where orderNum ='" + ordNum + "'";
            int res = deleteStmt.executeUpdate(deleteSQL);
            output = ("The Number or records deleted is\t" + res);  
            deleteStmt.close();
        }
        catch (Exception io) {
            System.out.println("error"+io);
       } 
     }   
}
