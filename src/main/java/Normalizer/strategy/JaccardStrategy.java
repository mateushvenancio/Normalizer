package Normalizer.strategy;

import java.util.HashSet;
import java.util.Set;

public class JaccardStrategy extends ScoreCalculateStrategy {
    @Override
    public double calculateScore(String input, String compare) {
        Set<String> set1 = generateNGrams(input, 2);
        Set<String> set2 = generateNGrams(compare, 2);

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }

    private static Set<String> generateNGrams(String string, int n) {
        Set<String> ngrams = new HashSet<>();
        for (int i = 0; i <= string.length() - n; i++) {
            ngrams.add(string.substring(i, i + n));
        }
        return ngrams;
    }
}