public class 岛屿数量_200 {
//    dfs 深度搜索
// 输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3

    /**
     * 基本思路
     * 扫描每一个元素,如果这个元素是1,那么把它的上下左右等于1的元素元素都改成0,
     * 并且把这个元素的上下左右也都改成0,可以理解为传染同化的概念,这样第一次传染就把相邻的1都变成了0,也就是一个岛屿找完了
     *
     * 然后再去继续寻找新的岛屿,两个for循环进行遍历寻找
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return result;
    }

    private static void dfs(char[][] grid, int x, int y, int row, int col) {
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x - 1, y, row, col);
        dfs(grid, x + 1, y, row, col);
        dfs(grid, x, y + 1, row, col);
        dfs(grid, x, y - 1, row, col);
    }
}
