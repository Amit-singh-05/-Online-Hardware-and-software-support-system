package com.project.usecase;

import java.util.Scanner;

import com.project.been.Staff;
import com.project.dao.StaffDao;
import com.project.dao.StaffDaoImpl;

public class RegisterHodAndEmploy {

	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Staff Name:");
		String name= sc.next();
		
		System.out.println("Enter Staff jobroll:");
		String jobroll= sc.next();
		
		System.out.println("Enter Staff username/email:");
		String username= sc.next();
		
		System.out.println("Enter Staff password:");
		String password= sc.next();
		
		StaffDao dao=new StaffDaoImpl();
		
		Staff staff= new Staff();
		if((jobroll.toUpperCase()).equals("EMPLOYEE")||(jobroll.toUpperCase()).equals("HOD")) {
		staff.setName(name);
		staff.setJobroll(jobroll);
		staff.setUsername(username);
		staff.setPassword(password);
		
		String result= dao.registerstaff(staff);
		System.out.println(result);
		}else{
			System.out.println("Only Employee and HOD can we registered");
		}
	
		
	}

}