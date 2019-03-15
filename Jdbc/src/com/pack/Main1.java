package com.pack;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try{
	Connection con=JDBCConnection.getConnection();
	CallableStatement cs=con.prepareCall("{call sample(?,?,?,?)}");
	cs.setInt(1,601488);
	cs.registerOutParameter(2,java.sql.Types.VARCHAR);
	cs.registerOutParameter(3, java.sql.Types.FLOAT);
	cs.registerOutParameter(4, java.sql.Types.VARCHAR);
	cs.execute();
	System.out.println(cs.getString(2)+" "+cs.getFloat(3)+" "+cs.getString(4));
	con.close();
}
catch(Exception e){}
}
}
