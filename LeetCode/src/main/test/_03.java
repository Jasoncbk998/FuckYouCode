import jdk.nashorn.internal.runtime.FindProperty;

import java.util.HashMap;

public class _03 {
    public static int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        // 找end结尾最长的无重复子串的长度
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            // put每个字符的位置
            map.put(ch, end);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        int[] prevIdex = new int[128];
        for (int i = 0; i < prevIdex.length; i++) {
            prevIdex[i] = -1;
        }
        prevIdex[chars[0]] = 0;
        int li = 0;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            int pi = prevIdex[chars[i]];
            if (li <= pi) {
                li = pi + 1;
            }
            prevIdex[chars[i]] = i;
            max = Math.max(max, i - li + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcaaa";
        System.out.println(lengthOfLongestSubstring1(s));
    }

}
