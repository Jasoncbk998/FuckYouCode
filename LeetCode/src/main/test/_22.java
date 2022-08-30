import java.util.ArrayList;
import java.util.List;

public class _22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return null;
    }

    public void backtrack(ArrayList<String> ans, StringBuilder cur, int open, int close, int max) {

    }


}
