package HW_100124;

import java.util.*;

public class WordsGrouper {
    public static void main(String[] args) {
        String[] words = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf", "tact"};
        groupWords(words);
    }
    public static void groupWords(String[] words) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String word : words) {
            Set<Character> uniqueChars = new TreeSet<>();
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }
            String key = String.valueOf(uniqueChars);
            List<String> group = groups.getOrDefault(key, new ArrayList<>());
            group.add(word);
            groups.put(key, group);
        }

        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
