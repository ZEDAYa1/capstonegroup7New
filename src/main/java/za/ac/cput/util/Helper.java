package za.ac.cput.util;

import java.time.LocalDate;
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String s){
        if(s == null || s.isEmpty() ||s.equalsIgnoreCase("null")){
            return true;
        }
        return false;
    }
    public static boolean isEmptyOrNull(String s) {

        return (s == null || s.isEmpty() || s.equalsIgnoreCase("null"));

    }

    public static boolean isDateNull(LocalDate date){
        if(date == null ){
            return true;
        }
        return false;
    }

    public static String generateId() {

        return UUID.randomUUID().toString();
    }

    public static boolean emailMatches(String email, String s) {

        return false;
    }

    public static void checkStringParam(String paramName, String paramValue) {
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }
}

