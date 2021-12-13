import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String starter = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));

//        String result = checkForMilk(starter);
//        result = result + checkForBread(starter);
//        result = result + checkForCookies(starter);
//        result = result + checkForApples(starter);


//        return result;
        return starter;
    }

//    private String checkForApples(String starter) {
//        return checkFor(starter, "Apples");
//    }
//
//    private String checkForCookies(String starter) {
//        return checkFor(starter, "Cookies");
//    }
//
//    private String checkForBread(String starter) {
//        return checkFor(starter, "Bread");
//    }
//
//    private String checkForMilk(String starter) {
//        return checkFor(starter, "Milk");
//    }

    private String checkFor(String starter, String key){
        String text = starter;
        String patternString = "##(.*)##";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        int occurances = 0;
        while(matcher.find()){
            occurances++;
        }
        String result = "name:    " + patternString + "      seen:  " + occurances + " times\n"
                + "=============      ==============\n";

        return result;
    }


    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}
