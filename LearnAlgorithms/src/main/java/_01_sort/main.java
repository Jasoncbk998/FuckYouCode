package _01_sort;

import tools.Asserts;
import tools.Integers;
import tools.Times;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int count = 500;
        int max = 2 * count;
        Integer[] array = Integers.random(count, 1, max);
        testSorts(array, new Sort[]{
                new bubbleSort3(),
                new bubbleSort2(),
                new bubbleSort1(),
                new selectSort(),
                new heapSort()
        });
    }

    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            sort.sort(Integers.copy(array));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }

    }


}
