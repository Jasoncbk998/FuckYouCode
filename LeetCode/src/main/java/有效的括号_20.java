import java.util.HashMap;
import java.util.LinkedList;

public class 有效的括号_20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合
     * <p>
     * 输入：s = "()[]{}"
     * 输出：true
     * <p>
     * 输入：s = "(]"
     * 输出：false
     */
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> maps = new HashMap() {{
            // 将 })] 作为key
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};
        // 栈
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // 如果是})] 则进入判断
            // 否则是({[ 直接入栈
            if (maps.containsKey(c)) {
                // peek() 获取栈顶元素
                if (stack.isEmpty() || stack.peek() != maps.get(c)) {
                    return false;
                }
                // 将栈顶移除(先进后出,栈顶是最接近c的左括号)
                stack.pop();
            } else {
                // c是([{ 直接入栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
