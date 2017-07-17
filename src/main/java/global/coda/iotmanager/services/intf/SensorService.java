package global.coda.iotmanager.services.intf;

import global.coda.iotmanager.models.Sensor;
import global.coda.iotmanager.models.SensorData;

public interface SensorService {
	public Sensor getSensor(String sid) throws Throwable;
	public SensorData getSensorData(String sid) throws Throwable;
	public Boolean addSensorReading(Sensor sr,String data) throws Throwable;
	public void addSensor(Sensor sr) throws Throwable;
}
