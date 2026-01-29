package entity;

import java.util.Objects;

public class WordPair {
    private final String word1;
    private final String word2;

    public WordPair(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    public String getWord1() {
        return word1;
    }

    public String getWord2() {
        return word2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WordPair{");
        sb.append("word1='").append(word1).append('\'');
        sb.append(", word2='").append(word2).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordPair wordPair = (WordPair) o;
        return Objects.equals(word1, wordPair.word1) && Objects.equals(word2, wordPair.word2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word1, word2);
    }
}