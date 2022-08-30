public class 回文子串_647 {
    /**
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串
     * <p>
     * 输入：s = "aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     */
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for (int center = 0; center < n; center++) {
            // 这里的 center+1 没弄明白
            ans += expand(s, center, center) + expand(s, center, center + 1);
        }
        return ans;
    }

    private int expand(String s, int left, int right) {
        int ans = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ans++;
            left--;
            right++;
            System.out.println(s.substring(left + 1, right));
        }
        return ans;
    }

    public static void main(String[] args) {
        回文子串_647 temp = new 回文子串_647();
        int aaa = temp.countSubstrings("aaa");
        System.out.println(aaa);
    }
}
