package org.example.javafxcourse.Model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words;

    public Dictionary() {
        words = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        if (word != null && !word.trim().isEmpty() && meaning != null && !meaning.trim().isEmpty()) {
            words.put(word.toLowerCase(), meaning);
        }
    }

    public String getMeaning(String word) {
        String meaning = words.get(word.toLowerCase());

        if (meaning != null) {
            return meaning;
        } else {
            return "Word not found in dictionary.";
        }
    }
}