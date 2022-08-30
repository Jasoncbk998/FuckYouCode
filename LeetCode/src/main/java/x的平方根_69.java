public class x的平方根_69 {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        // 开始寻找
        while (l <= r) {
            // 中间值
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
