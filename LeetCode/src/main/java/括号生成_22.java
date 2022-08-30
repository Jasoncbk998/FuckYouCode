import java.util.ArrayList;
import java.util.List;

public class 括号生成_22 {
    List<String> res = new ArrayList<String>();

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     */
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        getParenthesis("", n, n);
        return res;
    }

    private void getParenthesis(String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left == right) {
            getParenthesis(str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right);
            }
            getParenthesis(str + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        括号生成_22 temp = new 括号生成_22();
        List<String> strings = temp.generateParenthesis(3);
        System.out.println(strings.toString());
    }


}