import javax.crypto.Cipher;

public class 合并两个有序数组_88 {
    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素
     * <p>
     * 基本思路
     * 因为nums1的长度是m+n 所以只要看 n-1>=0 即可
     * 只要确保
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 两个数组的指针
        int i = m - 1, j = n - 1;
        // 插入nums1的指针
        int k = m + n - 1; // 通过控制k的指针进行元素偏移控制
        // 开始比对,只需要看j就可以,因为合并到nums1上去,如果合并到一个新的数据就不能只看j了
        // 不断往nums[k]里追加
        while (j >= 0) {
            if (i < 0 || nums2[j] > nums1[i]) {
                // 合并nums2
                nums1[k--] = nums2[j--];
            } else {
                // 合并nums1
                nums1[k--] = nums1[i--];
            }
        }
    }
}
