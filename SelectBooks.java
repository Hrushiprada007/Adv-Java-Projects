package in.hrushiit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectBooks {
   private static final String DB_URL="jdbc:mysql://localhost:3306/advjdb";
   
   private static final String DB_UNAME="root";
   
   private static final String DB_PWD = "Hrushi@2003";
   
   public static void main(String[] args)throws Exception {
	   
	   Scanner scn = new Scanner(System.in);
	   
	   System.out.println("Enter book Price:");
	   double price = scn.nextDouble();
	   
	   Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
	   
	 
	   //StringBuilder is used because it is thread safe and also multiple user can able to access at a time, which is
	   //not possible in StringBuffer method ,in this method only one user can access.
	   
	   StringBuilder sql = new StringBuilder("select * from books");
	   
	   if(price > 0) {
		   sql.append(" where book_price <= ?");
	   }
	   PreparedStatement pstmt = con.prepareStatement(sql.toString()); //convert builder to string object ,so i used toString()
	   if(price > 0) {
	   pstmt.setDouble(1, price);
	   }
	   ResultSet rs =pstmt.executeQuery();
	   
	   while(rs.next()) {
		   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
	   }
	   con.close();
	   scn.close();
     }
}
