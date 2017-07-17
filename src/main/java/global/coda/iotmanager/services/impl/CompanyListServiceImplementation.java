package global.coda.iotmanager.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import global.coda.iotmanager.dataaccesslayer.intf.CompanyListDAL;
import global.coda.iotmanager.models.Company;
import global.coda.iotmanager.models.CompanyHeader;
import global.coda.iotmanager.services.intf.CompanyListService;
import global.coda.iotmanager.utils.Mailer;
import global.coda.iotmanager.utils.Trigger;

public class CompanyListServiceImplementation implements CompanyListService {
	@Autowired
	private CompanyListDAL companyListDAO;
	
	@Override
	public List<String> getCompaniesId(String email) throws Throwable {
		// TODO Auto-generated method stub
		return companyListDAO.getCompaniesId(email);
	}
	
	
	@Override
	public List<String> getCompaniesName(List<String> ids) throws Throwable {
		// TODO Auto-generated method stub
		return companyListDAO.getCompaniesName(ids);
	}

	
	public CompanyListDAL getCompanyListDAO() {
		return companyListDAO;
	}


	public void setCompanyListDAO(CompanyListDAL companyListDAO) {
		this.companyListDAO = companyListDAO;
	}


	@Override
	public List<CompanyHeader> getCompanyHeader(String email) throws Throwable {
		// TODO Auto-generated method stub
		return companyListDAO.getCompanyHeader(email);
	}
	
	public Company getCompany(String cid) throws Throwable
	{
		return companyListDAO.getCompany(cid);
	}
	
	public void addCompany(Company cmp) throws Throwable
	{
		companyListDAO.addCompany(cmp);
	}


	@Override
	public void addUser(String adminEmail,String email, String cid, String role) throws Throwable {
		// TODO Auto-generated method stub
		if(checkUser(email))
		{	
			companyListDAO.addUser(email,cid,role);
			
		}else {
			Trigger t=new Trigger();
			
			Mailer.Send(email,adminEmail,"Welcome you are invited to join , register at our website");
			
            t.CreateTrigger("CREATE TRIGGER add_invited AFTER INSERT ON iot_users FOR EACH ROW BEGIN IF NEW.email ='"+email+"' THEN INSERT INTO iot_company_has_iot_users values('"+cid+"','"+email+"','USER'); END IF; END;");
           
		}
	}


	@Override
	public boolean checkUser(String email) throws Throwable {
		// TODO Auto-generated method stub
		
		return companyListDAO.checkUser(email);
	}
}
