package fileio;

import java.io.*;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) {
        System.out.println("Contents of file:");
        writeToFile("./data/lordoftherings.txt");
        String fileContents = readFromFile("./data/lordoftherings.txt");
        System.out.println(fileContents);
    }

    private static void writeToFile(String fileName){
        try(FileWriter fileWriter = new FileWriter(fileName,true)){
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.println("\nGimli");
            writer.println("Sam");
        }catch(IOException ex){

        }
    }

    private static String readFromFile(String fileName){
        String fileContents = "";
        try(FileReader fileReader = new FileReader(fileName)){
            BufferedReader reader = new BufferedReader(fileReader);

            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                if(!line.isBlank()){
                    fileContents += line + "\n";
                }
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            ex.getStackTrace();
        }
        return fileContents;
    }
}
