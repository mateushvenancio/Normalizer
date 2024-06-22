package Normalizer.factory;

import Normalizer.strategy.JaccardStrategy;
import Normalizer.strategy.LavenshteinStrategy;
import Normalizer.strategy.ScoreCalculateStrategy;

public class ScoreCalculateFactory {
    public ScoreCalculateStrategy createStrategy(String method) {
        if (method == null) return null;

        if (method.equalsIgnoreCase("JACCARD")) {
            return new JaccardStrategy();
        }

        if (method.equalsIgnoreCase("LAVENSHTEIN")) {
            return new LavenshteinStrategy();
        }

        return null;
    }
}
