package com.project.dao;

import java.util.List;

import com.project.been.ComplaintTable;
import com.project.exception.StaffException;

public interface SomplainDao {
	List<ComplaintTable> getAllComplaint() throws StaffException;
	public String assignEngineer(String engineer,int Complaint_id)throws StaffException;
	public String registercomplain(ComplaintTable complain);
	List<ComplaintTable> getComplaintbyme(String s) throws StaffException;
	public ComplaintTable getcomplainbyid(int complainid)throws StaffException;
	List<ComplaintTable> getasindengineer(String s) throws StaffException;
	public String updatestatus(String complaint_status,int Complaint_id)throws StaffException;
	List<ComplaintTable> getcomplainattended(String s) throws StaffException;
}
