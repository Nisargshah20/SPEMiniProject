package com.spe.controller;

import org.apache.tomcat.jni.Proc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import org.apache.commons.io.FileUtils;

@RestController
public class ProblemController {

    @RequestMapping(value = {"/problems"})
    public ModelAndView problem(@RequestParam(value = "id") String id, HttpSession session, RedirectAttributes redirectAttributes){
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        System.out.println(id);
        ModelAndView model = new ModelAndView("problem");
        session.setAttribute("id",id);
        model.addObject("pid",id);
        return model;
    }

    @RequestMapping(value = {"/submit"},method = RequestMethod.POST)
    public ModelAndView submit(@RequestParam(value = "content") String content, @RequestParam(value = "input") String input, HttpSession session, RedirectAttributes redirectAttributes) throws IOException, InterruptedException {
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        System.out.println(content);
        String username = (String) session.getAttribute("username");
        String id = (String) session.getAttribute("id");
        String path = "./src/main/resources/"+username;
        File file = new File(path);
        if(!file.exists())
            file.mkdir();
        path = "./src/main/resources/"+username+'/'+id;
        file = new File(path);
        if(!file.exists())
            file.mkdir();
        File code = new File(path+'/'+"userprogram.cpp");
        FileWriter writer = new FileWriter(code);
        writer.write(content);
        writer.close();
        File test = new File(path+'/'+"userinput.txt");
        writer = new FileWriter(test);
        writer.write(input);
        writer.close();
        session.setAttribute("code",content);

        String ui_path = "src/main/resources/" + username + "/" + id + "/userinput.txt";
        String ue_path = "src/main/resources/" + username + "/" + id + "/usererror.txt";
        String uo_path = "src/main/resources/" + username + "/" + id + "/useroutput.txt";
        String ucode_path = "src/main/resources/" + username + "/" + id + "/userprogram.cpp";

        String cmd = "touch " + ue_path;
        Process a = Runtime.getRuntime().exec(cmd);
        a.waitFor();
        String cmd1 = "g++ " + ucode_path + " < " + ui_path + " 2 > " + ue_path;
       /* String cmd2 = "g++ " + ucode_path + " -o " + "tc";
        String cmd3 = "./tc < " + ui_path + " > " + uo_path;*/
        Process b = Runtime.getRuntime().exec(cmd1);
        /*Runtime.getRuntime().exec(cmd2);
        Runtime.getRuntime().exec(cmd3);*/

        return new ModelAndView("redirect:/problems?id="+id);
    }
}
