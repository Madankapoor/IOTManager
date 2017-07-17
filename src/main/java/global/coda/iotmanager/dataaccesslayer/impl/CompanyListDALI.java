package global.coda.iotmanager.dataaccesslayer.impl;

import java.security.SecureRandom;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import global.coda.iotmanager.dataaccesslayer.intf.CompanyListDAL;
import global.coda.iotmanager.models.Company;
import global.coda.iotmanager.models.CompanyHeader;
import global.coda.iotmanager.utils.*;

public class CompanyListDALI implements CompanyListDAL {
	@Override
	public void addCompany(Company cmp) throws Throwable
	{
		try
		{
			IotDatabaseHelper helper=new IotDatabaseHelper();
			//size,name,id,adminemail,sharedkey
			
			helper.add(SQLSTATEMENTS.INSERT_COMPANY,
					new String[] {cmp.getName(),cmp.getAdminEmail()});
			
			
			ResultSet rs=helper.resultQuery("select max(id) from iot_company");
			
			if(rs.next())
			{
				cmp.setId(rs.getString(1));
			}
			rs.close();
			
			helper.add(SQLSTATEMENTS. INSERT_COMPANY_USER,
					new String[] {cmp.getId(),cmp.getAdminEmail(),"ADMIN"});
			
			
			helper.close();
		}
		catch(Throwable e )
		{
			throw e;
		}
	}
	@Override
	public List<String> getCompaniesId(String email) throws Throwable {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		try
		{
			IotDatabaseHelper helper=new IotDatabaseHelper();
			ResultSet rs=helper.resultQuery(SQLSTATEMENTS.GET_COMPANIES_ID, new String[] {email});
			while(rs.next())
			{
				list.add(rs.getString(1));
			}
			rs.close();
			helper.close();
		}
		catch(Throwable e )
		{
			throw e;
		}
		return list;
	}
	@Override
	public List<String> getCompaniesName(List<String> st) throws Throwable 
	{
		
		ArrayList<String> list=new ArrayList<String>();
		try
		{	for(String companyId:st )
			{
				IotDatabaseHelper helper=new IotDatabaseHelper();
				ResultSet rs=helper.resultQuery(SQLSTATEMENTS.GET_COMPANIES_NAME, new String[] {companyId});
				if(rs.next())
				{
					list.add(rs.getString(1));
				}
				rs.close();
				helper.close();
			}
		}
		catch(Throwable e )
		{
			throw e;
		}
		return list;
		
	}
	
	public List<CompanyHeader> getCompanyHeader(String email) throws Throwable
	{	
		ArrayList<CompanyHeader> list=new ArrayList<CompanyHeader>();
		try
		{
			IotDatabaseHelper helper=new IotDatabaseHelper();
			ResultSet rs=helper.resultQuery(SQLSTATEMENTS.GET_COMPANIES_HEADER, new String[] {email});
			while(rs.next())
			{
				list.add(new CompanyHeader(rs.getString(2),rs.getString(1)));
			}
			rs.close();
			helper.close();
		}
		catch(Throwable e )
		{
			throw e;
		}
		return list;
		
	}
	public Company getCompany(String cid) throws Throwable
	{	Company cmp=new Company();
		try
		{
			IotDatabaseHelper helper=new IotDatabaseHelper();
			ResultSet rs=helper.resultQuery(SQLSTATEMENTS.GET_COMPANY, new String[] {cid});
			if(rs.next())
			{
				cmp.setAdminEmail(rs.getString(4));
				cmp.setId(rs.getString(3));
				cmp.setName(rs.getString(2));
				cmp.setSharedkey(rs.getString(5));
				cmp.setSize(Integer.parseInt(rs.getString(1)));
			}
			rs.close();
			helper.close();
			
			
			rs=helper.resultQuery(SQLSTATEMENTS.GET_SENSORS_OF_COMPANY, new String[] {cid});
			ArrayList<String> sensors=new ArrayList<String>();
			while(rs.next())
			{
				sensors.add(rs.getString(1));
			}
			
			rs.close();
			helper.close();
			
			
			rs=helper.resultQuery(SQLSTATEMENTS.GET_USERS_OF_COMPANY, new String[] {cid});
			ArrayList<String> userEmail=new ArrayList<String>();
			ArrayList<String> userRole=new ArrayList<String>();
			while(rs.next())
			{
				userEmail.add(rs.getString(2));
				userRole.add(rs.getString(3));
			}
			
			rs.close();
			helper.close();
			
			
			
			cmp.setSensorsId(sensors);
			cmp.setUsersEmail(userEmail);
			cmp.setUsersRole(userRole);
		}
		catch(Throwable e )
		{
			throw e;
		}
		return cmp;
	}
	@Override
	public void addUser(String email, String cid, String role) throws Throwable {
		// TODO Auto-generated method stub
		try
		{
			IotDatabaseHelper helper=new IotDatabaseHelper();
			
			helper.add(SQLSTATEMENTS.INSERT_COMPANY_USER, new String[]{cid,email,role});
			
			
		}catch(Throwable e)
		{
			throw e;
		}
	}
	@Override
	public boolean checkUser(String email) throws Throwable {
		try
		{
			IotDatabaseHelper helper=new IotDatabaseHelper();
			
			ResultSet rs=helper.resultQuery(SQLSTATEMENTS.GET_USER,new String[] {email});
			
			if(rs.next())
			{
				
				return true;
			}
		}catch(Throwable e)
		{
			throw e;
		}
		return false;
	}
}
