import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.*;
public class Family {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try{
			 	//loading of driver...
	            Class.forName("com.mysql.jdbc.Driver");
	            
	            //establishing the connection.... 
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ansaridb","root","789123");
	            
	            //create statement
	            Statement stmt=con.createStatement();
	            
	            //Executing the query
	            ResultSet rs=stmt.executeQuery("select * from Family");
	            while(rs.next()){
	            	String fnm=rs.getString(1);
	            	int age=rs.getInt(2);
	            	int boy=rs.getInt(3);
	            	String cr=rs.getString(4);

	            	System.out.println(fnm+"\t"+age+"\t"+boy+"\t"+cr);
	            }
	            con.close();
	            
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}

}
