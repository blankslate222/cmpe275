package edu.sjsu.cmpe275.lab2.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
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
	public String displayHomePage(@PathVariable String userId, Model model,
			@RequestParam(value = "brief", required = false) boolean brief)
			throws JsonGenerationException, JsonMappingException, IOException {
		String returnView = null;
		if (null == userId) {
			model.addAttribute("homePage", new HomePage());
			returnView = "homeCreate";
		}

		if (null != userId) {
			HomePage home = getHomePageService().findHomeById(userId);
			if (home != null) {
				model.addAttribute("homePage", home);
				returnView = "home";
				if (brief) {
					// System.out.println("inside brief");
					ObjectWriter ow = new ObjectMapper().writer()
							.withDefaultPrettyPrinter();
					String json = ow.writeValueAsString(home);
					model.addAttribute("jsonString", json);
					returnView = "jsonview";
				}
			} else {
				String errMsg = "User: " + userId;
				model.addAttribute("error_message", errMsg);
				returnView = "error";
			}

		}
		return returnView;
	}

	@RequestMapping(value = "/homepage/{userId}", method = RequestMethod.POST)
	public String updateHomePage(
			@ModelAttribute("homePage") HomePage hp, BindingResult result,
			@PathVariable("userId") String userId, ModelMap model) {
		String retView = null;
		String user = userId;
		retView = "redirect:/homepage/" + user;
		if(getHomePageService().update(user, hp)) {
			retView = "redirect:/homepage/" + user;
		} else {
			retView = "badrequest";
		}
		return retView;
	}
	
	@RequestMapping(value = "/homepage", method = RequestMethod.POST)
	public String createHomePage(
			@ModelAttribute("homePage") HomePage hp, BindingResult result,
			ModelMap model) {
		String retView = null;
		String user = hp.getId();
		if (getHomePageService().create(hp)) {
			retView = "redirect:/homepage/" + user;
		} else {
			retView = "badrequest";
		}
		return retView;
	}

	@RequestMapping(value = "/homepage/{userId}", method = RequestMethod.DELETE)
	public String deleteHomePage(@PathVariable String userId,
			@ModelAttribute("homePage") HomePage hp, ModelMap model) {
		System.out.println("Inside Delete Method");
		String retView = null;
		HomePageDao dao = getHomePageService();
		if (dao.findHomeById(userId) != null) {
			dao.delete(userId);
			retView = "redirect:/homepage";
		} else {
			String errMsg = "User: " + userId;
			model.addAttribute("error_message", errMsg);
			retView = "error";
		}
		return retView;
	}
}
