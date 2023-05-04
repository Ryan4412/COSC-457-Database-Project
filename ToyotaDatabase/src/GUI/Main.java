import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.Clock;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {
        new GUI();
        
        //Basic code from lab 2 to display the appointments table for now
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }
        
        final String ID = "rkraft3";
        final String PW = "COSC*54rac";
        final String SERVER = "jdbc:mysql://triton.towson.edu:3360/?serverTimezone=EST#/rkraft3db?useSSL=false";
        //String querys;
        
        try {
            Connection con = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM rkraft3db.DBP_APPOINTMENT");
            //PreparedStatement updateStaff = null;
            
            while (rs.next()){
                String row = "";
                try {
                    int columnIndex = 1;
                    while (true) {
                        row += ", " + rs.getString(columnIndex);
                        columnIndex++;
                    }
                }
                catch (SQLException e) {
                    System.out.println(row);
                }

                    // String appointmentNum = rs.getString("APPOINTMENT_NUM");
                // String customerSSN = rs.getString("CUSTOMER_SSN");
                // String status = rs.getString("STATUS");
                // String type = rs.getString("TYPE");
                // String rep = rs.getString("REP_SSN");
                // System.out.println(appointmentNum+", "+customerSSN+", "+status+", "+ type + ", " + rep);
                
            }
            // querys = "UPDATE qwang12db.Branch SET status = 'Baltimore' WHERE branchNo = 'B002';";
            // updateStaff = con.prepareStatement(querys);
            // updateStaff.executeUpdate();

        }catch (SQLException e){
            System.err.println(e);
        }
    }

}
