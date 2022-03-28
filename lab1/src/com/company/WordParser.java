package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {
    public static ArrayList<String> getWords(String string) {
        ArrayList<String> words = new ArrayList<>();
        Pattern pattern =
                Pattern.compile(Constants.REGEX_PATTERN, Pattern.UNICODE_CHARACTER_CLASS
                        | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find())
            words.add(matcher.group());
        return words;
    }
}