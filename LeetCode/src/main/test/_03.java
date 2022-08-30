import jdk.nashorn.internal.runtime.FindProperty;

import java.util.HashMap;

public class _03 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            max = Math.max(max, end - start + 1);
            map.put(c, end);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcaaa";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
