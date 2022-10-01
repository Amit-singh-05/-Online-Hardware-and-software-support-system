package com.project.usecase;

import java.util.List;
import java.util.Scanner;

import com.project.been.ComplaintTable;
import com.project.been.Staff;
import com.project.dao.SomplainDao;
import com.project.dao.SomplainDaoImpl;
import com.project.dao.StaffDao;
import com.project.dao.StaffDaoImpl;
import com.project.exception.StaffException;

public class Login {

	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(true) {
        System.out.println();
        System.out.println("*****************************************************************************");
        System.out.println("**************** Online Hardware and software support system ****************");
        System.out.println("*****************************************************************************");
        System.out.println();
        System.out.println("1 To login");
		System.out.println("2 To Register");
		int mchoice = sc.nextInt();
		if(mchoice==1) {
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:")
		;
		String pass = sc.next();
		
		StaffDao dao = new StaffDaoImpl();
		SomplainDao dao2 = new SomplainDaoImpl();
		
		try {
			Staff staff= dao.loginStaff(uname, pass);
		
	 		System.out.println("Welcome :"+staff.getName());
	 		System.out.println(staff.getJobroll());
	 		
	 		
	 		if(((staff.getJobroll()).toUpperCase()).equals("HOD")) {
	 			int choice = 0;
	 			while(choice!=6) {
	 			System.out.println("1 Register a new Engineer with a username(email) and password and the category (Hardware/software)");
	 			System.out.println("2 see List of all the Registered Engineers.");
	 			System.out.println("3 Delete any Engineers from the system");
	 			System.out.println("4 see all the raised complain.");
	 			System.out.println("5 assign any problem to any Engineer.");
	 			System.out.println("6 Logout");
	 			choice = sc.nextInt();
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
	 			}else if (choice==4) {
	 				try {
	 					List<ComplaintTable> complaint2= dao2.getAllComplaint();
	 					
	 					complaint2.forEach(s ->{
	 						
	 						System.out.println(s.getComplaint_id()+" | "+s.getComplaint_by()+" | "+s.getComplain()+" | "+s.getAsind_engineer()+" | "+s.getComplaint_status());
	 						System.out.println("================================================================");
	 					});
	 					}catch(StaffException se) {
	 						System.out.println(se.getMessage());
	 					}
	 			}else if (choice==5) {
	 				
	 					System.out.println("Enter Complaint id");
		 				int Complaint_id = sc.nextInt();
		 				System.out.println("Enter Engineer to assign");
		 				String EngineerName = sc.next();
		 				try {
		 					String result = dao2.assignEngineer(EngineerName, Complaint_id);
		 					System.out.println(result);
	 					}catch(StaffException se) {
	 						System.out.println(se.getMessage());
	 					}
	 				
	 			}else if (choice==6) {
	 				System.out.println(staff.getJobroll()+" "+staff.getName()+" logged out Successfully");
	 			}else {
	 				throw new StaffException("Invalid choice.. ");
	 			}
	 		}
	 	
		}
	 	else if(((staff.getJobroll()).toUpperCase()).equals("EMPLOYEE")) {
	 		
	 		int choice = 0;
 			while(choice!=5) {
				System.out.println("1 register complain");
				System.out.println("2 see the status complain by using complain id");
				System.out.println("3 see all complain history raised by me");
				System.out.println("4 change password");
				System.out.println("5 Logout");
				choice = sc.nextInt();
				
				if (choice==1) {
	 				
	 				System.out.println("Enter complain:");
	 				String complain = sc.next();
	 				
	 				ComplaintTable complain1= new ComplaintTable();
	 				
	 				complain1.setComplaint_by(staff.getName());
	 				complain1.setComplain(complain);
	 				
	 				
	 				String result= dao2.registercomplain(complain1);
	 				System.out.println(result);
	 			}else if(choice==3) {
	 				try {
	 					List<ComplaintTable> complaint2= dao2.getComplaintbyme(staff.getName());
	 					
	 					complaint2.forEach(s ->{
	 						
	 						System.out.println(s.getComplaint_id()+" | "+s.getComplaint_by()+" | "+s.getComplain()+" | "+s.getAsind_engineer()+" | "+s.getComplaint_status());
	 						System.out.println("================================================================");
	 					});
	 					}catch(StaffException se) {
	 						System.out.println(se.getMessage());
	 					}		
	 			}else if(choice==2) {
	 				System.out.println("Enter complain id:");
	 				int complain_id = sc.nextInt();
	 				
	 				try {
	 					ComplaintTable c1= dao2.getcomplainbyid(complain_id);
	 					
	 						System.out.println(c1);
	 					
	 					}catch (StaffException se) {
	 						System.out.println(se.getMessage());
				 					}
				 		}else if(choice==4) {
				 				System.out.println("Enter new password:");
				 				String npassword = sc.next();
				 				
				 				try {
				 					String result = dao.change_password(npassword, staff.getName());
				 					System.out.println(result);
				 					}catch(StaffException se) {
				 						System.out.println(se.getMessage());
				 					}
				
				 		}else if (choice==5) {
			 				System.out.println(staff.getJobroll()+" "+staff.getName()+" logged out Successfully");
			 			}else {
			 				throw new StaffException("Invalid choice.. ");
			 			}
 						}
				 		}else if(((staff.getJobroll()).toUpperCase()).equals("ENGINEER")) {
				 			int choice = 0;
				 			while(choice!=5) {
				 			System.out.println("1 To see all problem assigned to me by HOD");
				 			System.out.println("2 To update the status of the problem");
				 			System.out.println("3 To see list of all the problems attended by me");
				 			System.out.println("4 To change password");
				 			System.out.println("5 Logout");
				 			
				 			choice = sc.nextInt();
				 			
				 			if (choice==1){
				 				try {
				 					List<ComplaintTable> complaint3= dao2.getasindengineer(staff.getName());
				 					
				 					complaint3.forEach(s ->{
				 						
				 						System.out.println(s.getComplaint_id()+" | "+s.getComplaint_by()+" | "+s.getComplain()+" | "+s.getAsind_engineer()+" | "+s.getComplaint_status());
				 						System.out.println("================================================================");
				 					});
				 					}catch(StaffException se) {
				 						System.out.println(se.getMessage());
				 					}
				 			}else if(choice==2){
				 				System.out.println("Enter Complaint id");
				 				int Complaint_id = sc.nextInt();
				 				System.out.println("Enter status update for the problem");
				 				String complaint_status = sc.next();
				 				try {
				 					String result = dao2.updatestatus(complaint_status, Complaint_id);
				 					System.out.println(result);
			 					}catch(StaffException se) {
			 						System.out.println(se.getMessage());
			 					}
				 			}else if (choice==3){
				 				try {
				 					List<ComplaintTable> complaint3= dao2.getcomplainattended(staff.getName());
				 					
				 					complaint3.forEach(s ->{
				 						
				 						System.out.println(s.getComplaint_id()+" | "+s.getComplaint_by()+" | "+s.getComplain()+" | "+s.getAsind_engineer()+" | "+s.getComplaint_status());
				 						System.out.println("================================================================");
				 					});
				 					}catch(StaffException se) {
				 						System.out.println(se.getMessage());
				 					}
				 			}else if (choice==4){
				 				System.out.println("Enter new password:");
				 				String npassword = sc.next();
				 				
				 				try {
				 					String result = dao.change_password(npassword, staff.getName());
				 					System.out.println(result);
				 					}catch(StaffException se) {
				 						System.out.println(se.getMessage());
				 					}
				 			}else if (choice==5) {
				 				System.out.println(staff.getJobroll()+" "+staff.getName()+" logged out Successfully");
				 			}else {
				 				throw new StaffException("Invalid choice.. ");
				 			}
				 			}
				 			
				 			
				 		}
	 		
					}catch (StaffException e) {
						System.out.println(e.getMessage());
					}

	}else if(mchoice==2) {
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
	else {
		System.out.println ("Invalid choice.. ");
		}
    }
	}
	}


