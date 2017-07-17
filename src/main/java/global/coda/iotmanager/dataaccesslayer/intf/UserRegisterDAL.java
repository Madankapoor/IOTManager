package global.coda.iotmanager.dataaccesslayer.intf;

import global.coda.iotmanager.models.User;

public interface UserRegisterDAL {
	public Boolean add(User ur) throws Throwable;
	public Boolean exists(User usr) throws Throwable;
}
