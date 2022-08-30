import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串_03 {
    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        // 每次循环位置为终点的字符, 这些字符为重点,每次都进行比较找到max
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            // 存在重复字符
            if (map.containsKey(ch)) {
                // 在找到重复字符的位置后进行+1
                // 则这个位置就是无重复字符子串的开始位置
                start = Math.max(map.get(ch) + 1, start);
            }
            // 更新max
            max = Math.max(max, end - start + 1);
            // 本次字符出现的位置
            map.put(ch, end);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcdaba";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
