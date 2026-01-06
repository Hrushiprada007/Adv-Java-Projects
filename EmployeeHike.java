package in.hrushiit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeHike {
   private static final String DB_URL="jdbc:mysql://localhost:3306/employeeForm";
	   
	   private static final String DB_UNAME="root";
	   
	   private static final String DB_PWD = "Hrushi@2003";
	   
	   private static final String select_sql = "select * from EmployeeForm";
	   
	   //private static final String update_sal_sql = "update EmployeeForm set emp_salary = ? where emp_id =?";
	 
	   
	public static void main(String[] args)throws Exception{
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter Hike salary value:");
		double hike = scn.nextDouble();
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		
		Statement stmt =con.createStatement();
		
		ResultSet rs = stmt.executeQuery(select_sql);
		String update_sal_sql = "update EmployeeForm set emp_salary =emp_salary* (emp_salary * ?) /100";
		PreparedStatement pstmt = con.prepareStatement(update_sal_sql);
		pstmt.setDouble(1, hike);
		
		pstmt.executeUpdate();
		
		System.out.println("Update completed.....");
		con.close();
		
		
		//PreparedStatement pstmt = con.prepareStatement(update_sal_sql);
		/*
		while(rs.next()) {
			int emp_id = rs.getInt("emp_id");
			double existing_salary = rs.getDouble("emp_salary");
			double new_sal = existing_salary +(existing_salary * hike) / 100;
			pstmt.setDouble(1,new_sal);
			pstmt.setInt(2, emp_id);
			
			pstmt.executeUpdate();
	
		}
		*/
		//System.out.println("update completeed....");
		//con.close();
		
	}
	

}
