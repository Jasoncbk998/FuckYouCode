package _02_递归;

import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;
import tools.Times;

import javax.lang.model.type.ErrorType;

public class fib {
    public static void main(String[] args) {
        fib fib = new fib();
        Times.test("fib1", () -> {
            System.out.println(fib.fib1(50));
        });

        Times.test("fib0", () -> {
            System.out.println(fib.fib0(50));
        });
    }

    // 1,1,2,3,5,8,..,...
    public int fib0(int n) {
        if (n <= 2) return 1;
        return fib0(n - 1) + fib0(n - 2);
    }


    public int fib1(int n) {
        if (n <= 2) return 1;
        // 利用数组存放计算过的递归,从而进行优化,避免重复计算
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fib1(n, array);
    }

    public int fib1(int n, int[] array) {
        if (array[n] == 0) {
            array[n] = fib1(n - 1, array) + fib1(n - 2, array);
        }
        return array[n];
    }


    // 去除递归调用
    public int fib2(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[2] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    // 数组退化为滚动数组
    public int fib3(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[2] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            // 模运算效率偏低 还是不够牛逼   换成位运算
            array[i % 2] = array[(i - 1) % 2] + array[(i - 2) % 2];
        }
        return array[n];
    }

    // 位运算
    public int fib4(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[2] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            //  位运算
            array[i & 2] = array[(i - 1) & 2] + array[(i - 2) & 2];
        }
        return array[n & 1];
    }

    //滚动数组退化为 两个int
    public int fib5(int n) {
        if (n <= 2) return 1;
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }


}
