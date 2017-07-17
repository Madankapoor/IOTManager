package global.coda.iotmanager.services.intf;

import java.util.List;

import global.coda.iotmanager.models.Company;
import global.coda.iotmanager.models.CompanyHeader;

public interface CompanyListService {
	public List<String> getCompaniesId(String email) throws Throwable;
	public List<String> getCompaniesName(List<String> st) throws Throwable;
	
	public List<CompanyHeader> getCompanyHeader(String email) throws Throwable;
	
	public Company getCompany(String cid) throws Throwable;
	public void addCompany(Company cmp) throws Throwable;
	public void addUser(String adminEmail,String email, String cid, String string) throws Throwable;
	public boolean checkUser(String email) throws Throwable;
}
