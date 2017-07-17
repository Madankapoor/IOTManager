package global.coda.iotmanager.dataaccesslayer.intf;

import global.coda.iotmanager.models.Sensor;
import global.coda.iotmanager.models.SensorData;

public interface SensorDAL {
	public Sensor getSensor(String sid) throws Throwable;
	public SensorData getSensorData(String sid) throws Throwable;
	public Boolean addSensorReading(Sensor sr,String data) throws Throwable;
	public void addSensor(Sensor sr) throws Throwable;
	
}
