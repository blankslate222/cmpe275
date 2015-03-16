package edu.sjsu.cmpe275.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String displayForm(Model model) {
		// System.out.println(" in controller ");
		model.addAttribute("homePage", new HomePage());
		return "homeCreate";
	}

	@RequestMapping(value = "/homepage/{userId}", method = RequestMethod.GET)
	public String displayHomePage(
			@PathVariable String userId,
			@RequestParam(value = "brief", required = false, defaultValue = "false") String mode,
			Model model) {
		String returnView = null;

		if (null == userId) {
			model.addAttribute("homePage", new HomePage());
			returnView = "homeCreate";
		}

		if (null != userId) {
			HomePage home = getHomePageService().findHomeById(userId);
			if (home != null){
				model.addAttribute("homePage", home);
				returnView = "home";
				
				if (mode.equals("true")) {
					// return read only json view
				}
			}else{
				String errMsg = "User: " + userId;
				model.addAttribute("error_message", errMsg);
				returnView = "error";
			}
				
		}
		return returnView;
	}

	@RequestMapping(value = "/homepage", method = RequestMethod.POST)
	public String createOrUpdateHomePage(
			@ModelAttribute("homePage") HomePage hp, BindingResult result,
			ModelMap model) {
		String retView = null;
		String user = hp.getId();
		HomePageDao dao = getHomePageService();
		if (dao.findHomeById(user) != null) {
			System.out.println("inside update");
			dao.update(user, hp);
			retView = "redirect:/homepage/" + user;
		} else if (getHomePageService().create(hp)) {
			System.out.println("inside create");
			retView = "redirect:/homepage/" + user;
		} else {
			retView = "badrequest";
		}
		return retView;
	}

}
