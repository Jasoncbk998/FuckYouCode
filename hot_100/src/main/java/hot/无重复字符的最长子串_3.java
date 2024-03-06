package hot;

import java.util.HashMap;

public class 无重复字符的最长子串_3 {
    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 核心思路
     * 依次遍历字符串,每次拿到新的字符,就去map中寻找是否出现过
     *  如果在遍历的字符在a位置出现了重复,那么无重复子串就要从a+1位置开始,end - start+1
     *  如果map中不存在key,则说明无重复,继续遍历
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        // 找end结尾最长的无重复子串的长度
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                // 发现在a位置重复,则就要从a+1位置开始从新计数
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            // put每个字符的位置
            map.put(ch, end);
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "abccba";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
