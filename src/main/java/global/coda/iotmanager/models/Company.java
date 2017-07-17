package global.coda.iotmanager.models;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Company {
	
	private String id;
	
	@NotEmpty
	private String name;
	
	
	private String adminEmail;
	
	private String sharedkey;
	
	private int size;
	
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", adminEmail=" + adminEmail + ", sharedkey=" + sharedkey
				+ ", size=" + size + ", sensorsId=" + sensorsId + ", sensorsName=" + sensorsName + ", usersEmail="
				+ usersEmail + ", usersRole=" + usersRole + "]";
	}
	public String getSharedkey() {
		return sharedkey;
	}
	public void setSharedkey(String sharedkey) {
		this.sharedkey = sharedkey;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	private List<String> sensorsId;
	
	public List<String> getSensorsId() {
		return sensorsId;
	}
	public void setSensorsId(List<String> sensorsId) {
		this.sensorsId = sensorsId;
	}
	public List<String> getSensorsName() {
		return sensorsName;
	}
	public void setSensorsName(List<String> sensorsName) {
		this.sensorsName = sensorsName;
	}
	public List<String> getUsersEmail() {
		return usersEmail;
	}
	public void setUsersEmail(List<String> usersEmail) {
		this.usersEmail = usersEmail;
	}

	private List<String> sensorsName;
	
	private List<String> usersEmail;
	
	private List<String> usersRole;
	
	public List<String> getUsersRole() {
		return usersRole;
	}
	public void setUsersRole(List<String> usersRole) {
		this.usersRole = usersRole;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	
	public Boolean validateUser(String email)
	{
		if(usersEmail!=null)
		{
			if(usersEmail.contains(email)) return true;
		}
		
		return false;
	}
	
	public Boolean validateAdmin(String email)
	{
		return adminEmail.equals(email);
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
		size=1;
	}
	
	
}
