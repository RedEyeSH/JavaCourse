package org.example.javafxcourse.Controller;

import org.example.javafxcourse.Model.Dictionary;

public class DictionaryController {
    private final Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();
    }

    public void addNewWord(String word, String meaning) {
        dictionary.addWord(word, meaning);
    }

    public String searchWord(String word) {
        return dictionary.getMeaning(word);
    }
}