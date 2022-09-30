package com.project.usecase;

import java.util.List;
import java.util.Scanner;
import com.project.been.Staff;
import com.project.dao.StaffDao;
import com.project.dao.StaffDaoImpl;
import com.project.exception.StaffException;

public class Login {

	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		StaffDao dao = new StaffDaoImpl();
		
		try {
			Staff staff= dao.loginStaff(uname, pass);
		
	 		System.out.println("Welcome :"+staff.getName());
	 		if(((staff.getJobroll()).toUpperCase()).equals("HOD")) {
	 			System.out.println("1 Register a new Engineer with a username(email) and password and the category (Hardware/software)");
	 			System.out.println("2 see List of all the Registered Engineers.");
	 			System.out.println("3 Delete any Engineers from the system");
	 			System.out.println("4 see all the raised problem.");
	 			System.out.println("5 assign any problem to any Engineer.");
	 			
	 			int choice = sc.nextInt();
	 			if (choice==1) {
	 				System.out.println("Enter Staff Name:");
	 				String name= sc.next();
	 				
	 				System.out.println("Enter Staff jobroll:");
	 				String jobroll= sc.next();
	 				
	 				System.out.println("Enter Staff category:");
	 				String category = sc.next();
	 				
	 				System.out.println("Enter Staff username/email:");
	 				String username= sc.next();
	 				
	 				System.out.println("Enter Staff password:");
	 				String password= sc.next();
	 				
	 				Staff staff1= new Staff();
	 				if((jobroll.toUpperCase()).equals("ENGINEER")) {
	 				staff1.setName(name);
	 				staff1.setJobroll(jobroll);
	 				staff1.setUsername(username);
	 				staff1.setPassword(password);
	 				staff1.setCategory(category);
	 				
	 				String result= dao.registerstaff(staff1);
	 				System.out.println(result);
	 				}else {
	 					System.out.println("Only Engineer can we registered");
	 				}
	 				
	 			}else if (choice==2) {
	 				try {
	 					List<Staff> staff2= dao.getAllEnginner();
	 					
	 					staff2.forEach(s ->{
	 						
	 						System.out.println(s.getName()+" | "+s.getJobroll()+" | "+s.getCategory());
	 						System.out.println("==============================");
	 					});
	 					}catch(StaffException se) {
	 						System.out.println(se.getMessage());
	 					}
	 			}else if (choice==3) {
	 				System.out.println("Enter Username of Engineer to Remove");
	 				String runame = sc.next();
	 				try {
	 					String result = dao.removeStaff(runame);
	 					System.out.println(result);
	 					}catch(StaffException se) {
	 						System.out.println(se.getMessage());
	 					}
	 			}
	 			
	 			
	 			else {
	 				throw new StaffException("Invalid choice.. ");
	 			}
	 		}
	 	
	 	
		}catch (StaffException e) {
			System.out.println(e.getMessage());
		}

	}

	}


