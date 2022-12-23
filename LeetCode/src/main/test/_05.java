import sun.tools.jconsole.PlotterPanel;

public class _05 {
    // 最长回文子串
    public static String longestPalindrome(String s) {
        int left = 0, right = -1;
        int pl = 0, pr = 0;
        int length = s.length() - 1;
        while (left < right) {
            while (right + 1 <= length && s.charAt(right + 1) == s.charAt(left)) {
                right++;
            }
            while (left - 1 >= 0 && right + 1 <= length && s.charAt(right + 1) == s.charAt(left - 1)) {
                right++;
                left--;
            }

            if (right - left > pr - pl) {
                left = (right + left) / 2 + 1;
                right = left;
            }
        }
        return s.substring(pl, pr + 1);
    }

    public static void main(String[] args) {
        String s = "abccbaba";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
        int length = s.length();
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(6));
    }
}
