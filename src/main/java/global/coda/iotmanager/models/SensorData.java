package global.coda.iotmanager.models;

import java.util.ArrayList;
import java.util.List;

public class SensorData {
	List<String> label;
	List<String> data;
	public List<String> getLabel() {
		return label;
	}
	public void setLabel(List<String> label) {
		this.label = label;
	}
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
	public SensorData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		label=new ArrayList<String>();
		data=new ArrayList<String>();
	}
	public void addData(String time,String d)
	{
		label.add(time);
		data.add(d);
	}
	
	public String getLabelsString()
	{
		 StringBuilder label2=new StringBuilder("");
		 
		 for(String l:label)
			 label2.append("\""+l+"\",");
		 
		 if (label2.length() > 0) {
		        label2.setLength(label2.length() - 1);
		 }
		 
		 return label2.toString();
	}
	
	public String getDataString()
	{	
		StringBuilder data2=new StringBuilder("");
		
		for(String d:data)
			data2.append(d+",");
		
		if(data2.length() > 0) 
		{
	        data2.setLength(data2.length() - 1);
	    }
		
		return data2.toString();
	}
}
