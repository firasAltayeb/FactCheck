package app;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagramSlow(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                // Character not present in sentence 1 or frequency is already 0
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    public static boolean isAnagramFast(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

        return true;
    }


    public static void main(String[] args) {
        final String s = "anagram";
        final String t = "nagaram";

        if (isAnagramFast(s, t)) {
            System.out.println("The sentences are anagrams.");
        } else {
            System.out.println("The sentences are not anagrams.");
        }
    }
}
