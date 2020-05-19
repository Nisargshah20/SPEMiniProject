package com.spe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.*;

import com.spe.model.User;
import com.spe.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value= {"/index"}, method=RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("index");
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
    public ModelAndView signup() {
        return new ModelAndView("signup");
    }

   /* @RequestMapping(value= {"/home"}, method=RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();

        model.setViewName("html/home");
        return model;
    }*/

    @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
    public ModelAndView createUser(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("email")String email) {
        ModelAndView model = new ModelAndView();
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        User emailExists = userService.findUserByEmail(email);
        User usernameExists = userService.findUserByUsername(username);
        System.out.println(user.getEmail() + user.getPassword() + user.getUsername());
        if(emailExists != null) {
        	model = new ModelAndView("signup");
            model.addObject("result","Email Already Exists");
        }else if(usernameExists != null) {
        	model = new ModelAndView("signup");
            model.addObject("result","Username Already Exists");
        }else {
            userService.saveUser(user);
            model = new ModelAndView("index");
            model.addObject("result","Registered Successfully");
        }

        return model;
    }
    
    @RequestMapping(value= {"/index"}, method=RequestMethod.POST)
    public ModelAndView checkUser(@RequestParam("username")String username, @RequestParam("password")String password,  HttpSession session) {
        ModelAndView model = new ModelAndView();
        boolean userExists = userService.doesUserExists(username);

        if(userExists == false) {
        	model = new ModelAndView("index");
            model.addObject("result","Username is invalid");
        }else{
        	User user = userService.findUserByUsername(username);
        	if(password.equals(user.getPassword())){
        		session.setAttribute("username", username);
        		model = new ModelAndView("home");
        	}else {
        		model = new ModelAndView("index");
                model.addObject("result","Password is invalid");
        	}
        }
       
        return model;
    }
}
