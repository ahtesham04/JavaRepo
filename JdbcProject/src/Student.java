

import java.sql.*;
public class Student{

	public static void main(String[] args) {
		try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","789123");
            PreparedStatement pst=con.prepareStatement("insert into student (sid,name,course,marks) values(?,?,?,?)");
            pst.setInt(1,104);
            pst.setString(2,"Ahtesham");
            pst.setString(3, ".Net");
            pst.setFloat(4,99.8f);
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
