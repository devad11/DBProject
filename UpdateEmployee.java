
package javamysql;

import java.sql.*;

public class UpdateEmployee {
    static String empValue;
    static String empID;
    static String empChoice;
    static String output;

    public UpdateEmployee() {
        
    }
    
    public  void update(Connection con) {
        try {
            Statement updateStmt = con.createStatement();
            String updateSQL = " Update employee set " + empChoice + " = '" + empValue + "' where employeeID ='" + empID + "'";
            int res = updateStmt.executeUpdate(updateSQL);
            System.out.println("The Number or records updated is\t" + res);
            updateStmt.close();
        }
        catch (Exception io) {
            System.out.println("error"+io);
        }
    }
}
