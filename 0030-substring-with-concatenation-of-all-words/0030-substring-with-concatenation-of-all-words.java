import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        if (s.length() < totalLen) {
            return result;
        }

        // Build frequency map for all words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Iterate through each possible word offset alignment
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> seenMap = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String subWord = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(subWord)) {
                    seenMap.put(subWord, seenMap.getOrDefault(subWord, 0) + 1);
                    count++;

                    // If we have more instances of subWord than required, shrink from the left
                    while (seenMap.get(subWord) > wordMap.get(subWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenMap.put(leftWord, seenMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If all words are matched, record the starting index
                    if (count == numWords) {
                        result.add(left);
                        // Shift window forward by one word length to check for the next match
                        String leftWord = s.substring(left, left + wordLen);
                        seenMap.put(leftWord, seenMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    // Encountered an invalid word, reset the sliding window
                    seenMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}