package cn.hdu.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static DataSource ds=null;
	static{
		ds=new ComboPooledDataSource();
	}
	
	public static DataSource getDatasource(){
		return ds;
	}
	
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
