package _01_sort;

import javafx.scene.web.WebEngine;

public class selectSort<E extends Comparable<E>> extends Sort<E> {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                // array[maxIndex] <= array[begin] 是为了稳定性.因为找一个最大值放到最后去
                if(cmp(maxIndex, begin)<=0){
                    maxIndex=begin;
                }
//                if (array[maxIndex] <= array[begin]) {
//                    maxIndex = begin;
//                }
            }
            swap(maxIndex,end);
        }
    }
}
