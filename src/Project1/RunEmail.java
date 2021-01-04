package Project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunEmail{
	public static void main(String[] args) throws IOException {
		String s = null;
		Process p = Runtime.getRuntime().exec("python src/Project1/SendEmail.py turkeysandwich0@gmail.com asd turkeysandwich0@gmail.com");
		try{
			BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));  
			while ((s = output.readLine()) != null) {
                System.out.println(s);
                if (s.equals("Fail")) {System.out.println("sadkjh");}
            }
		}
		catch(Exception e){
			System.out.println("Error");
		}
	}
}