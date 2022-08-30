package _01_sort;

public class selectSort {

    public static void selectSort(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                // array[maxIndex] <= array[begin] 是为了稳定性.因为找一个最大值放到最后去
                if (array[maxIndex] <= array[begin]) {
                    maxIndex = begin;
                }
            }
            int tmp = array[maxIndex];
            array[maxIndex] = array[end];
            array[end] = tmp;
        }


    }


}
