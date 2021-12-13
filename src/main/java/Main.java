import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String starter = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));

        String result = checkForMilk(starter);
//        result = result + checkForBread(starter);
//        result = result + checkForCookies(starter);
//        result = result + checkForApples(starter);


        return result;
    }

    private String checkForMilk(String starter) {
        String text = starter;
        String patternString = "Milk";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        int occurances = 0;
        while(matcher.find()){
            occurances++;
        }
        String result = "name:    Milk      seen:  " + occurances + " times\n"
                        + "=============      ==============\n";


        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}
