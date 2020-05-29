package com.spe.controller;

import com.google.gson.Gson;
import com.spe.model.ReturnOutput;
import com.spe.model.Test;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

@RestController
public class ProblemController {

    Gson gson = new Gson();

    @RequestMapping(value = {"/problems"})
    public ModelAndView problem(@RequestParam(value = "id") String id, HttpSession session, RedirectAttributes redirectAttributes){
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        ModelAndView model = new ModelAndView("problem");
        session.setAttribute("id",id);
        model.addObject("pid",id);
        String current_dir_path = Paths.get("").toAbsolutePath().toString();
        System.out.print(current_dir_path);
        return model;
    }



    @RequestMapping(value = "/test",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String OnTest(@RequestBody Test test) throws IOException, InterruptedException {
        String username = test.getUsername();
        String id = test.getPid();
        System.out.println(username);
        String path = username;
        File file = new File(path);
        if (!file.exists())
            file.mkdir();
        path = username + '/' + id;
        file = new File(path);
        if (!file.exists())
            file.mkdir();
        File code = new File(path + '/' + "userprogram.cpp");
        FileWriter writer = new FileWriter(code);
        writer.write(test.getProgram());
        writer.close();
        File input = new File(path + '/' + "userinput.txt");
        writer = new FileWriter(input);
        writer.write(test.getInput());
        writer.close();

        String ui_path = username + "/" + id + "/userinput.txt";
        String ue_path = username + "/" + id + "/usererror.txt";
        String uo_path = username + "/" + id + "/useroutput.txt";
        String ucode_path = username + "/" + id + "/userprogram.cpp";
        String i_path = "Problems/" + id + "/input";
        String o_path = "Problems/" + id + "/output";

        String[] cmd = {"sh", "test.sh", ucode_path, ui_path, ue_path, uo_path};
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
        File errorfile = new File(ue_path);
        ReturnOutput returnOutput = new ReturnOutput();
        if (errorfile.length() == 0) {
            InputStream is = new FileInputStream(uo_path);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
            String fileAsString = sb.toString();
            returnOutput.setStatus("success");
            returnOutput.setOutput(fileAsString);
        }else{
            InputStream is = new FileInputStream(ue_path);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while(line != null){
                sb.append(line).append("\n");
                line = buf.readLine();
            }

            String fileAsString = sb.toString();
            returnOutput.setStatus("failed");
            returnOutput.setOutput(fileAsString);
        }
        return gson.toJson(returnOutput);
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String OnSubmit(@RequestBody Test test) throws IOException, InterruptedException {
        String username = test.getUsername();
        String id = test.getPid();
        System.out.println(username);
        String path = "./src/main/resources/" + username;
        File file = new File(path);
        if (!file.exists())
            file.mkdir();
        path = "./src/main/resources/" + username + '/' + id;
        file = new File(path);
        if (!file.exists())
            file.mkdir();
        File code = new File(path + '/' + "userprogram.cpp");
        FileWriter writer = new FileWriter(code);
        writer.write(test.getProgram());
        writer.close();
        File input = new File(path + '/' + "userinput.txt");
        writer = new FileWriter(input);
        writer.write(test.getInput());
        writer.close();

        String ui_path = "src/main/resources/" + username + "/" + id + "/userinput.txt";
        String ue_path = "src/main/resources/" + username + "/" + id + "/usererror.txt";
        String uo_path = "src/main/resources/" + username + "/" + id + "/useroutput.txt";
        String ucode_path = "src/main/resources/" + username + "/" + id + "/userprogram.cpp";
        String i_path = "src/main/resources/static/Problems/" + id + "/input.txt";
        String o_path = "src/main/resources/static/Problems/" + id + "/output.txt";

        String[] cmd = {"sh", "test.sh", ucode_path, i_path, ue_path, uo_path};
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
        File errorfile = new File(ue_path);
        ReturnOutput returnOutput = new ReturnOutput();
        if (errorfile.length() == 0) {
            File useroutputfile = new File(uo_path);
            File outputfile = new File(o_path);

            byte[] first = Files.readAllBytes(useroutputfile.toPath());
            byte[] second = Files.readAllBytes(outputfile.toPath());

            boolean equal = Arrays.equals(first, second);
            if (equal)
            {
                returnOutput.setStatus("success");
            }
            else
            {
                returnOutput.setStatus("wrongans");
            }
        }else{
            InputStream is = new FileInputStream(ue_path);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while(line != null){
                sb.append(line).append("\n");
                line = buf.readLine();
            }

            String fileAsString = sb.toString();
            returnOutput.setStatus("failed");
            returnOutput.setOutput(fileAsString);
        }
        return gson.toJson(returnOutput);
    }
}
