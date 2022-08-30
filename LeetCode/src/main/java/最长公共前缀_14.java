public class 最长公共前缀_14 {
    /**
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 如果 string数组是null 或者长度是0 那么就返回空串
     * 外层循环是循环第一个string的长度
     * 内存循环是取数组中的每一个string,然后比较不同string的相同位置字符是否相同
     * 如果不同string的相同位置字符不等 那么就说明 最长公共子串就找到了
     * */

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int count = strs.length;
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
