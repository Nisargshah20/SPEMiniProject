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
import java.util.Arrays;

@RestController
public class ProblemController {

    Gson gson = new Gson();

    @RequestMapping(value = {"/problems"})
    public ModelAndView problem(@RequestParam(value = "id") String id, HttpSession session, RedirectAttributes redirectAttributes) throws IOException {
        if(session.getAttribute("username")==null){
            ModelAndView model = new ModelAndView("redirect:index");
            redirectAttributes.addFlashAttribute("result","Can't access the page you requested need to Login first");
            return model;
        }
        ModelAndView model = new ModelAndView("problem");
        session.setAttribute("id",id);
        model.addObject("pid",id);
        System.out.print(getClass().getClassLoader().getResource("static/Problems/1/input.txt").getPath());
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
        File file1 = new File(path + '/' + "useroutput.txt");
        file1.createNewFile();
        File file2 = new File(path + '/' + "usererror.txt");
        file2.createNewFile();
        String ui_path = username + "/" + id + "/userinput.txt";
        String ue_path = username + "/" + id + "/usererror.txt";
        String uo_path = username + "/" + id + "/useroutput.txt";
        String ucode_path = username + "/" + id + "/userprogram.cpp";
        String i_path = "static/Problems/" + id + "/input.txt";
        String o_path = "static/Problems/" + id + "/output.txt";
        i_path = getClass().getClassLoader().getResource(i_path).getPath();
        o_path = getClass().getClassLoader().getResource(o_path).getPath();
        String test1 =  getClass().getClassLoader().getResource("test.sh").getPath();

        uo_path = file1.getPath();
        ue_path = file2.getPath();
        ui_path = input.getPath();
        ucode_path = code.getPath();
        System.out.print(test1 + ue_path + ui_path +uo_path + ucode_path);

        String[] cmd = {"sh", test1, ucode_path, ui_path, ue_path, uo_path};
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
        File file1 = new File(path + '/' + "useroutput.txt");
        file1.createNewFile();
        File file2 = new File(path + '/' + "usererror.txt");
        file2.createNewFile();
        String ui_path = username + "/" + id + "/userinput.txt";
        String ue_path = username + "/" + id + "/usererror.txt";
        String uo_path = username + "/" + id + "/useroutput.txt";
        String ucode_path = username + "/" + id + "/userprogram.cpp";
        String i_path = "static/Problems/" + id + "/input.txt";
        String o_path = "static/Problems/" + id + "/output.txt";
        i_path = getClass().getClassLoader().getResource(i_path).getPath();
        o_path = getClass().getClassLoader().getResource(o_path).getPath();
        String test1 =  getClass().getClassLoader().getResource("test.sh").getPath();

        uo_path = file1.getPath();
        ue_path = file2.getPath();
        ui_path = input.getPath();
        ucode_path = code.getPath();
        System.out.print(test1 + ue_path + ui_path +uo_path + ucode_path);

        String[] cmd = {"sh", test1, ucode_path, i_path, ue_path, uo_path};
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
