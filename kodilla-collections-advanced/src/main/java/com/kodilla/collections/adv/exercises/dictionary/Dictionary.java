package com.kodilla.collections.adv.exercises.dictionary;

import java.util.*;


public class Dictionary {
    private final Map<String, List<EnglishWord>> dictionary = new HashMap<>();

    public void addWord(String polishWord, EnglishWord englishWord) {
        Objects.requireNonNull(polishWord, "polishWord cannot be null");
        Objects.requireNonNull(englishWord, "englishWord cannot be null");

        List<EnglishWord> englishWords =
                dictionary.getOrDefault(polishWord, new ArrayList<>());
        englishWords.add(englishWord);
        dictionary.put(polishWord, englishWords);
    }


    public List<EnglishWord> findEnglishWords(String polishWord, PartOfSpeech partOfSpeech) {
        Objects.requireNonNull(polishWord, "polishWord cannot be null");
        Objects.requireNonNull(partOfSpeech, "partOfSpeech cannot be null");

        List<EnglishWord> result = new ArrayList<>();
        List<EnglishWord> englishWords = dictionary.getOrDefault(polishWord, Collections.emptyList());
        for (EnglishWord englishWord : englishWords) {
            if (englishWord.getPartOfSpeech() == partOfSpeech) {
                result.add(englishWord);
            }
        }

        return Collections.unmodifiableList(result);
    }

    public int size() {
        int sum = 0;

        for (List<EnglishWord> words : dictionary.values()) {
            sum += words.size();
        }

        return sum;
    }

    public List<EnglishWord> findEnglishWords(String polishWord) {
        Objects.requireNonNull(polishWord, "polishWord cannot be null");
        return Collections.unmodifiableList(new ArrayList<>(
                dictionary.getOrDefault(polishWord, Collections.emptyList())
        ));
    }
}
