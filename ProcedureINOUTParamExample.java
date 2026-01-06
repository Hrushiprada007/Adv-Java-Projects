package in.hrushiit;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class ProcedureINOUTParamExample {
	   private static final String DB_URL="jdbc:mysql://localhost:3306/advjdb";
	   
	   private static final String DB_UNAME="root";
	   
	   private static final String DB_PWD = "Hrushi@2003";
	   
	   private static final String procedure = "call getBookNameByPrice(?,?)";
	   
	   public static void main(String[] args)throws Exception {
		Scanner scn =new Scanner(System.in);
		System.out.println("Enter Book price:");
		double bookPrice =scn.nextDouble();
		
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		
		CallableStatement cstmt = con.prepareCall(procedure);
		
		cstmt.setDouble(1, bookPrice); //you know 1st parameter is input parameter
		cstmt.registerOutParameter(2,Types.VARCHAR);//you also know 2nd parameter is out parameter
		ResultSet rs = cstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		 con.close();
	}
	  
	   
}
