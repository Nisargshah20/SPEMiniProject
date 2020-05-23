package com.spe.controller;

import com.spe.model.Leaderboard;
import com.spe.model.Problems;
import com.spe.service.LeaderboardService;
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
    @Autowired
    private LeaderboardService leaderboardService;
	
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

    @RequestMapping(value= {"/submitproblem"})
    public ModelAndView submitproblem(HttpSession session, RedirectAttributes redirectAttributes) {
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        ModelAndView model = new ModelAndView("submitproblem");
        return model;
    }

    @RequestMapping(value= {"/upcoming_contests"})
    public ModelAndView upcomingcontest(HttpSession session, RedirectAttributes redirectAttributes) {
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        ModelAndView model = new ModelAndView("upcoming_contests");
        return model;
    }

    @RequestMapping(value= {"/hostcontest"})
    public ModelAndView hostcontest(HttpSession session, RedirectAttributes redirectAttributes) {
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        ModelAndView model = new ModelAndView("hostcontest");
        return model;
    }

    @RequestMapping(value= {"/discussion"})
    public ModelAndView discussion(HttpSession session, RedirectAttributes redirectAttributes) {
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        ModelAndView model = new ModelAndView("discussion");
        return model;
    }

    @RequestMapping(value= {"/leaderboard"})
    public ModelAndView leaderboard(HttpSession session, RedirectAttributes redirectAttributes) {
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        ModelAndView model = new ModelAndView("leaderboard");
        List<Leaderboard> leaderboard = new ArrayList<>(leaderboardService.getLeaderboard());
        model.addObject("leaderboard",leaderboard);
        return model;
    }
}
