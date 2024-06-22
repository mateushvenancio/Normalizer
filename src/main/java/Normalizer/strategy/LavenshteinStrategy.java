package Normalizer.strategy;

public class LavenshteinStrategy extends ScoreCalculateStrategy {
    @Override
    public double calculateScore(String input, String compare) {
        int inputLength = input.length();
        int compareLength = compare.length();

        int[][] distanceMatrix = new int[inputLength + 1][compareLength + 1];

        for (int i = 0; i <= inputLength; i++) {
            distanceMatrix[i][0] = i;
        }
        for (int j = 0; j <= compareLength; j++) {
            distanceMatrix[0][j] = j;
        }

        for (int i = 1; i <= inputLength; i++) {
            for (int j = 1; j <= compareLength; j++) {
                int cost = (input.charAt(i - 1) == compare.charAt(j - 1)) ? 0 : 1;
                distanceMatrix[i][j] = Math.min(Math.min(distanceMatrix[i - 1][j] + 1, distanceMatrix[i][j - 1] + 1), distanceMatrix[i - 1][j - 1] + cost);
            }
        }

        int distance = distanceMatrix[inputLength][compareLength];

        return 1.0 - ((double) distance / Math.max(inputLength, compareLength));
    }
}