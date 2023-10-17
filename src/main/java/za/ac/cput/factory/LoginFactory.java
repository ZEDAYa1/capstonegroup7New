package za.ac.cput.factory;

import za.ac.cput.domain.Login;
import za.ac.cput.util.Helper;

public class LoginFactory {
    public static Login createLogin(String username, String password) {
        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password)) {
            return null;
        }

        String loginId = Helper.generateId();

        Login login = new Login.Builder()
                .setUsername(username)
                .setPassword(password)
                .build();
        return login;
    }
}

