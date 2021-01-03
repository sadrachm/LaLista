package Project1;

import java.io.IOException;

public class RunEmail{
	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("python src/Project1/SendEmail.py");
	}
}