import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<String>();
        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                lines.add(myReader.nextLine());
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] array = lines.toArray(new String[0]);
        Arrays.sort(array);

        String addQuotes = StringUtils.join(array, "\", \"");
        String wrap =  StringUtils.wrap(addQuotes, "\"");
        System.out.println(wrap);

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