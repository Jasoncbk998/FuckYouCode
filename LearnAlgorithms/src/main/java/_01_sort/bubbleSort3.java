package _01_sort;

public class bubbleSort3<E extends Comparable<E>>  extends Sort<E> {


    public static void bubbleSort3(Integer[] array) {
        //这里  end>0  不需要等于0  加不加等号不影响结果
        for (int end = array.length - 1; end > 0; end--) {
            // 初始值要防止完全有序的时候会停掉循环
            int sortedIndex = 0;
            // 这里begin <= end 每次循环都到end截止 在begin,end中间寻找最大值
            for (int begin = 1; begin <= end; begin++) {
                // 进入if了说明是乱序,进行了交换
                // 在这里控制稳定性 如果等于就不稳定了
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sortedIndex = begin;
                }
            }
            //记录上一轮最后交换元素的位置
            end = sortedIndex;
        }
    }

    @Override
    protected void sort() {
        //这里  end>0  不需要等于0  加不加等号不影响结果
        for (int end = array.length - 1; end > 0; end--) {
            // 初始值要防止完全有序的时候会停掉循环
            int sortedIndex = 1 ;
            // 这里begin <= end 每次循环都到end截止 在begin,end中间寻找最大值
            for (int begin = 1; begin <= end; begin++) {
                // 进入if了说明是乱序,进行了交换
                // 在这里控制稳定性 如果等于就不稳定了
               if(cmp(begin,begin-1)<0){
                   swap(begin,begin-1);
                   sortedIndex=begin;
               }
            }
            //记录上一轮最后交换元素的位置
            end = sortedIndex;
        }
    }
}
