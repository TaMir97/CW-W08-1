package org.example.validation;

public class Valid {
    public static boolean validEmail(String email){
        String regex = "^(?i)[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$";
        return email.matches(regex);

    }

    public static boolean isWebsite(String website) {
        String regex = "^(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})([/\\w .-]*)*/?$";
        return website.matches(regex);
    }
    public static boolean validPassword(String password){
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$");

    }
}
