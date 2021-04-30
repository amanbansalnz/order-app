package org.demo.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class HelperUtil {

    public static String generateHash(String value) {

        String valueToHash = new StringBuilder("demo")
                .append(value)
                .toString();

        String identifier = Hashing.sha256()
                .hashString(valueToHash, Charsets.UTF_16LE)
                .toString();

        return identifier;
    }
}
