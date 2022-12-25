import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间_56 {
    public static int[][] merge(int[][] intervals) {
        //存放结果
        ArrayList<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        // [1,3] [2,4] [5,8] [7,9]
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 明确: 我们比较的是两个数组的边界
        for (int[] interval : intervals) {
            // 数组A的start > 数组B的end 则add数组A,因为没有交集,所以直接add即可
            // 其中,数组B是result的最后一个数组
            if (result.size() == 0 || interval[0] > result.get(result.size() - 1)[1]) {
                result.add(interval);
            } else {
                // 更新边界,两个数组的end进行比较
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }
        //进行返回
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] a = {{2, 4}, {1, 3}, {7, 9}, {5, 8}};
        int[][] merge = merge(a);
        System.out.println(merge);

    }
}
