package _01_sort;

import tools.Integers;
import tools.Times;

public class bubbleSort1<E extends Comparable<E>> extends Sort<E> {
    public static void main(String[] args) {
        Integer[] array1 = Integers.random(10000, 1, 100000);
        Integer[] array_asc_1 = Integers.ascOrder(100, 5000);
        Integer[] array2 = Integers.copy(array1);
        Integer[] array_asc_2 = Integers.copy(array_asc_1);

        Integers.println(array1);
        Times.test("bubbleSort1", () -> {
            bubbleSort1(array1);
        });


        Integers.println(array1);
    }

    // 当数据非常无序的时候,效率反而更低
    public static void bubbleSort1(Integer[] array) {
        //这里  end>0  不需要等于0  加不加等号不影响结果
        for (int end = array.length - 1; end > 0; end--) {

            // 这里begin <= end 每次循环都到end截止 在begin,end中间寻找最大值
            for (int begin = 1; begin <= end; begin++) {
                // 进入if了说明是乱序,进行了交换
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;

                }
            }
        }
    }


    @Override
    protected void sort() {
        //这里  end>0  不需要等于0  加不加等号不影响结果
        for (int end = array.length - 1; end > 0; end--) {
            // 这里begin <= end 每次循环都到end截止 在begin,end中间寻找最大值
            for (int begin = 1; begin <= end; begin++) {
                // 进入if了说明是乱序,进行了交换
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                }
            }
        }
    }
}
