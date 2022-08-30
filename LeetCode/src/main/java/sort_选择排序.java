public class sort_选择排序 {
    public static void main(String[] args) {
        int[] ints = {5, 4, 3, 2, 1};
        selectSort(ints,ints.length);
        for(int a:ints){
            System.out.print(a+"\t");
        }
    }
    public static void selectSort(int[] a, int n) {
        int i; // 有序区的末尾位置
        int j; // 无序区的起始位置
        int min; // 无序区中最小元素位置
        for (i = 0; i < n; i++) {
            min = i;
            // 找出a[i+1] ... a[n] 之间最小的元素,赋值给min
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j; //最小值元素的位置
                }
            }
            // 如果min!=i 则交换a[i] 和a[min]
            // 交换之后,保证了 a[0] .. a[i] 之间的元素是有序的
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
}
