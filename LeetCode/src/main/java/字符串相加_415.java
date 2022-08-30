public class 字符串相加_415 {
    /**
     * 输入：num1 = "11", num2 = "123"
     * 输出："134"
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;// 长度
        int j = num2.length() - 1; //长度
        int add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i > 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add; // 求和
            ans.append(result % 10); // 取余
            add = result / 10; // 进位
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
