package com.kodilla.collections.adv.exercises.dictionary;

import java.util.*;


public class Dictionary {
    Map<String, List<EnglishWord>> dictionary = new HashMap<>();

    public void addWord(String polishWord, EnglishWord englishWord) {
        List<EnglishWord> englishWords =
                dictionary.getOrDefault(polishWord, new ArrayList<>());
        englishWords.add(englishWord);
        dictionary.put(polishWord, englishWords);
    }


    public List<EnglishWord> findEnglishWords(String polishWord, PartOfSpeech partOfSpeech) {
        List<EnglishWord> result = new ArrayList<>();

        for (Map.Entry<String, List<EnglishWord>> entry : dictionary.entrySet()) {
            String key = entry.getKey();

            if (key.startsWith(polishWord.substring(0, 3))) {
                for (EnglishWord englishWord : entry.getValue()) {
                    if (englishWord.getPartOfSpeech() == partOfSpeech) {
                        result.add(englishWord);
                    }
                }
            }
        }

        return result;
    }

    public int size() {
        int sum = 0;

        for (List<EnglishWord> words : dictionary.values()) {
            sum += words.size();
        }

        return sum;
    }

    public List<EnglishWord> findEnglishWords(String polishWord) {
        return dictionary.getOrDefault(polishWord, Collections.emptyList());
    }
}
