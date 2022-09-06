package _02_递归;

// 汉诺塔
public class hanoi {
    // 将n个碟子,从p1 挪到p3
    void hanoi(int n, String p1, String p2, String p3) {
        if (n == 1) {
            move(n, p1, p3);
            return;
        }
        hanoi(n - 1, p1, p3, p2);
        move(n, p1, p3);
        hanoi(n - 1, p2, p1, p3);
    }

    void move(int no, String from, String to) {
        System.out.println("将" + no + "号盘子" + from + "移动到" + to);
    }

    public static void main(String[] args) {
        hanoi hanoi = new hanoi();
        hanoi.hanoi(2,"p1","p2","p3");
    }
}
