package hr.zavrsni.peoplemeter.utils;

import hr.zavrsni.peoplemeter.models.User;

public class Auth {
    private static User user;

    public static boolean isLoggedIn() {
        return user != null && !user.getUsername().isEmpty() && !user.getPassword().isEmpty();
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Auth.user = user;
    }
}

