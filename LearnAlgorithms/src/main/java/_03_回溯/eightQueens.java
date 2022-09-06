package _03_回溯;

public class eightQueens {
    // 数组索引是行号,数组元素是列号 cols[4]=5 第四行的皇后在第五列
    int[] cols;

    public static void main(String[] args) {

        new eightQueens().eightQueens(8);
    }

    void eightQueens(int n) {
        if (n < 1) return;
        place(0);
        System.out.println(n+"皇后,一共有"+ways+"种摆法");
    }
    int ways; //记录多少种摆法
    // 从第row行开始摆放皇后
    void place(int row) {
        if(row==cols.length){
            ways++;
            return;
        }
        // 每一行都进行选择,然后进行剪枝
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

        return false;
    }

}
