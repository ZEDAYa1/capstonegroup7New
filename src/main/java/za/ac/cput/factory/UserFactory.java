//package za.ac.cput.factory;
//
//import za.ac.cput.domain.User;
//import za.ac.cput.util.Helper;
//
//public class UserFactory {
//    public static User createUser(String username, String email, String password) {
//        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password)) {
//            return null;
//        }
//
//        String userId = Helper.generateId();
//
//        User user = new User.Builder()
//                .setUserId(userId)
//                .setName(username)
//                .setEmail(email)
//                .setPassword(password)
//                .build();
//        return user;
//    }
//}
