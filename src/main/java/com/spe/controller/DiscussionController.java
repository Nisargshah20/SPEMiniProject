package com.spe.controller;

import com.spe.model.Discussion;
import com.spe.model.ProblemDiscussion;
import com.spe.service.DiscussionService;
import com.spe.service.ProblemDiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
public class DiscussionController {
    @Autowired
    private DiscussionService discussionService;
    @Autowired
    private ProblemDiscussionService problemDiscussionService;

    @RequestMapping(value= {"/discussion"},method = RequestMethod.GET)
    public ModelAndView discussion(HttpSession session, RedirectAttributes redirectAttributes) {
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        ModelAndView model = new ModelAndView("discussion");
        List<Discussion> discussion = discussionService.getDiscussion();
        model.addObject("discussion",discussion);
        return model;
    }

    @RequestMapping(value= {"/discussion"},method = RequestMethod.POST)
    public ModelAndView discussionPost(@RequestParam(value="comment")String comment, HttpSession session, RedirectAttributes redirectAttributes) {
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        ModelAndView model = new ModelAndView("redirect:/discussion");
        Discussion discussion = new Discussion();
        if(comment==""){
            redirectAttributes.addFlashAttribute("result","Post can't be empty");
            return model;
        }
        discussion.setComment(comment);
        discussion.setUsername((String) session.getAttribute("username"));
        discussion.setDoj(new Date());
        discussionService.saveDiscussion(discussion);
        return model;
    }

    @RequestMapping(value= {"/problemdiscussion"},method = RequestMethod.GET)
    public ModelAndView problemdiscussion(HttpSession session, RedirectAttributes redirectAttributes) {
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        ModelAndView model = new ModelAndView("problemdiscussion");
        List<ProblemDiscussion> problemDiscussion = problemDiscussionService.getProblemDiscussion((Long) session.getAttribute("id"));
        model.addObject("problemDiscussion",problemDiscussion);
        return model;
    }
}
