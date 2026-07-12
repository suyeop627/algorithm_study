import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        boolean[] hidden = new boolean[message.length()];
        for (int[] r : spoiler_ranges) {
            for (int i = r[0]; i <= r[1]; i++) {
                hidden[i] = true;
            }
        }

        Set<String> plain = new HashSet<>();
        List<String> spoilerWords = new ArrayList<>();
        int index = 0;
        for (String word : message.split(" ")) {
            boolean spoiler = false;
            for (int wordIndex = 0; wordIndex < word.length(); wordIndex++)
                if (hidden[index + wordIndex]) {
                    spoiler = true;
                    break;
                }

            index += word.length() + 1;
            if (spoiler) {
                spoilerWords.add(word);
            } else {
                plain.add(word);
            }
        }

        Set<String> shown = new HashSet<>();
        int count = 0;
        for (String spoilerWord : spoilerWords) {
            if (!plain.contains(spoilerWord) && shown.add(spoilerWord)) {
                count++;
            }
        }
        return count;
    }
}