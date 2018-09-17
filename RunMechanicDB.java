
package javamysql;

import java.awt.Dimension;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JFrame;

public class RunMechanicDB {
    static Connection con;
    
    public RunMechanicDB() throws SQLException {
         
    }
    
    public static void main(String[] args) {
        
        try {
            
           Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
           con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_project_mechanic?user=root");
           System.out.println ("Database connection established");

           CarList sqlQuery = new CarList();
           sqlQuery.queryStatement(con);
        }
        catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage()); 
        }
        JFrame frame = new JFrame("Mechanic");
        frame.setMinimumSize(new Dimension(200, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        MechGui test = new MechGui();
        test.setVisible(true);
        frame.add(test);
    
    }
    
}
