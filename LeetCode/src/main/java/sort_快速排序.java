import java.util.Arrays;

public class sort_快速排序 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println("aa");
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int position = parition(array, low, high);
            quickSort(array, low, position - 1);
            quickSort(array, position + 1, high);
        }
    }

    private static int parition(int[] array, int low, int high) {
        int pivot = array[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                if (array[i] <= pivot) {
                    int temp = array[i];
                    array[i] = array[pointer];
                    array[pointer] = temp;
                    pointer++;
                }
                System.out.println(Arrays.toString(array));
            }
        }
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }


}
