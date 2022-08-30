import javafx.scene.chart.Axis;

import java.awt.peer.CanvasPeer;

public class _395 {
    public static void main(String[] args) {
        String s = "aaabc";
        int k = 3;
        int i = longestSubstring(s, k);
        System.out.println(i);
    }

    public static int longestSubstring(String s, int k) {
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


}
