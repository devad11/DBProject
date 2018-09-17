
package javamysql;

import java.sql.*;
import static javamysql.FindParts.output;

public class EmployeeList {
    
    static String output;

    public EmployeeList() {
    }
    
    public  void queryStatement(Connection con) {
        try {
            Statement st = con.createStatement();
            String qry = "select * from employee where employeeID = " + UpdateEmployee.empID;
            ResultSet rs = st.executeQuery(qry);
        
            output = ("List of Employees\nemployeeID\tfName\tlName\twage\tposition\tpNum\tworkplace\n");  
            while( rs.next()) { 
                output = output + ( rs.getString("employeeID"));     
                output = output + ("\t" + rs.getString(2));          
                output = output + ("\t" + rs.getString(3));
                output = output + ("\t" + rs.getString(4)); 
                output = output + ("\t" + rs.getString(5)); 
                output = output + ("\t" + rs.getString(6));
                output = output + ("\t" + rs.getString(7)); 
                output = output + ("\n");      
            }
        rs.close();
        st.close();
        }
        catch (Exception io) {
                System.out.println("error"+io);
        }  
    }   
}
