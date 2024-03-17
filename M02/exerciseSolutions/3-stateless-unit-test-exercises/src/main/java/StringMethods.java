import java.util.Locale;

public class StringMethods {
    public boolean startsWithDayOfWeek(String value){
        if(value.startsWith("Mon")||value.startsWith("Tues")||value.startsWith("Wed")||
                value.startsWith("Thurs") || value.startsWith("Fri")||value.startsWith("Sat")
                ||value.startsWith("Sun")){
            return true;
        }
        return false;
    }

    public boolean containsDayOfWeek(String value){
        String lowerCaseValue = value.toLowerCase();
        if(lowerCaseValue.contains("mon") || lowerCaseValue.contains("tues") || lowerCaseValue.contains("wed")
                || lowerCaseValue.contains("thur") || lowerCaseValue.contains("fri") || lowerCaseValue.contains("sat")
                || lowerCaseValue.contains("sun")){
            return true;
        }
        return false;
    }

    public String removeVowelFromBetweenX(String value){
        String noMoreVowels = value.replaceAll("x[aeiouAEIOU]x","xx");
        return noMoreVowels;
    }
}
