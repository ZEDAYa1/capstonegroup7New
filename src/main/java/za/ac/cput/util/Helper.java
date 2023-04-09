/*
 * Helper.java
 * This is the Helper class
 * Author: Tshegofatso Molefe {219001235}
 * Author: Sibusiso Dwayi(220226466)
* Date: 6 April 2023
*/
package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;
// 220097429
import java.util.Date;
=======
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// master
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String s){
        if(s == null || s.isEmpty() ||s.equalsIgnoreCase("null")){
            return true;
        }
        return false;
    }

    public static boolean isDateNull(Date date){
        if(date == null ){
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
    public static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
