import java.security.PrivateKey;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 用栈实现队列_232 {

    /**
     * 输入：
     * ["MyQueue", "push", "push", "peek", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * 输出：
     * [null, null, null, 1, 1, false]
     * 将一个栈当作输入栈，用于压入 texttt{push}push 传入的数据；
     * 另一个栈当作输出栈，用于 texttt{pop}pop 和 texttt{peek}peek 操作。
     * 每次 texttt{pop}pop 或 texttt{peek}peek 时
     * 若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈
     * 这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
     */
    class MyQueue {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> revstack = new ArrayDeque<>();
        public MyQueue() {

        }

        public void push(int x) {
            while(!revstack.isEmpty()){
                stack.push(revstack.pop());
            }
            stack.push(x);
        }

        public int pop() {
            while(!stack.isEmpty()){
                revstack.push( stack.pop() );
            }
            return revstack.pop();
        }

        public int peek() {
            while(!stack.isEmpty()){
                revstack.push( stack.pop() );
            }
            return revstack.peek();
        }

        public boolean empty() {
            if(stack.isEmpty() && revstack.isEmpty()) return true;
            return false;
        }

    }


}
