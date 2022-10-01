package com.project.been;

public class ComplaintTable {
	private int complaint_id;
	private String complaint_by;
	private String complain;
	private String asind_engineer;
	private String complaint_status;
	
	public ComplaintTable(){
		
	}
	
	public ComplaintTable(int complaint_id, String complaint_by, String complain, String asind_engineer,
			String complaint_status) {
		super();
		this.complaint_id = complaint_id;
		this.complaint_by = complaint_by;
		this.complain = complain;
		this.asind_engineer = asind_engineer;
		this.complaint_status = complaint_status;
	}

	public int getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(int complaint_id) {
		this.complaint_id = complaint_id;
	}

	public String getComplaint_by() {
		return complaint_by;
	}

	public void setComplaint_by(String complaint_by) {
		this.complaint_by = complaint_by;
	}

	public String getComplain() {
		return complain;
	}

	public void setComplain(String complain) {
		this.complain = complain;
	}

	public String getAsind_engineer() {
		return asind_engineer;
	}

	public void setAsind_engineer(String asind_engineer) {
		this.asind_engineer = asind_engineer;
	}

	public String getComplaint_status() {
		return complaint_status;
	}

	public void setComplaint_status(String complaint_status) {
		this.complaint_status = complaint_status;
	}

	@Override
	public String toString() {
		return "ComplaintTable [complaint_id=" + complaint_id + ", complaint_by=" + complaint_by + ", complain="
				+ complain + ", asind_engineer=" + asind_engineer + ", complaint_status=" + complaint_status + "]";
	}
	
	
	
	
}
