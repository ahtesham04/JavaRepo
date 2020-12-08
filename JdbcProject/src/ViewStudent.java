import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ViewStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try{
			 	//loading of driver...
	            Class.forName("com.mysql.jdbc.Driver");
	            
	            //establishing the connection.... 
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","789123");
	            
	            //create statement
	            Statement stmt=con.createStatement();
	            
	            //Executing the query
	            ResultSet rs=stmt.executeQuery("select * from student");
	            while(rs.next()){
	            	int id=rs.getInt(1);
	            	String fnm=rs.getString(2);
	            	String cr=rs.getString(3);
	            	float mk=rs.getFloat(4);
	            	System.out.println(id+"\t"+fnm+"\t"+cr+"\t"+mk);
	            }
	            con.close();
	            
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}

}