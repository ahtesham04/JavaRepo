import java.sql.*;
public class PrepareFamily {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ansaridb","root","789123");
			 PreparedStatement pst=con.prepareStatement("insert into family (name,age,boy,relation) values(?,?,?,?)");
	           
	            pst.setString(1,"Umar");
	            pst.setInt(2,2);
	            pst.setInt(3,2019);
	            pst.setString(4, "Son");
	          
	            int res = pst.executeUpdate();
	            if(res>0)
	                System.out.println("Record saved...!");
	            else
	                System.out.println("Record failed to save..!");
	            con.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }

	}

}