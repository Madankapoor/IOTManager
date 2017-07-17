package global.coda.iotmanager.models;


import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class User {
	@NotEmpty(message="First name cannot be Empty")
	private String firstname;
	@NotEmpty(message="Last name cannot be Empty")
	private String lastname;
	@NotEmpty(message="Email cannot be Empty")
	@Email
	private String email;
	@Size(min=3,max=15)
	private String conf_password;
	@Size(min=3,max=15)
	private String password;
	@NotEmpty
	private String birthDate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
		
	}

    

	
	
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", conf_password="
				+ conf_password + ", password=" + password + ", birthDate=" + birthDate + "]";
	}





	public String getFirstname() {
		return firstname;
	}





	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}





	public String getLastname() {
		return lastname;
	}





	public void setLastname(String lastname) {
		this.lastname = lastname;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getConf_password() {
		return conf_password;
	}





	public void setConf_password(String conf_password) {
		this.conf_password = conf_password;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getBirthDate() {
		return birthDate;
	}





	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}





	public static String MD5(String md5) {
        try {
             java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
             byte[] array = md.digest(md5.getBytes());
             StringBuilder sb = new StringBuilder();
             for (int i = 0; i < array.length; ++i) {
               sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
             return sb.toString();
         } catch (java.security.NoSuchAlgorithmException e) {
         }
         return "";
     }
	
	public static String MD5spring(String pass)
	{
		 Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		  return  encoder.encodePassword(pass,null);
	}
	
	
}
