import java.util.Arrays;

public class sort_冒泡排序 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        bubbleSort(nums);
        System.out.println(nums);
    }

    /**
     * 基本思想
     * 循环n次
     * 每层循环,每次寻找一个最大值不断进行交换,放到最后  内层循环边界是 arr.length-i
     *
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            //每次循环都找到一个最大值不断交换放到最后
            // 所以循环边界是 arr.length - i  因为每次找到一个最大值
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            // 如果进入到这里就说明,已经排序完成了
            // 也就是说,再一次寻找中,是顺序排列的,所以直接break
            if (flag) {
                break;
            }
        }
        return arr;
    }


}
