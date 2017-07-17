package global.coda.iotmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import global.coda.iotmanager.services.intf.CompanyListService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyListService companyListService;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@RequestMapping( path="/",method = RequestMethod.GET)
	public ModelAndView getMain(@RequestParam(value="ID",required = false) String companyId )
	{
		String userEmail=getAuthenticatedEmail();
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
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error("Exception at CompanyController:",e);
		}
		
		
		return mav;
	}
	
	
	@RequestMapping(path="/addcompany",method= RequestMethod.GET)
	public ModelAndView getAddCompany( )
	{
		String userEmail=getAuthenticatedEmail();
		ModelAndView mav=new ModelAndView("/company/add");
		
		
		mav.addObject("email",userEmail);
		
		try {
			
			List<CompanyHeader> list=companyListService.getCompanyHeader(userEmail);
			mav.addObject("companies",list);
			mav.addObject("company",new Company() );
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error("Exception at CompanyController:",e);
		}
		
		
		return mav;
	}
	
	

	@RequestMapping(value="addcompany",method= RequestMethod.POST)
	public ModelAndView postAddCompany(@Valid Company cmp, BindingResult result )
	{
		String userEmail=getAuthenticatedEmail();

		if(result.hasErrors())
		{
			ModelAndView mav=new ModelAndView("/company/add");
			mav.addObject("email",userEmail);
			try {
				
				List<CompanyHeader> list=companyListService.getCompanyHeader(userEmail);
				mav.addObject("companies",list);
				mav.addObject("company",cmp );

			} catch (Throwable e) {
				// TODO Auto-generated catch block
				logger.error("Exception at CompanyController:",e);
			}
			return mav;
		}
		
		List<CompanyHeader> list;
		ModelAndView mav=null;
		try {
			cmp.setAdminEmail(userEmail);
			companyListService.addCompany(cmp);
			
			list=companyListService.getCompanyHeader(userEmail);
			mav=new ModelAndView("/main/final","companies",list);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.debug("The error is ",e);
		}
		
		return mav;
	}
	
	
	@RequestMapping( path="/adduser",method = RequestMethod.GET)
	public ModelAndView addUser(@RequestParam(value="addemail",required=true) String email,@RequestParam(value="ID",required=true) String cid)
	{
		ModelAndView mav=new ModelAndView("company/adduser");
		
		String userEmail=getAuthenticatedEmail();
		
		try {
			Company cmp=companyListService.getCompany(cid);
			if(cmp.validateAdmin(userEmail) && !cmp.validateUser(email))
			{	
				
				
				companyListService.addUser(userEmail,email,cid,"USER");
			
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.debug("The error in adding user",e);
		}
		
		return mav;
		
	}
	
	
	private String getAuthenticatedEmail()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    return auth.getName(); //get logged in username
	}


	public CompanyListService getCompanyListService() {
		return companyListService;
	}


	public void setCompanyListService(CompanyListService companyListService) {
		this.companyListService = companyListService;
	}
}
