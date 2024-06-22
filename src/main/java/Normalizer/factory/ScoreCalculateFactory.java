package Normalizer.factory;

import Normalizer.strategy.JaccardStrategy;
import Normalizer.strategy.LavenshteinStrategy;
import Normalizer.strategy.ScoreCalculateStrategy;

public class ScoreCalculateFactory {
    public ScoreCalculateStrategy createStrategy(String type) {
        if (type == null) return null;

        if (type.equalsIgnoreCase("JACCARD")) {
            return new JaccardStrategy();
        }

        if (type.equalsIgnoreCase("LAVENSHTEIN")) {
            return new LavenshteinStrategy();
        }

        return null;
    }
}
