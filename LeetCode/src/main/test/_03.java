import com.sun.tools.javadoc.Start;
import jdk.nashorn.internal.runtime.FindProperty;

import java.util.HashMap;

public class _03 {
    public static int lengthOfLongestSubstring2(String s) {
        /**
         *      * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
         *      * 核心思路
         *      * 依次遍历字符串,每次拿到新的字符,就去map中寻找是否出现过
         *      *  如果在遍历的字符在a位置出现了重复,那么无重复子串就要从a+1位置开始,end - start+1
         *      *  如果map中不存在key,则说明无重复,继续遍历
         */
        HashMap<Character, Integer> maps = new HashMap<>();
int start=0;
int max=0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (maps.containsKey(ch)){
                start=Math.max(start,maps.get(ch)+1);
            }
            max=Math.max(max,end-start+1);
            maps.put(ch,end);
        }
return max;

    }


    public static int lengthOfLongestSubstring1(String s) {
//        滑动窗口
        HashMap<Character, Integer> maps = new HashMap<>();
        int max = 0;
        int start = 0; // 窗口开始位置
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            // 依次取出字符,放进map进行比对
            // 存在key,就说明改字符重复,那么就说明该子串,要进行截断从新寻找最大长度,所以更新start
            if (maps.containsKey(ch)) {
                // 替换子串开始位置
                start = Math.max(maps.get(ch) + 1, start);
            }
            // 不管是否start是否有更新,都要对每次循环的字符进行位置更新
            maps.put(ch, end);
            // 每循环一次,都要更新最大长度
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aabcaaa";
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
