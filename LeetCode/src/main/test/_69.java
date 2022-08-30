public class _69 {
    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = {1, 2, 3, 4, 5, 6, 7};
        int left = 0, right = ans.length - 1;
        int mid = left + (right - left) / 2;
        System.out.println(ans[mid]);

    }

}
