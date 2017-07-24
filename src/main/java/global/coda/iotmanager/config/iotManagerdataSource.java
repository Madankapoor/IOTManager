package global.coda.iotmanager.config;





import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class iotManagerdataSource implements DataSource {

	private BasicDataSource ds;
	
	public BasicDataSource dataSource()  {
		Logger.getGlobal().info("source created");
		BasicDataSource d=new BasicDataSource();
	    
	    d.setDriverClassName(System.getenv("DRIVER"));
	    Logger.getGlobal().info(System.getenv("DRIVER"));
	    d.setUsername(System.getenv("USERNAME"));
	    Logger.getGlobal().info(System.getenv("USERNAME"));
	    d.setPassword(System.getenv("PASSWORD"));
	    Logger.getGlobal().info(System.getenv("PASSWORD"));
	    d.setUrl(System.getenv("MYSQLCONNECTION_URL"));
	    
	    return d;
	}
	



	public iotManagerdataSource() {
		super();
		// TODO Auto-generated constructor stub
		ds=dataSource();
	}




	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return ds.getLogWriter();
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		ds.setLogWriter(out);
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return ds.getLoginTimeout();
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return ds.getParentLogger();
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return ds.unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return ds.isWrapperFor(iface);
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return ds.getConnection();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return ds.getConnection(username, password);
	}
}
