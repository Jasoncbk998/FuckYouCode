public class 最长回文子串_05 {
    /***
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba"
     * 基本思路
     * 确定寻找边界 left,right   每次都是移动left 然后right=left 从left开始扩散寻找
     * 确定 回文边界  pl pr
     * 右边界< length
     * 左边界>=0
     * 因为 索引是从0开始
     * 然后开始寻找
     */
    public static String longestPalindrome(String s) {
        //查找边界
        int left = 0, right = -1;
        // 回文边界
        int pl = 0, pr = 0;
        int length = s.length() - 1;
        while (left < length) {
            // 重复
            while (right + 1 <= length && s.charAt(left) == s.charAt(right + 1)) {
                right++;
            }
            while (left - 1 >= 0 && right + 1 <= length && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }
            if (right - left > pr - pl) {
                pl = left;
                pr = right;
            }
            left = (right + left) / 2 + 1;
            right = left;
        }
        return s.substring(pl, pr + 1);
    }


    public static void main(String[] args) {
        String s = "aaabccbadddd";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
