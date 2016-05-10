import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestCaseGenerator {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("MyVersion.txt");
		GenerateTestCase(f);
	}

	private static void GenerateTestCase(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		System.out.println("//PLEASE COMPLETE IMPORT STATEMENTS INDIVIDUALLY BEFORE RUNNING TEST CASE");
		System.out.println("import java.io.File;\nimport java.io.FileNotFoundException;\nimport java.util.Scanner;\nimport org.openqa.selenium.WebDriver;\nimport org.openqa.selenium.firefox.FirefoxDriver;");
		System.out.println("public class Login extends Task_w_Methods {");
		System.out.println("public static void main(String[]args) {");
		while(input.hasNextLine()){
			String s = input.nextLine();
			
			if(s.length() > 0){
				//System.out.println(s.substring(0,4));
				if(s.substring(0,1).equals("/")){
					System.out.println(s);
				}
				if(s.equals("Start")){
					System.out.println("WebDriver driver = new FirefoxDriver();");
				}else if(s.equals("End")){
					System.out.println("driver.quit();");
				}else if(s.substring(0,4).equals("goTo")){
					System.out.println("driver.get(\"https://www.iformbuilder.com\");");
				}else if(s.substring(0,5).equals("login")){
					String temp = s.substring(6,s.length()-1);
					String [] parameters = temp.split(",");
					System.out.println("login(" + parameters[0] + "," + parameters[1] + ",driver);");
				}
			}
		}
		System.out.println("}\n}");
	}
}