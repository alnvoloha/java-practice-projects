package entity;

@FunctionalInterface
public interface AnagramChecker {
    boolean areAnagrams(String word1, String word2);
}