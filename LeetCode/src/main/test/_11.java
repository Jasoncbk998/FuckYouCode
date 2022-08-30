import java.awt.event.HierarchyBoundsAdapter;

public class _11 {

    public static int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(area, max);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return max;
    }
}
