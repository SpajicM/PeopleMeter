package hr.zavrsni.peoplemeter.utils;

public class Urls {
    private static String BASE_URL = "http://192.168.1.12:63519/api";

    public static String CHANNEL_URL = BASE_URL + "/channels/";
    public static String REGISTER_URL = BASE_URL + "/authentication/register";
    public static String ACTIVATION_URL = BASE_URL + "/authentication/enterActivationCode";
}
