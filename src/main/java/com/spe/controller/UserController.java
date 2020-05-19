package com.spe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value= {"/", "/index"}, method=RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("index","index",new User());
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
    public ModelAndView signup() {
        return new ModelAndView("signup","signup",new User());
    }

   /* @RequestMapping(value= {"/home"}, method=RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();

        model.setViewName("html/home");
        return model;
    }*/

   /* @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User emailExists = userService.findUserByEmail(user.getEmail());
        User usernameExists = userService.findUserByUsername(user.getUsername());

        if(emailExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }else if(usernameExists != null) {
            bindingResult.rejectValue("username", "error.user", "This username already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("html/signup");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            model.setViewName("html/login");
        }

        return model;
    }*/

    /*
    @RequestMapping(value= {"/login"}, method=RequestMethod.POST)
    public ModelAndView checkUser(@RequestParam("email")String email, @RequestParam("password")String password, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User emailExists = userService.findUserByEmail(email);

        if(emailExists == null) {
            bindingResult.rejectValue("email", "error.user", "This email not valid");
        }else if(password != emailExists.getPassword()) {
        	bindingResult.rejectValue("password", "error.user", "Password is not correct");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("html/login");
        } else {
            model.setViewName("html/home");
        }

        return model;
    }*/
}
