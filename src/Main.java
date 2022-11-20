import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String>  lines = FileOperations.ReadFile(args[0]);

        String[] array = lines.toArray(new String[0]);
        Arrays.sort(array);

        String addQuotes = StringUtils.join(array, "\", \"");
        String wrap =  StringUtils.wrap(addQuotes, "\"");
        System.out.println(wrap);

        FileOperations.WriteFile(wrap);
    }
}