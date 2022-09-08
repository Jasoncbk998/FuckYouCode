package _03_回溯;

public class eightQueens {
    // 数组索引是行号,数组元素是列号 cols[4]=5 第四行的皇后在第五列
    int[] cols;

    public static void main(String[] args) {

        new eightQueens().eightQueens(8);
    }

    void eightQueens(int n) {
        if (n < 1) return;
        cols = new int[n];
        place(0);
        System.out.println(n + "皇后,一共有" + ways + "种摆法");
    }

    int ways; //记录多少种摆法

    // 从第row行开始摆放皇后
    void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }
        // 每一行都进行选择,然后进行剪枝  过滤掉不必要的操作,进行裁剪  这个思想就是剪枝
        for (int col = 0; col < cols.length; col++) {
            // 判断是否可以摆放皇后
            if (isValid(row, col)) {
                // 摆放皇后
                cols[row] = col;
                // 开始摆放下一行
                place(row + 1);// 当place(row + 1)  row+1执行完成后,就回溯到row  这时触发了回溯
            }
        }
    }

    private boolean isValid(int row, int col) {
        // 前面那些行
        for (int i = 0; i < row; i++) {
            // 第col列已经有皇后了
            if (cols[i] == col) return false;
            // 数学的斜率的知识,两个点是不是在一条直线上 用斜率的知识来解决
            if (row - i == Math.abs(col - cols[i])) {
                // 第i行的皇后跟第row行的第col列的皇后在一条线上
//                System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }
        }
        return true;
    }

    void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

}
