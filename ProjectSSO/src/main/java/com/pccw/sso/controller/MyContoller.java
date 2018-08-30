package com.pccw.sso.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.pccw.sso.dao.UserDetailsDao;
import com.pccw.sso.model.Authorities;
import com.pccw.sso.model.ClientCredential;
import com.pccw.sso.model.Employee;
import com.pccw.sso.model.User;
import com.pccw.sso.model.UserProfile;
import com.pccw.sso.service.ClientCredentialService;
import com.pccw.sso.service.EmployeeService;
import com.pccw.sso.service.UserService;


/**
 * 
 * ProjectSSO 
 * @author Marvin Manguiat
 * @created 28 Aug 2018
 *
 */

@Controller
public class MyContoller {

	final static Logger logger = Logger.getLogger(MyContoller.class);
	
	/**
	 * One Ring to rule them all, One Ring to find them,
     * One Ring to bring them all and in the darkness bind them
	 */
	
 
	@Autowired(required=true)
	UserService userService;
	
	@Autowired(required=true)
	ClientCredentialService clientCredentialService;
	
	
	@RequestMapping("/test")
	public void test(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html");
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printWriter.println("Hello World!");
		RequestDispatcher rd = null;
		rd =  request.getRequestDispatcher("/WEB-INF/views/Test.jsp");
		
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/")
	public String index(Model model, Principal principal) {
		User user = userService.getUser(principal.getName());
		model.addAttribute("message", " Welcome back  " + principal.getName());
		model.addAttribute("user", user);
		
		UserProfile profile = user.getUserProfile();
		if(profile!=null) {
			System.out.println(profile.getEmailAddress());
			return "index";
		}
		
		return "ProfileForm";
		
		
	}
	
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String signUp(Model model) {
		 User user = new User();
	        model.addAttribute("user", user);
	        return "sign-up";
	}
	
	
	  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
	    public ModelAndView saveUser(@ModelAttribute User user) {
	        if (user.getUserId()==null) { // if employee id is 0 then creating the
	        	user.setEnabled(true);
	        	String encoded=new BCryptPasswordEncoder().encode(user.getPassword());
	        	user.setPassword(encoded);
	        	userService.addNewUser(user);
	        } 
	        return new ModelAndView("redirect:/");
	    }
	

	/*
	 *  @RequestMapping( value = "/authorize" , method = RequestMethod.GET, produces = "application/json")
	 */
	
	@RequestMapping("/login")
	public String   login(Model model, Principal principal, @RequestParam("error") Optional<String> loginError) {
		if(loginError.isPresent()) {
			System.out.println("loginError: "+loginError.isPresent());
			model.addAttribute("error", "Login failed!");
		}
		return "/login";
	}
	
	@RequestMapping("/authorize")
	public ModelAndView   authorize(Model model, Principal principal, 
			@RequestParam("response_type") String responseType,
			@RequestParam("client_id") String clientId, 
			@RequestParam("redirect_uri") String redirectUri,
			@RequestParam("scope") String scope, @RequestParam("state") String state,
			@RequestParam("grant_type") Optional<String> grantType,
			@RequestParam("client_secret") Optional<String> clientSecret,HttpServletResponse httpServletResponse) {

		boolean clientIdValid = false;
		
		String returnUrl = null;
	
		/**
		 * 1. validate: Check client_id, redirect url return 404 if not found in the
		 * system var: clientId, redirectUri if valid then set clientIdValid = true
		 */
		
		 ClientCredential  cred = clientCredentialService.getClientCredentials(clientId);
		 
		 if(cred!=null && cred.getCallBackUrl().equals(redirectUri) ) {
			 System.out.println(cred.getClientSecret());
			 clientIdValid = true;
			 returnUrl = cred.getCallBackUrl();
		 }

		/**
		 * 2. validate response type; response type Flow code AUTHORIZATION token
		 * IMPLICIT
		 */

		if ("code".equalsIgnoreCase(responseType) && clientIdValid) {
			// process Auhtorization Flow
		} else if ("token".equalsIgnoreCase(responseType) && clientIdValid) {
			// process Implicit Flow
		}
		
		//generate authorizarion code 
		String authorizationCode  = UUID.randomUUID().toString();

		StringBuffer sf = new StringBuffer();
		sf.append(returnUrl);
		sf.append("?code=");
		sf.append(authorizationCode);
		sf.append("&scope=");
		sf.append(scope);
		System.out.println(sf.toString());
		
		 return new ModelAndView("redirect:" + sf);
	}

	@RequestMapping("/token")
	@ResponseBody
	public String token(@RequestParam("grant_type") String grantType, @RequestParam("client_id") String clientId,
			@RequestParam("client_secret") Optional<String> clientSecret,
			@RequestParam("redirect_uri") String redirectUri, @RequestParam("code") String code) {

		if (logger.isInfoEnabled()) {
			logger.info("validation client_id: " + clientId + " ");
		}

		return "grantType:  " + grantType;

	}
	
	
	@RequestMapping("/403")
	public String accesssDenied(Model model, Principal user) {
		model.addAttribute("user",user);
		return "403";

	}
}