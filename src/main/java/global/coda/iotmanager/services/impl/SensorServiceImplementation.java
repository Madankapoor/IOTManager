package global.coda.iotmanager.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import global.coda.iotmanager.dataaccesslayer.intf.SensorDAL;
import global.coda.iotmanager.models.Sensor;
import global.coda.iotmanager.models.SensorData;
import global.coda.iotmanager.services.intf.SensorService;

public class SensorServiceImplementation implements SensorService {
	@Autowired
	private SensorDAL sensorDAO;

	public SensorDAL getSensorDAO() {
		return sensorDAO;
	}

	public void setSensorDAO(SensorDAL sensorDAO) {
		this.sensorDAO = sensorDAO;
	}
	
	public Sensor getSensor(String sid) throws Throwable {
		return sensorDAO.getSensor(sid);
	}
	public SensorData getSensorData(String sid) throws Throwable
	{
		return sensorDAO.getSensorData(sid);
	}
	public Boolean addSensorReading(Sensor sr,String data) throws Throwable
	{
		return sensorDAO.addSensorReading(sr,data);
	}
	public void addSensor(Sensor sr) throws Throwable
	{
		sensorDAO.addSensor(sr);
	}
}
