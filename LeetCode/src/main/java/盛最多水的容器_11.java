public class 盛最多水的容器_11 {
    /**
     * 基本思想
     * 从左到右逼近的去查找
     * 每一次的左右边界计算一次area
     * 计算最大面积 max
     * 移动指针 ++l  --r
     */
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            // 面积=(最小高度)*(宽)
            int area = Math.min(height[l], height[r]) * (r - l);
            // 进行面积最大值比较
            ans = Math.max(ans, area);
            // 移动指针
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
