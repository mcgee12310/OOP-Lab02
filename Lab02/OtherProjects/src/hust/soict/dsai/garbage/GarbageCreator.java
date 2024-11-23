package hust.soict.dsai.garbage;

import java.util.*; 
import java.io.FileWriter;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) throws IOException  {
        ArrayList<String> garbageList = new ArrayList<>();
        
        FileWriter writer = new FileWriter("C:\\\\Users\\\\HUNG\\\\Downloads\\\\IT\\\\OOP-Lab02\\\\Lab02\\\\OtherProjects\\\\src\\\\hust\\\\soict\\\\dsai\\\\garbage\\\\test.txt");
        
        try {
            while (true) {
                // Create a large string of c
                String garbage = new String(new char[1000000]).replace('\0', 'c');
                garbageList.add(garbage);
                
                // Print the size of garbage  
                if (garbageList.size() % 100 == 0) {
                    System.out.println("Garbage created: " + garbageList.size() + " objects");
                    writer.write(garbage + "Files in Java might be tricky, but it is fun enough!\n");
                }
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Error");
        }
        
        writer.close();
    }
}
