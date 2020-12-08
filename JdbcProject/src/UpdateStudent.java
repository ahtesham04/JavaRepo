import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class UpdateStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
        System.out.println("Enter sid whose record u want to update :");
        int sid=s.nextInt();
        System.out.println("Enter new name:");
        String name=s.next();
        System.out.println("Enter new course:");
        String course=s.next();
        
        try{
        	//loading of driver...
            Class.forName("com.mysql.jdbc.Driver");
            
            //establishing the connection.... 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","789123");
            
            //create statement
            PreparedStatement pst=con.prepareStatement("update student set name=?,course=? where sid=?");
           
            pst.setString(1, name);
            pst.setString(2, course);
            pst.setInt(3,sid);
            
            
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