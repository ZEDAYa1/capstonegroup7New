/*
 * Helper.java
 * This is the Helper class
 * Author: Tshegofatso Molefe {219001235}
 * Date: 6 April 2023
 * */
package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String s){
        if(s == null || s.isEmpty() ||s.equalsIgnoreCase("null")){
            return true;
        }
        return false;
    }

    public static String generateId(){
        return UUID.randomUUID().toString();
    }

    public static boolean isValidEmail(String email){
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }
}
