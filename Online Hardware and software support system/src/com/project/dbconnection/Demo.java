package com.project.dbconnection;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {
        Connection conn= DBconnect.provideConnection();
		System.out.println(conn);
	}

}
