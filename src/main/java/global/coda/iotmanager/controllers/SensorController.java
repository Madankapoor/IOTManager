package global.coda.iotmanager.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import global.coda.iotmanager.models.Company;
import global.coda.iotmanager.models.CompanyHeader;
import global.coda.iotmanager.models.Sensor;
import global.coda.iotmanager.models.SensorData;
import global.coda.iotmanager.services.intf.CompanyListService;
import global.coda.iotmanager.services.intf.SensorService;

@Controller
public class SensorController {
	@Autowired
	private SensorService sensorService;
	@Autowired
	private CompanyListService companyListService;
	
	private static final Logger logger = LoggerFactory.getLogger(SensorController.class);
	
	
	@RequestMapping( path="/simulate",method = RequestMethod.GET)
	public ModelAndView getSimulate(@RequestParam(value="ID",required = false) String companyId,@RequestParam(value="SID",required = true) String sensorId )
	{
		String userEmail=getAuthenticatedEmail();
		ModelAndView mav=new ModelAndView("/sensor/simulate");
		mav.addObject("email",userEmail);
		try {
			if(companyId!=null && !companyId.equals(""))
			{
				mav.addObject("companyId", companyId);
				Company cmp=companyListService.getCompany(companyId);
				if(cmp.validateUser(userEmail))
					mav.addObject("cmp", cmp);
			}
			List<CompanyHeader> list=companyListService.getCompanyHeader(userEmail);
			mav.addObject("companies",list);
			mav.addObject("sensorId", sensorId);
			Sensor sr=sensorService.getSensor(sensorId);
			mav.addObject("sensorObject",sr );
			String data=sr.getData();
			mav.addObject("value",data );
			mav.addObject("unit", sr.getUnit());
			sensorService.addSensorReading(sr,data);
		
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error("Exception at CompanyController:",e);
		}
		return mav;
	}
	
	@RequestMapping( path="/graph",method = RequestMethod.GET)
	public ModelAndView getGraph(@RequestParam(value="ID",required = true) String companyId,@RequestParam(value="SID",required = true) String sensorId )
	{
		String userEmail=getAuthenticatedEmail();
		ModelAndView mav=new ModelAndView("/sensor/graph");
		mav.addObject("email",userEmail);
		try {
			if(companyId!=null && !companyId.equals(""))
			{
				mav.addObject("companyId", companyId);
				Company cmp=companyListService.getCompany(companyId);
				if(cmp.validateUser(userEmail))
					mav.addObject("cmp", cmp);
			}
			List<CompanyHeader> list=companyListService.getCompanyHeader(userEmail);
			mav.addObject("companies",list);
			
			
			
			mav.addObject("sensorId", sensorId);
			
			SensorData srd=sensorService.getSensorData(sensorId);
			mav.addObject("sensorData", srd);
		
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error("Exception at CompanyController:",e);
		}
		return mav;
	}
	
	
	@RequestMapping( path="/getupdate",method = RequestMethod.GET)
	public ModelAndView getUpdate(@RequestParam(value="ID",required = false) String companyId,@RequestParam(value="SID",required = true) String sensorId )
	{
		String userEmail=getAuthenticatedEmail();
		ModelAndView mav=new ModelAndView("/sensor/update");
		mav.addObject("email",userEmail);
		try {
	
			mav.addObject("sensorId", sensorId);
			Sensor sr=sensorService.getSensor(sensorId);
			mav.addObject("sensorObject",sr );
			
			SensorData srd=sensorService.getSensorData(sensorId);
			mav.addObject("sensorData", srd);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error("Exception at CompanyController:",e);
		}
		return mav;
	}
	
	@RequestMapping( path="/addsensor",method = RequestMethod.GET)
	public ModelAndView getAddSensor(@RequestParam(value="ID",required=true) String companyId)
	{
		String userEmail=getAuthenticatedEmail();
		ModelAndView mav=new ModelAndView("/sensor/add");
		
		
		mav.addObject("email",userEmail);
		
		try {
			
			
			if(companyId!=null && !companyId.equals(""))
			{
				mav.addObject("companyId", companyId);
				Company cmp=companyListService.getCompany(companyId);
				if(cmp.validateUser(userEmail))
					mav.addObject("cmp", cmp);
			}
			List<CompanyHeader> list=companyListService.getCompanyHeader(userEmail);
			mav.addObject("companies",list);
			
			
			
			
			mav.addObject("sensor", new Sensor());
		
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error("Exception at CompanyController:",e);
		}
		
		
		return mav;
	}
	
	@RequestMapping( path="/addsensor",method = RequestMethod.POST)
	public ModelAndView postAddSensor(@Valid Sensor sr,BindingResult result)
	{
		String userEmail=getAuthenticatedEmail();
		String companyId=sr.getCompanyId();
		if(result.hasErrors())
		{
			
			ModelAndView mav=new ModelAndView("/sensor/add");
			mav.addObject("email",userEmail);
			try {
				if(companyId!=null && !companyId.equals(""))
				{
					mav.addObject("companyId", companyId);
					Company cmp=companyListService.getCompany(companyId);
					if(cmp.validateUser(userEmail))
						mav.addObject("cmp", cmp);
				}
				List<CompanyHeader> list=companyListService.getCompanyHeader(userEmail);
				mav.addObject("companies",list);
				mav.addObject("sensor", sr);
			
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				logger.error("Exception at CompanyController:",e);
			}
			
			
			return mav;
		}
		ModelAndView mav=new ModelAndView("/main/final");
		mav.addObject("email",userEmail);
		
		try {
			
			
			if(companyId!=null && !companyId.equals(""))
			{
				mav.addObject("companyId", companyId);
				Company cmp=companyListService.getCompany(companyId);
				if(cmp.validateUser(userEmail))
					mav.addObject("cmp", cmp);
			}
			List<CompanyHeader> list=companyListService.getCompanyHeader(userEmail);
			mav.addObject("companies",list);
			
			
			
			logger.debug(sr.toString());
			sensorService.addSensor(sr);
		
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error("Exception at CompanyController:",e);
		}
		
		
		return mav;
	}
	
	
	private String getAuthenticatedEmail()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    return auth.getName(); //get logged in username
	}


	public SensorService getSensorService() {
		return sensorService;
	}


	public void setSensorService(SensorService sensorService) {
		this.sensorService = sensorService;
	}

	public CompanyListService getCompanyListService() {
		return companyListService;
	}

	public void setCompanyListService(CompanyListService companyListService) {
		this.companyListService = companyListService;
	}
	
	
	
}
