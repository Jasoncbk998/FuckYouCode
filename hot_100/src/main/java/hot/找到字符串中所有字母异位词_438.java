package hot;

import sun.java2d.pipe.SpanIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class 找到字符串中所有字母异位词_438 {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        int target_length = p.length();
        char[] p_chars = p.toCharArray();
        Arrays.sort(p_chars);
        for (int start = 0; start < s.length(); start++) {
            int end = start + target_length;
            if (end > s.length()) {
                continue;
            }
            String str = s.substring(start, end);
            char[] array = str.toCharArray();
            Arrays.sort(array);
            if (Arrays.equals(array, p_chars)) {
                result.add(start);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        找到字符串中所有字母异位词_438 test = new 找到字符串中所有字母异位词_438();
        String strs = "cbaebabacd", p = "abc";
        List<Integer> anagrams = test.findAnagrams(strs, p);
        System.out.println(anagrams);
    }


}
