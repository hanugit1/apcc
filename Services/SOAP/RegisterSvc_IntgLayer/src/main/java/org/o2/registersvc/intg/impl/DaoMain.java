package org.o2.registersvc.intg.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import javax.net.ssl.SSLEngineResult.Status;

public class DaoMain {
	public static void main(String[] args) throws SQLException, IOException {
		Connection con;
		CallableStatement cs = null;
		
		try {
			FileReader reader = new FileReader("src/main/resources/db.properties");
			Properties prop = new Properties();
			prop.load(reader);
			String driverClass = prop.getProperty("driverClass");
			String url = prop.getProperty("url");
			String uname = prop.getProperty("uname");
			String pwd = prop.getProperty("pwd");
			
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, uname, pwd);
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanu", "root", "root");
			
			String sql = "{call GET_ENROLL(?,?,?,?,?,?,?,?,?,?)}";
			cs = con.prepareCall(sql);
			//Register Output parameters with JDBC types
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.VARCHAR);
			
			//Set values to input parameters
			cs.setString(1, "online");
			cs.setString(2, "web");
			cs.setString(3, "885744998856");
			cs.setString(4, "343");
			cs.setString(5, "19/02/2025");
			cs.setString(6, "mahesh");
			cs.setString(7, "679844997418");
			cs.setInt(8, 998866776);
			boolean b = cs.execute();
			String respCode = cs.getString(9);
			String respMsg = cs.getString(10);
			
			System.out.println("Status code is "+cs.getString(9));
			System.out.println("Status msg is "+cs.getString(10));
			
			//Creating StatusBlockDao obj
			/*StatusBlockDao statusBlock = new StatusBlockDao();
			statusBlock.setRespCode(respCode);
			statusBlock.setRespMsg(respMsg);*/

			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ResultSet rs = cs.executeQuery("select *from customer_details");
		System.out.println("ResultSet object "+rs);
		
		while (rs.next()) {
			System.out.println(rs.getString("sno"));
			System.out.println(rs.getString("card_num"));
			System.out.println(rs.getString("cvv"));
			System.out.println(rs.getString("exp_date"));
			System.out.println(rs.getString("name_on_card"));
			System.out.println(rs.getInt("mob_num"));
			
		}
		
	}
}
