package org.example;

public class CommandIdentifier {
    private static int levenshteinDistance(String s1, String s2) {
        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }

    public static String recognizeCommand(String input, String[] commands, int maxDistance) {
        String bestMatch = null;
        int bestDistance = Integer.MAX_VALUE;
        for (String cmd : commands) {
            int dist = levenshteinDistance(input.toLowerCase(), cmd.toLowerCase());
            if (dist < bestDistance && dist <= maxDistance) {
                bestDistance = dist;
                bestMatch = cmd;
            }
        }
        return bestMatch;
    }
}
