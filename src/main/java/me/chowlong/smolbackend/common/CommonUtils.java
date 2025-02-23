package me.chowlong.smolbackend.common;

import java.util.UUID;

public class CommonUtils {
    public static String generateCustomLink() {
        String generatedString = UUID.randomUUID().toString().replaceAll("[^a-z]", "").substring(0, 6);
        return new StringBuilder(generatedString)
                .insert(2, "-")
                .insert(5, "-")
                .toString();
    }
}
