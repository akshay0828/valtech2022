package com.valtech.training.corejava.day4;

import java.sql.*;
class jdbc{
    public static void main(String args[]) throws SQLException {
        Connection con = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
     
    	
            //System.out.println("jdbcurl=" + dbURL);
           // String strUserID = "valtrg6";
            //String strPassword = "valtrg6";
            con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.102.35:1521/xe","valtrg6","valtrg6");
            System.out.println("Connected to the database.");
            Statement stmt=con.createStatement();
            System.out.println("Executing query");
            ResultSet rs=stmt.executeQuery("SELECT * FROM emp");
            //while(rs.next())
                System.out.println(rs.getInt("1"));
            con.close();
        }catch(Exception e){ System.out.println(e);}
        finally {
            con.close();
        }
}
}


