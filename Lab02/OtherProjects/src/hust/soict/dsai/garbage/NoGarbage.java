package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) throws IOException {
		String filename = "C:\\Users\\HUNG\\Downloads\\IT\\OOP-Lab02\\Lab02\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\test.txt"; // test.exe is the name or path to an executable file 
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		

		/*String outputString = ""; 
		for (byte b : inputBytes) { 
			outputString += (char)b;
		}*/
		
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b : inputBytes) {
			outputStringBuilder.append((char) b);
		}
		
		endTime = System.currentTimeMillis(); 
		System.out.println(endTime - startTime);
	}
}

