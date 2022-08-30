public class 反转整数_07 {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int temp = x % 10;
            x /= 10;
            result = result * 10 + temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println(reverse);

    }
}
