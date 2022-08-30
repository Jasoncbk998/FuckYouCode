import java.util.ArrayList;
import java.util.List;

/**
 * 基本思路
 * 每个数字键位进行组合 比如输入23 就是2号键和3号键进行组合
 * 取出2号键的值依次与3号键的值进行遍历组合
 */
public class 电话号码的字母组合_17 {
    private String[] keys = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private StringBuilder sb = new StringBuilder();
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String digits, int index) {
        if (sb.length() == digits.length()) {
            // 将StringBuilder进行 toString 返回  Char->String
            res.add(sb.toString());
            return;
        }
        String val = keys[digits.charAt(index) - '2'];
        // 不断组合,先append 然后再delete
        for (char ch : val.toCharArray()) {
            sb.append(ch);
            backtrack(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        电话号码的字母组合_17 temp = new 电话号码的字母组合_17();
        List<String> strings = temp.letterCombinations("23");
        System.out.println(strings.toString());
    }
}
