package impl;

import entity.AnagramChecker;

import java.util.Arrays;

public class AnagramCheckerImpl implements AnagramChecker {

    @Override
    public boolean areAnagrams(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return false;
        }

        char[] chars1 = word1.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] chars2 = word2.replaceAll("\\s+", "").toLowerCase().toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }
}