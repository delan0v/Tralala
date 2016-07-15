package com.example.util.version;

/**
 * Created by Błażej on 15.07.2016.
 */
public class SystemVersion {
    private static SystemVersion systemVersion = null;
    private static String version;

    private SystemVersion() {
        version = "0.0.1";
    }

    public static synchronized String getSystemVersion() {
        if (systemVersion == null) {
            systemVersion = new SystemVersion();
        }
        return version;
    }
}
