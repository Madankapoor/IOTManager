package global.coda.iotmanager.dataaccesslayer.impl;

import java.sql.ResultSet;

import global.coda.iotmanager.dataaccesslayer.intf.SensorDAL;
import global.coda.iotmanager.models.Sensor;
import global.coda.iotmanager.models.SensorData;
import global.coda.iotmanager.utils.*;

public class SensorDALI implements SensorDAL {
	public void addSensor(Sensor sr) throws Throwable
	{
		try
		{
			IotDatabaseHelper helper=new IotDatabaseHelper();
			//type , id , shared_key ,company_id,minvalue,maxivalue,unit_name
			helper.add(SQLSTATEMENTS.INSERT_SENSOR,
					new String[] {sr.getType(),sr.getId(),"",sr.getCompanyId(),Double.toString(sr.getMinvalue()),Double.toString(sr.getMaxvalue()),sr.getUnit()});
			
			helper.close();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public Sensor getSensor(String sid) throws Throwable
	{
		Sensor sr=new Sensor();
		try
		{
			IotDatabaseHelper helper=new IotDatabaseHelper();
			ResultSet rs=helper.resultQuery(SQLSTATEMENTS.GET_SENSORS,new String[] {sid});
			if(rs.next()) {
				sr.setType(rs.getString("type"));
				sr.setCompanyId(rs.getString("company_id"));
				sr.setId(rs.getString("id"));
				sr.setShared_key(rs.getString("shared_key"));
				sr.setMaxvalue(Double.parseDouble(rs.getString("maxivalue")));
				sr.setMinvalue(Double.parseDouble(rs.getString("minvalue")));
				sr.setUnit(rs.getString("unit_name"));
			}
			rs.close();
			helper.close();
		}
		catch(Exception e)
		{
			throw e;
		}
		return sr;
	}
	
	public SensorData getSensorData(String sid) throws Throwable
	{	SensorData sr=new SensorData();
		sr.init();
		try
		{
			IotDatabaseHelper helper=new IotDatabaseHelper();
			ResultSet rs=helper.resultQuery(SQLSTATEMENTS.GET_SENSOR_DATA,new String[] {sid});
			while(rs.next()) {
				sr.addData(rs.getString("read_time"),rs.getString("data"));
			}
			rs.close();
			helper.close();
		}
		catch(Exception e)
		{
			throw e;
		}
		return sr;
		
	}
	
	public Boolean addSensorReading(Sensor sr,String data) throws Throwable
	{	
		try
		{
			IotDatabaseHelper helper=new IotDatabaseHelper();
			helper.add(SQLSTATEMENTS.INSERT_SENSOR_DATA,new String[] {data,sr.getId()});
			helper.close();
		}
		catch(Exception e)
		{
			throw e;
		}
		return true;
	}
}
