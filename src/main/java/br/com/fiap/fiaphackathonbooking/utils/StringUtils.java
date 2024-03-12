package br.com.fiap.fiaphackathonbooking.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtils {
    public static String normalize(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }
}
