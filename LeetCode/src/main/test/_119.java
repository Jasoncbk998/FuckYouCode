import com.sun.java.swing.plaf.windows.WindowsTableHeaderUI;

import java.util.HashSet;

public class _119 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> sets = new HashSet<>();
        int maxLength = 0;
        for (int num : nums) {
            sets.add(num);
        }
        for (int num : nums) {
            if (!sets.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                while (sets.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        _119 temp = new _119();
        int i = temp.longestConsecutive(new int[]{400, 2, 200, 5, 200, 3, 600, 4, 7, 6});
        System.out.println(i);
    }
}
