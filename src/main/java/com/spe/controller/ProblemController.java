package com.spe.controller;

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
    public ModelAndView submit(@RequestParam(value = "content")String content,@RequestParam(value = "input")String input, HttpSession session) throws IOException {
        System.out.println(content);
        String username = (String) session.getAttribute("username");
        String id = (String) session.getAttribute("id");
        String path = "./src/main/resources/"+username;
        File file = new File(path);
        if(!file.exists())
            file.mkdir();
        File code = new File(path+'/'+id+".cpp");
        FileWriter writer = new FileWriter(code);
        writer.write(content);
        writer.close();
        File test = new File(path+'/'+id+".txt");
        writer = new FileWriter(test);
        writer.write(input);
        writer.close();
        return new ModelAndView("redirect:/problems?id="+id);
    }
}
