
package javamysql;

import java.sql.*;

public class FindParts {
    
    static String fName;
    static String lName;
    static String output;

    public FindParts() {
    }
    
    public  void queryStatement(Connection con) {
        try {
            String query = "select p.orderNum, p.partName, o.ownerID, o.fName, o.lName, p.quantity\n" +
                "from pOrder p join car c\n" +
                "on c.regNum = p.regNum\n" +
                "join owner o\n" +
                "on c.ownerID = o.ownerID\n" +
                "where o.fName = ? and o.lName = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,fName);
            pstmt.setString(2,lName);
           
            ResultSet rs = pstmt.executeQuery();
        
            output = "Parts for " + fName + " " + lName + "\norderNum\tpartName\townerID\tfName\tlName\tquantity\n";
            while( rs.next()) { 
                output = output + rs.getString("orderNum");
                output = output + ("\t" + rs.getString(2));          
                output = output + ("\t" + rs.getString(3));   
                output = output + ("\t" + rs.getString(4));
                output = output + ("\t" + rs.getString(5));
                output = output + ("\t" + rs.getString(6));
                output = output + ("\n");      
            }
            rs.close();
            pstmt.close();
        }
        catch (Exception io) {
                System.out.println("error"+io);
        }     
    }
}
