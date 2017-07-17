package global.coda.iotmanager.models;

import org.hibernate.validator.constraints.NotEmpty;

public class Sensor {
	@NotEmpty
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@NotEmpty
	private String id;
	@NotEmpty
	private	String shared_key;
	@NotEmpty
	private	String companyId;
	
	
	private double minvalue;
	public double getMinvalue() {
		return minvalue;
	}
	public void setMinvalue(double minvalue) {
		this.minvalue = minvalue;
	}
	@Override
	public String toString() {
		return "Sensor [type=" + type + ", id=" + id + ", shared_key=" + shared_key + ", companyId=" + companyId
				+ ", minvalue=" + minvalue + ", maxvalue=" + maxvalue + ", unit=" + unit + "]";
	}
	public double getMaxvalue() {
		return maxvalue;
	}
	public void setMaxvalue(double maxvalue) {
		this.maxvalue = maxvalue;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	private double maxvalue;
	
	@NotEmpty
	private String unit;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShared_key() {
		return shared_key;
	}
	public void setShared_key(String shared_key) {
		this.shared_key = shared_key;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public String getData()
	{
		java.util.Random rad=new java.util.Random();
		return Double.toString((rad.nextDouble())*maxvalue+minvalue);
	}
}
