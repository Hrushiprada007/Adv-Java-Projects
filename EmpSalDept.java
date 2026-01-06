package in.hrushiit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class EmpSalDept {
   private static final String DB_URL="jdbc:mysql://localhost:3306/employeeForm";
	   
	   private static final String DB_UNAME="root";
	   
	   private static final String DB_PWD = "Hrushi@2003";
	   
	   private static final String select_sql = "select * from EmployeeForm";
	   
	   public static void main(String[] args)throws Exception {
		   
		   Scanner scn =new Scanner(System.in);
		   System.out.println("Enter salary hike:");
		   double hike = scn.nextDouble();
		   System.out.println("Enter the Dept,which you want to increase the salary: ");
		   String dept = scn.next();
		   
		   Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		   
		   String update_sal_sql = "update EmployeeForm set emp_salary = emp_salary +(emp_salary * ?)/100 where emp_dept = ?";
		   
		   PreparedStatement pstmt = con.prepareStatement(update_sal_sql);
		   pstmt.setDouble(1, hike);
		   pstmt.setString(2, dept);
		   
		   pstmt.executeUpdate();
		   
		   System.out.println("update sucessfully......");
		   con.close();
		   
		
	}
	   
}
