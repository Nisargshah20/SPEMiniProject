package com.spe.controller;

import com.spe.model.Problems;
import com.spe.service.ProblemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private ProblemsService problemsService;
	
	@RequestMapping(value= {"/home"})
    public ModelAndView home(HttpSession session, RedirectAttributes redirectAttributes) {
	    if(session.getAttribute("username")==null){
	        ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
	        return model;
        }
        ModelAndView model = new ModelAndView("home");
	    List<Problems> problems = new ArrayList<>(problemsService.findAll());
	    model.addObject("problems",problems);
        return model;
    }
}
