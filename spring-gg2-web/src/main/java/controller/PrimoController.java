package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import business.PersonaManager;
import model.Persona;

@Controller
public class PrimoController {
	
	@Autowired
	private PersonaManager pm;
	
	// solo view
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public String primo() {
		return "saluta";
	}
	
	// model + view
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
	
	@RequestMapping(value="/hello2", method=RequestMethod.POST)
	public String doppioMapping() {
		return "saluta";
	}
	
	
	// solo model => l'inizio per poter crealizzare una WebAPI (RESTful web application)
	@RequestMapping(value="/personeJSON", method=RequestMethod.GET)
	public @ResponseBody List<Persona> personeJSON() {
		return pm.elencoPersoneDb1();
	}

}
