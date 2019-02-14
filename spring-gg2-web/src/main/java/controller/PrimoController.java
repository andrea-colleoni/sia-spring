package controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import business.PersonaManager;

@Controller
public class PrimoController {
	
	@Autowired
	private PersonaManager pm;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String primo() {
		return "saluta";
	}
	
	@RequestMapping(value="/oggi", method=RequestMethod.GET)
	public ModelAndView pippo() {
		Date oggi = new Date();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("saluta");
		mav.addObject("adesso", oggi);
		return mav;
	}
	
	@RequestMapping(value="/persone", method=RequestMethod.GET)
	public ModelAndView persone() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("saluta");
		mav.addObject("persone", pm.elencoPersoneDb1());
		return mav;
	}

}
