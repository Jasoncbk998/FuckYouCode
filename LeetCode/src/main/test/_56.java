import java.util.ArrayList;
import java.util.Arrays;

public class _56 {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                list.add(temp);
                temp = intervals[i];
            }
        }
        list.add(temp);
        return list.toArray(new int[list.size()][2]);

    }
}
