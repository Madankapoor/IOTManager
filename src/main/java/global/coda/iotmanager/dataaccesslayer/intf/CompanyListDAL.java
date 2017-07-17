package global.coda.iotmanager.dataaccesslayer.intf;

import java.util.List;

import global.coda.iotmanager.models.Company;
import global.coda.iotmanager.models.CompanyHeader;

public interface CompanyListDAL {
	
	
	public List<CompanyHeader> getCompanyHeader(String email) throws Throwable;
	
	public List<String> getCompaniesId(String email) throws Throwable;
	
	
	public List<String> getCompaniesName(List<String> st) throws Throwable;
	
	public Company getCompany(String cid) throws Throwable;

	public void addCompany(Company cmp) throws Throwable;

	public void addUser(String email, String cid, String role) throws Throwable;

	public boolean checkUser(String email) throws Throwable;
}
