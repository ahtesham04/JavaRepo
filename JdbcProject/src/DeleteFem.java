import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteFem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
        System.out.println("Enter name whose record u want to delete :");
        String name=s.next();
       
        try{
        	//loading of driver...
            Class.forName("com.mysql.jdbc.Driver");
            
            //establishing the connection.... 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ansaridb","root","789123");
            
            //create statement
            PreparedStatement pst=con.prepareStatement("delete from family where name=?");
            pst.setString(1,name);
            
            //execute the query
            int rs = pst.executeUpdate();
            if(rs>0)
            	System.out.println("Record deleted successfully...!");
            else
            	System.out.println("Record failed to delete...!");
        }catch(Exception e){
        	e.printStackTrace();
        }

	}

}
