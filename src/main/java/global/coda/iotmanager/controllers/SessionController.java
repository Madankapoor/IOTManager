package global.coda.iotmanager.controllers;



import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import global.coda.iotmanager.models.User;
import global.coda.iotmanager.services.intf.*;
import org.springframework.web.context.support.WebApplicationContextUtils;

import global.coda.iotmanager.utils.*;


@Controller
public class SessionController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(SessionController.class);
	
	@Autowired
	private UserRegisterService registerService;
	
	@Autowired
	ServletContext servletContext;
	
	//private ApplicationContext app;

	
	
	public UserRegisterService getRegisterService() {
		return registerService;
	}



	public void setRegisterService(UserRegisterService registerService) {
		this.registerService = registerService;
	}



	@RequestMapping( path="/login",method = RequestMethod.GET)
	public ModelAndView getLogin(@RequestParam(value = "login_error", required = false) String error,
			@RequestParam(value = "logout_success", required = false) String logout)
	{	ModelAndView mav=new ModelAndView();
	
		mav.setViewName("session/login");
		 if (error != null) {
			 mav.addObject("flash_danger", "Invalid email or password");
		 }

		 if (logout != null) {
			 	
				  mav.addObject("flash_success", "You've been logged out successfully.");
		}
		logger.debug("login get method called", "session");

		
		return mav;
	}
	
	
	
	@RequestMapping( path="/register",method = RequestMethod.GET)
	public ModelAndView getRegister()
	{
		ModelAndView mav=new ModelAndView("/session/register","user",new User());
		
		return mav;
	}
	
	@RequestMapping( path="/register",method = RequestMethod.POST)
	public ModelAndView postRegister(@Valid  User usr,BindingResult result) 
	{
		logger.debug(usr.toString());
		//app=WebApplicationContextUtils.findWebApplicationContext(servletContext);
		//registerService=(UserRegisterService)app.getBean("registerService");
		if(result.hasErrors())
		{
			ModelAndView mav=new ModelAndView("/session/register");
			mav.addObject("user",usr);
			return mav;
		}
		
		try {
		if(registerService!=null)
		{	
			if(registerService.checkUser(usr))
			{
				ModelAndView mav=new ModelAndView("session/register");
				mav.addObject("flash_danger","The Entered Email is already registered with another account.");
				mav.addObject("user",usr);
				return mav;
			}
			
			if(registerService.addUser(usr))
					logger.debug("User Registration Successfull");
			else logger.debug("User registration failed");
		}
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error(e.toString(),e);
			
			
		}
		ModelAndView mav=new ModelAndView("/session/login");
		mav.addObject("flash_success","You have been successfully Registered , Please login");
		
		return mav;
	}

	
	
	

}
