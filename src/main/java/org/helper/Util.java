package org.helper;

import java.util.UUID;

public class Util {
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
