package _07_string;

/**
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 *
 * 核心思想
 * 首先去除多余空格,并且每个单词中间空出一个空格,利用布尔值进行控制
 * 然后判断去除多余空格后的真实长度, len = space ? (cur - 1) : cur; 如果是true,则说明cur当前是空格需要-1,反之亦然
 *      这点可以手动推理一下
 * 然后反转新string
 * 根据每个单词之间都有空格,利用这个来进行单词的反转
 * 由于考虑到新string是由原string原地进行移动,所以len位置可能是多余的字符,所以循环是<len 而不是 <=len
 * 所以最后一个单词需要手动进行翻转
 */
public class _151_翻转字符串里的单词 {
    public static String reverseWords(String s) {
        if (s == null) return "";
        char[] chars = s.toCharArray();

        // 消除多余的空格
        // 字符串最终的有效长度
        int len = 0;
        // 当前用来存放字符的位置
        int cur = 0;
        // 前一个字符是否为空格字符
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') { // chars[i]是非空格字符
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) { // chars[i]是空格字符，chars[i - 1]是非空格字符
                chars[cur++] = ' ';
                space = true;
            }
        }
        // 通过标识符判断真是string长度
        len = space ? (cur - 1) : cur;
        if (len <= 0) return "";

        // 对整一个有效字符串进行逆序
        reverse(chars, 0, len);

        // 对每一个单词进行逆序
        // 前一个空格字符的位置（有-1位置有个假想的哨兵，就是一个假想的空格字符）
        // 因为第一个字符可能不是空格,所以就是-1开始
        int prevSapceIdx = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') continue;
            // i是空格字符的位置
            // prevSapceIdx 就是上个空格,所以prevSapceIdx+1 就是当前单词开始的位置,左闭右开[prevSapceIdx + 1 , i)
            reverse(chars, prevSapceIdx + 1, i);
            // 进行更新
            prevSapceIdx = i;
        }

        // 翻转最后一个单词
        // 因为len不能是<= 因为会有遗留的字符,不能直接=
        // 所以单独反转最后一个单词
        reverse(chars, prevSapceIdx + 1, len);

        return new String(chars, 0, len);
    }

    /**
     * 左闭右开
     * 将[li, ri)范围内的字符串进行逆序
     * abc
     * 0,3
     */
    private static void reverse(char[] chars, int li, int ri) {
        ri--;
        while (li < ri) {
            char tmp = chars[li];
            chars[li] = chars[ri];
            chars[ri] = tmp;
            li++;
            ri--;
        }
    }

    public static void main(String[] args) {
        System.out.println("666_" + reverseWords("") + "_666");
        System.out.println("666_" + reverseWords("  hello world!     ") + "_666");
        System.out.println("666_" + reverseWords("a good   example") + "_666");
        System.out.println("666_" + reverseWords("are you ok") + "_666");
    }
}
