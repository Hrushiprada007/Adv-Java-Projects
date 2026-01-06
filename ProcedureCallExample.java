package in.hrushiit;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProcedureCallExample {
	 private static final String DB_URL="jdbc:mysql://localhost:3306/advjdb";
	   
	   private static final String DB_UNAME="root";
	   
	   private static final String DB_PWD = "Hrushi@2003";
	   
	   private static final String procedure = "call getBookById(?)";
	   
	   public static void main(String[] args)throws Exception {
		   Scanner scn = new Scanner(System.in);
		   System.out.println("Enter book id:");
		   int bookId = scn.nextInt();
		   Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		   
		  CallableStatement cstmt=con.prepareCall(procedure);
		  cstmt.setInt(1, bookId);
		  ResultSet rs = cstmt.executeQuery();
		  while(rs.next()) {
			  System.out.println(rs.getInt(1)+"==="+rs.getString(2)+"===="+rs.getDouble(3));
		  }
		  con.close();
		  
	}
}
