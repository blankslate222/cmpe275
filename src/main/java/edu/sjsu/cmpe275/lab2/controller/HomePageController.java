package edu.sjsu.cmpe275.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sjsu.cmpe275.lab2.dao.HomePageDao;
import edu.sjsu.cmpe275.lab2.model.HomePage;

@Controller
public class HomePageController {

	private HomePageDao homePageService;
	
	public HomePageDao getHomePageService() {
		return homePageService;
	}
	
	@Autowired
	public void setHomePageService(HomePageDao homePageService) {
		this.homePageService = homePageService;
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		// System.out.println(" in controller ");
		model.addAttribute("message", "Home page");
		return "welcome";
	}

//	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
//	public String displayForm(Model model) {
//		model.addAttribute("homePage", new HomePage());
//		return "homeCreate";
//	}

	@RequestMapping(value = "/homepage/{userId}", method = RequestMethod.GET)
	public String displayHomePage(
			@PathVariable String userId,
			@RequestParam(value = "brief", required = false, defaultValue = "false") String mode,
			Model model) {
		String returnView = null;
		
		if (null == userId) {
			model.addAttribute("homePage", new HomePage());
			returnView = "homeCreate";
		} else if (null != userId && mode.equals("false")) {
			model.addAttribute("homePage", getHomePageService().findHomeById(userId));
			returnView = "home";
		} else {
			//return read only json view
		}
		return returnView;
	}
	
	@RequestMapping(value = "/homepage", method = RequestMethod.POST)
	public String createHomePage(Model model){
		
		return "home";
	}
	
	public String  
}
