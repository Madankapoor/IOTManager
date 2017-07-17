/**
 * 
 */
package global.coda.iotmanager.services.impl;

import global.coda.iotmanager.models.User;
import global.coda.iotmanager.services.intf.UserRegisterService;

import org.springframework.beans.factory.annotation.Autowired;

import global.coda.iotmanager.dataaccesslayer.intf.*;

/**
 * @author main
 *
 */
class UserRegisterServiceImplementation implements UserRegisterService {

	/* (non-Javadoc)
	 * @see global.coda.iotmanager.services.intf.UserRegisterService#addUser(global.coda.iotmanager.models.User)
	 */
	@Autowired
	private UserRegisterDAL registerDAO;
	@Override
	public Boolean addUser(User usr) throws Throwable {
		// TODO Auto-generated method stub
		return registerDAO.add(usr);

	}
	public UserRegisterDAL getRegisterDAO() {
		return registerDAO;
	}
	public void setRegisterDAO(UserRegisterDAL registerDAO) {
		this.registerDAO = registerDAO;
	}
	@Override
	public Boolean checkUser(User usr) throws Throwable {
		// TODO Auto-generated method stub
		return registerDAO.exists(usr);
	}
	
	
	
	
}
