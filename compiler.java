import java.io.*; 
import java.io.File;
import java.io.IOException;
public class compiler
{  
	 public static void main(String args[])throws Exception
	 {  
		  //String cmd1 = "g++ 'src/main/resources/nisarg20/1/userprogram.cpp' < 'src/main/resources/nisarg20/1/userinput.txt' 2>'src/main/resources/nisarg20/1/usererror.txt'";
		  //String cmd2 = "g++ 'src/main/resources/nisarg20/1/userprogram.cpp' -o tc";
		  //String cmd3 = "./tc < 'src/main/resources/nisarg20/1/userinput.txt' > 'src/main/resources/nisarg20/1/useroutput.txt'";

		//ProcessBuilder b = new ProcessBuilder("g++", "src/main/resources/nisarg20/1/userprogram.cpp","<","src/main/resources/nisarg20/1/userinput.txt","2>","src/main/resources/nisarg20/1/usererror.txt"); 
		//b.command();

		//String cmd1 = "touch src/main/resources/nisarg20/1/usererror.txt";
		Runtime.getRuntime().exec(cmd1);
        	//Runtime.getRuntime().exec(cmd2);
        	//Runtime.getRuntime().exec(cmd3);
	 }  
}  
