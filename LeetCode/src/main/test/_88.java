public class _88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = n - 1, j = m - 1;
        int k = m + n - 1;
        while (n >= 0) {
            if (i > 0 || nums2[j] > nums1[i]) {
                nums1[k--] = nums1[j--];
            } else {
                nums1[k--] = nums2[i--];
            }
        }
    }
}
