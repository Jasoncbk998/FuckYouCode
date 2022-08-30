import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    /**
     * 栈 先进先出
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素
     */
    Deque<Integer> xStack;
    Deque<Integer> minStack;  // 辅助栈

    // 初始化栈对象
    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    // 压栈
    public void push(int x) {
        xStack.push(x);
        // 每次压入最小的值 ,保证辅助栈里均为每次压入后的最小值
        minStack.push(Math.min(minStack.peek(), x));
    }

    // 删除栈顶元素  出栈
    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    // 获取顶部元素
    public int top() {
        return xStack.peek();
    }

    // 获取栈中最小元素
    public int getMin() {
        return minStack.peek();
    }

}
