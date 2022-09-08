package _04_贪心;

import java.util.Arrays;

public class CoinChange {


    public static void main(String[] args) {
        new CoinChange(new Integer[]{25, 20, 5, 1}, 41);
    }


    public CoinChange(Integer[] faces, int money) {
        Arrays.sort(faces);
        int coins = 0, idx = faces.length - 1;
        while (idx >= 0) {
            // 余额如果大于当前面值 就取
            while (money >= faces[idx]) {
                System.out.println(faces[idx]);
                money -= faces[idx];
                coins++;
            }
            // idx -- 取下一个面值的硬币
            idx--;
        }
        System.out.println(coins);
    }


}
