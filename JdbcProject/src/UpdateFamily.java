import java.sql.*;
import java.util.Scanner;
public class UpdateFamily {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
        System.out.println("Enter name whose record u want to update :");
        String name=s.next();
        System.out.println("Enter new age:");
        int age=s.nextInt();
        System.out.println("Enter new boy:");
        int boy=s.nextInt();
        
        try{
        	//loading of driver...
            Class.forName("com.mysql.jdbc.Driver");
            
            //establishing the connection.... 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ansaridb","root","789123");
            
            //create statement
            PreparedStatement pst=con.prepareStatement("update family set age=?, boy=?, where name=?");
           
            pst.setInt(1, age);
            pst.setInt(2,boy);
            pst.setString(3, name);
            
            //execute the query
            int rs = pst.executeUpdate();
            if(rs>0)
            	System.out.println("Record updated successfully...!");
            else
            	System.out.println("Record failed to update...!");
        }catch(Exception e){
        	e.printStackTrace();
        }

	}

}
