package com.star.sud.zip.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.star.sud.zip.dto.UserDetail;
import com.star.sud.zip.service.ZipService;

@Controller
public class HomeController {

	private static final Logger log = Logger.getLogger(HomeController.class);

	@Autowired
	@Qualifier("zipService")
	private ZipService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage(Model model) {
		try {
			model.addAttribute("userDetail", new UserDetail());
		} catch (Exception e) {
			log.error("getHomePage", e);
		}
		return "home";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveData(Model model, @ModelAttribute UserDetail userDetail) {
		log.debug("saveData");
		try {
			service.saveData(userDetail);
		} catch (Exception e) {
			log.error("saveData", e);
		}
		return "home";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downloadZipFile() {
		log.debug("downloadZipFile");
		try {
			service.generateZipFile();

		} catch (Exception e) {
			log.error("downloadZipFile", e);
		}
	}

}
