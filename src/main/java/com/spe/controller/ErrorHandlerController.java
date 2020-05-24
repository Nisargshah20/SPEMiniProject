package com.spe.controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ErrorHandlerController implements ErrorController{

    @Override
    @RequestMapping("/error")
    @ResponseBody
    public String getErrorPath() {
        return "Something Went Wrong Please contact to the Administration";
    }
}