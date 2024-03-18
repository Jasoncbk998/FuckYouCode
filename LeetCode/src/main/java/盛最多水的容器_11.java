public class 盛最多水的容器_11 {
//    题目说明
//    给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//    返回容器可以储存的最大水量。

    /**
     * 基本思想
     * 从左到右逼近的去查找
     * 每一次的左右边界计算一次area
     * 计算最大面积 max
     * 移动指针 ++l  --r
     */
    public static int maxArea(int[] height) {
//        长 和宽
        int l = 0, r = height.length - 1;
//        面积
        int ans = 0;
//        通过l<r ,依次计算面积进行比对
        while (l < r) {
            // 面积=(最小高度)*(宽)
//            最小高度: 因为是盛水的容器,两个高低的最小值才能是高度,也就是取两个元素的最小值 => 两个指针指向的数字中较小值∗指针之间的距离
//            r-l 是两个索引的间距也就是宽
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

    public static int maxArea_1(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;

        while (l < r) {
            int high = Math.min(height[r], height[l]);
            int length = r - l;
            ans = Math.max(ans, high * length);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea_1(nums);
        System.out.println(i);
    }
}
