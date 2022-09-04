package _02_递归;

public class fib {
    // 1,1,2,3,5,8,..,...
    public int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
