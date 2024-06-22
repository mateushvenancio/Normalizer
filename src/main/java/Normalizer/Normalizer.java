package Normalizer;

import Normalizer.factory.ScoreCalculateFactory;
import Normalizer.strategy.LavenshteinStrategy;
import Normalizer.strategy.ScoreCalculateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Normalizer {
    private final ScoreCalculateFactory scoreCalculateFactory = new ScoreCalculateFactory();
    private String method = "Lavenshtein";

    private List<String> titles = new ArrayList<String>(
            List.of(
                    "Architect",
                    "Software engineer",
                    "Quantity surveyor",
                    "Accountant"
            )
    );

    public Normalizer(List<String> titles) {
        this.titles = titles;
    }

    public Normalizer(String method) {
        this.method = method;
    }

    public Normalizer() { }

    public String normalize(String value) {
        String priceze = "";
        double score = 0;

        ScoreCalculateStrategy calculator = scoreCalculateFactory.createStrategy(method);

        for (String item : titles) {
            final double calculatedScore = calculator.calculateScore(value, item);
            System.out.println("Score " + calculatedScore);
            if (calculatedScore > score) {
                score = calculatedScore;
                priceze = item;
            }
        }

        return priceze;
    }
}