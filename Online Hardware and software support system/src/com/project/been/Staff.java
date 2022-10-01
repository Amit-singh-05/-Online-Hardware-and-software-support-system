package com.project.been;

public class Staff {
	private String username;
	private String password;
	private String jobroll;
	private String name;
	private String category;
	
	public Staff() {
		
	}
	
	

	public Staff(String username, String password, String jobroll, String name, String category) {
		super();
		this.username = username;
		this.password = password;
		this.jobroll = jobroll;
		this.name = name;
		this.category = category;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJobroll() {
		return jobroll;
	}

	public void setJobroll(String jobroll) {
		this.jobroll = jobroll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Staff [username=" + username + ", password=" + password + ", jobroll=" + jobroll + ", name=" + name
				+ ", category=" + category + "]";
	}
	
	
	
	
	
	
	
}
