package com.lti.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.model.RegisterM;

//Data Access Object
//Classes which contain Database interaction
//code in Java are commonly referred to as DAO classes
public class RegisterDao  {
	
	public boolean insert(RegisterM rm){
		
		Connection con = null;
		try
		{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String  user="hr";
			    String pass = "hr";
			    con = DriverManager.getConnection(url,user,pass);
			
			
			 
				String sql = "insert into TBL_REG values(?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, rm.getName());
			    st.setString(2, rm.getEmail());
			    st.setString(3, rm.getPassword());
			    st.setString(4, rm.getCity());
			    
				int count=st.executeUpdate();
				if(count==1)
				System.out.println("record updated");
		return true;
		}
		catch(ClassNotFoundException | SQLException e){
			 // we should check the error
        System.out.println("error");
			return false;
		}
		}
		
		public List<RegisterM> display(String city){
			Connection con1 = null;
		List<RegisterM> rs1 =new ArrayList<>();
		ResultSet rs = null;
		try
		{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String  user="hr";
			    String pass = "hr";
			    con1 = DriverManager.getConnection(url,user,pass);
			 
			 String sql = "select * from TBL_REG where city= ? ";
				PreparedStatement st = con1.prepareStatement(sql);
				st.setString(1, city);
				rs=st.executeQuery();
				while(rs.next()){
					RegisterM m = new RegisterM();
					m.setName(rs.getString("name"));
					m.setEmail(rs.getString("email"));
					m.setPassword(rs.getString("password"));
					m.setCity(rs.getString("city"));
					rs1.add(m);
				}
				return rs1;
			
		}catch(Exception e){
		 System.out.println(e);
		}
		return rs1;
		
		
	}

}

	
