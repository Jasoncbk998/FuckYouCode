public class sort_插入排序 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int[] ints = insertSort(nums);
        for (int a : ints) {
            System.out.print(a + "\t");
        }
    }

    public static int[] insertSort(int[] arr) {
        // 每次找到该长度对应的最大值,放到最后.
        for (int end = arr.length - 1; end > 0; end--) {
            int maxIndex = 0;
            // 从begin开始,到end结束寻找最大的索引并更新
            for (int begin = 1; begin <= end; begin++) {
                if (arr[maxIndex] <= arr[begin]) {
                    maxIndex = begin;
                }
            }
            // 最大值放到最后 交换位置
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[end];
            arr[end] = temp;
        }
        return arr;
    }
}
