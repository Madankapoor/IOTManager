package global.coda.iotmanager.services.intf;
import global.coda.iotmanager.models.*;

public interface UserRegisterService {
	
	public Boolean addUser(User usr) throws Throwable;
	
	public Boolean checkUser(User usr) throws Throwable;
}
