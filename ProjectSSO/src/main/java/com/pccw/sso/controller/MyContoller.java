package com.pccw.sso.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
import com.pccw.sso.util.SSOSystemUtil;

/**
 * 
 * ProjectSSO
 * 
 * @author Marvin Manguiat
 * @created 28 Aug 2018
 *
 */

@Controller
public class MyContoller {

	@Autowired
	private UserService userService;

	@Autowired
	private ClientCredentialService clientCredentialService;

	final static Logger logger = Logger.getLogger(MyContoller.class);
	
	
	@RequestMapping("/layout")
	public String getLayout() {
		return "layout";
	}

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

		String name = null;
		if (request.getQueryString() != null) {
			name = request.getQueryString().toString();
		}

		System.out.println("name: " + name);

		printWriter.println("Hello World!");

		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/WEB-INF/views/Test.jsp");

		try {
			rd.include(request, response);
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
		if (profile != null) {
			System.out.println(profile.getEmailAddress());
			return "index";
		}

		return "ProfileForm";

	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String signUp(Model model) {
		User user = new User();
		user.setUserProfile(new UserProfile());
		model.addAttribute("user", user);
		return "sign-up";
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
		boolean passwordDidnotMatched = false;
		String fieldMatchCode = "";
		String fieldMatchMessage = "";
		String fieldObjectName = "";
		if (bindingResult.hasErrors()) {
			List<ObjectError> errorlist = bindingResult.getAllErrors();
			Iterator elist = errorlist.iterator();
			while (elist.hasNext()) {
				ObjectError err = (ObjectError) elist.next();
				if ("FieldsValueMatch".equalsIgnoreCase(err.getCode())) {
					passwordDidnotMatched = true;
				}
			}
			if (passwordDidnotMatched) {
				bindingResult.rejectValue("password", "user", "Password mis-matched.");
				bindingResult.rejectValue("repassword", "user", "Password mis-matched.");
			}
			return "sign-up";
		}

		if (user.getUserId() == null) { // if employee id is 0 then creating the
			user.setEnabled(true);
			String encoded = SSOSystemUtil.getPasswordEncoder().encode(user.getPassword());
			user.setPassword(encoded);
			user.setRepassword(user.getPassword());
			

			String firstname = user.getUserProfile().getFirstname();

			System.out.println(firstname);

			userService.addNewUser(user);

		}

		return "redirect:/";
	}

	/*
	 * @RequestMapping( value = "/authorize" , method = RequestMethod.GET, produces
	 * = "application/json")
	 */

	@RequestMapping("/login")
	public String login(Model model, Principal principal, @RequestParam("error") Optional<String> loginError) {
		if (loginError.isPresent()) {
			System.out.println("loginError: " + loginError.isPresent());
			model.addAttribute("error", "Login failed!");
		}
		return "/login";
	}

	@RequestMapping("/authorize")
	public ModelAndView authorize(Model model, Principal principal, @RequestParam("response_type") String responseType,
			@RequestParam("client_id") String clientId, @RequestParam("redirect_uri") String redirectUri,
			@RequestParam("scope") String scope, @RequestParam("state") String state,
			@RequestParam("grant_type") Optional<String> grantType,
			@RequestParam("client_secret") Optional<String> clientSecret, HttpServletResponse httpServletResponse) {

		boolean clientIdValid = false;

		String returnUrl = null;

		/**
		 * 1. validate: Check client_id, redirect url return 404 if not found in the
		 * system var: clientId, redirectUri if valid then set clientIdValid = true
		 */

		ClientCredential cred = clientCredentialService.getClientCredentials(clientId);

		if (cred != null && cred.getCallBackUrl().equals(redirectUri)) {
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

		// generate authorizarion code
		String authorizationCode = UUID.randomUUID().toString();

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
		model.addAttribute("user", user);
		return "403";

	}
}