public class 至少有K个重复字符的最长子串_395 {
    /**
     * 输入：s = "aaabb", k = 3
     * 输出：3
     * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，
     * 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
     */
    public static  int longestSubstring(String s, int k) {
        return dfs(s, k);
    }

    private static int dfs(String s, int k) {
        int[] charCount = new int[26];
        // 添加
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        // 小于k的字符
        String split = "";
        for (int i = 0; i < charCount.length; i++) {
            int count = charCount[i];
            if (count > 0 && count < k) {
                split = String.valueOf((char) (i + 'a'));
                break;
            }
        }
        if (split.equals("")) {
            return s.length();
        }
        int max = 0;
        String[] split1 = s.split(split);
        for (  String s1 : split1) {
            int dfs = dfs(s1, k); // 继续子集搜索
            max = Math.max(dfs, max);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aaabbc";
        int k = 3;
        int dfs = dfs(s, k);
        System.out.println(dfs);


    }
}