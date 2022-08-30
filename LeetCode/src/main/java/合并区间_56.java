import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间_56 {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        // 排序  按照每个子数组的左边界进行升序排序
        // int[][] a = {{2, 4}, {1, 3}, {7, 9}, {5, 8}};
        // 排序后: a = {{1, 3},{2, 4}, {5, 8}, {7, 9}};
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // 当前区间的右边界 与  待合并区间的左边界比较
            // 如果当前区间的右边界>=待合并区间的左边界,说明有重合,则更新当前区间的右边界
            if (temp[1] >= intervals[i][0]) {
                // temp的左边界是一定是最小的,所以比较右边界进行替换
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                // temp的右边界小于待合并区间的左边界,说明没有重合
                // 添加temp
                list.add(temp);
                // 然后更新temp
                temp = intervals[i];
            }
        }
        list.add(temp);
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] a = {{2, 4}, {1, 3}, {7, 9}, {5, 8}};
        int[][] merge = merge(a);

    }
}
