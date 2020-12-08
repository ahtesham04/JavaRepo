import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class DeleteStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
        System.out.println("Enter sid whose record u want to delete :");
        int sid=s.nextInt();
       
        try{
        	//loading of driver...
            Class.forName("com.mysql.jdbc.Driver");
            
            //establishing the connection.... 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","789123");
            
            //create statement
            PreparedStatement pst=con.prepareStatement("delete from student where sid=?");
            pst.setInt(1,sid);
            
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