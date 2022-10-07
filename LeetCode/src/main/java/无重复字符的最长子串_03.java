import java.util.HashMap;

public class 无重复字符的最长子串_03 {
    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 核心思路
     * 一个字符串无重复字符的子串
     * 最核心的思想就是寻找每个字符结尾的子串的最长不重复子串
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;

        // 用来保存每一个字符上一次出现的位置
        int[] prevIdxes = new int[128];
//        给所有字符默认的上一次位置都是-1
        for (int i = 0; i < prevIdxes.length; i++) {
            prevIdxes[i] = -1;
        }
        // 第一个元素上一次的位置是0
        prevIdxes[chars[0]] = 0;
        // 以i - 1位置字符结尾的最长不重复字符串的开始索引（最左索引）
        int li = 0;
        int max = 1; // 我们认为一个字符串无重复子串的最坏情况就是1 就是一堆字符都是相同字符,那么无重复子串就是1
        for (int i = 1; i < chars.length; i++) {
            // i位置字符上一次出现的位置
            int pi = prevIdxes[chars[i]];
            if (li <= pi) {
                li = pi + 1;
            }
            // 存储这个字符出现的位置
            prevIdxes[chars[i]] = i;
            // 求出最长不重复子串的长度
            max = Math.max(max, i - li + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        String s = "abbbaa";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
