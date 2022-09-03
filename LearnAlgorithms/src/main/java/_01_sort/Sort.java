package _01_sort;

import java.text.DecimalFormat;

public abstract class Sort<E extends Comparable<E>> implements Comparable<Sort> {
    protected E[] array;

    // 比较次数
    private int cmpCount;
    // 交换次数
    private int swapCount;
    private long time;

    private DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort(E[] array) {
        if (array == null || array.length < 2) return;
        this.array = array;
        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    protected abstract void sort();

    /**
     * 返回值等于0, array[i1]=array[i2]
     * 返回值小于0, array[i1]<array[i2]
     * 返回值大于0, array[i1]>array[i2]
     */
    protected int cmp(int i1, int i2) {
        cmpCount++;
        return array[i1].compareTo(array[i2]);
    }

    /**
     * 重载,传元素
     */
    protected int cmp(E i1, E i2) {
        cmpCount++;
        return i1.compareTo(i2);
    }


    protected void swap(int i1, int i2) {
        swapCount++;
        E tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

    @Override
    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + numberString(cmpCount);
        String swapCountStr = "交换：" + numberString(swapCount);
        // 稳定性要放到比较和交换次数前边,不然会影响比较合适交换次数的结果,因为稳定性也做了一次排序
        String stableStr = "稳定性：" + isStable();
        return "【" + getClass().getSimpleName() + "】\n"
                + stableStr + " \t"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";

    }

    private boolean isStable() {
        Student[] student = new Student[20];
        for (int i = 0; i < student.length; i++) {
            student[i] = new Student(i * 10, 10);
        }
        sort((E[]) student);
        for (int i = 1; i < student.length; i++) {
            int score = student[i].score;
            int prevScore = student[i - 1].score;
            if (score != prevScore + 10) return false;
        }
        return true;
    }

    @Override
    public int compareTo(Sort o) {
        int result = (int) (time - o.time);
        if (result != 0) return result;

        result = cmpCount - o.cmpCount;
        if (result != 0) return result;

        return swapCount - o.swapCount;
    }

    private String numberString(int number) {
        if (number < 10000) return "" + number;

        if (number < 100000000) return fmt.format(number / 10000.0) + "万";
        return fmt.format(number / 100000000.0) + "亿";
    }
}
