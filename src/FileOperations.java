import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {
    static List<String> lines = new ArrayList<String>();

    public static List<String> ReadFile(String fileName){
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                lines.add(myReader.nextLine());
            }
            myReader.close();

            return lines;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return lines;
    }

    public static void WriteFile(String wrap){
        try{
            File newFile = new File ("Output.txt");
            if (newFile.createNewFile()){
                System.out.println("File created: " + newFile.getName());
            }else {
                System.out.println("File already exists.");
            }

            FileWriter writer = new FileWriter("Output.txt");
            writer.write(wrap);
            writer.close();
            System.out.println("Successfully wrote to the file.");


        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
