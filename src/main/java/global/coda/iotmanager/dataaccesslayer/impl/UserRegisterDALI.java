package global.coda.iotmanager.dataaccesslayer.impl;

import java.sql.ResultSet;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;


import global.coda.iotmanager.dataaccesslayer.intf.UserRegisterDAL;
import global.coda.iotmanager.models.User;

import global.coda.iotmanager.utils.*;
public class UserRegisterDALI implements UserRegisterDAL {
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
	@Override
	public Boolean add(User usr) throws Throwable {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				IotDatabaseHelper helper=new IotDatabaseHelper();
				try {
					
					helper.add(SQLSTATEMENTS.INSERT_USER, new String[] {usr.getEmail(),MD5(usr.getPassword()),"","ROLE_USER",usr.getFirstname(),usr.getLastname(),usr.getBirthDate(),"1"});
				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw e;
					
				}
				return true;
	}

	@Override
	public Boolean exists(User usr) throws Throwable {
		// TODO Auto-generated method stub
		Boolean ans=false;
		IotDatabaseHelper helper=new IotDatabaseHelper();
		try {
			
			ResultSet rs=helper.resultQuery(SQLSTATEMENTS.GET_USER,new String[] {usr.getEmail()});
			
			if(rs.next()) ans=true;
			rs.close();
			helper.close();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
			
		}
		return ans;
	}

}
