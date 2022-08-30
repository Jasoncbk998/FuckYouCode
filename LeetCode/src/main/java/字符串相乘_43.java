public class 字符串相乘_43 {
    /**
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     */
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x=num1.charAt(i)-'0';
            for (int j = n - 1; j >= 0; j--) {
                int y=num2.charAt(j) - '0';
                int mult = x*y;

                int sum = mult + result[i+j+1];
                result[i+j+1] = sum % 10;
                result[i+j] += sum / 10;
            }
        }
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        StringBuffer ans = new StringBuffer();
        for (; i < result.length; i++) {
            ans.append(result[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "45";
        String multiply = multiply(num1, num2);
        System.out.println(multiply);
    }
}