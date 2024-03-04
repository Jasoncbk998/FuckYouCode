

import java.security.Key;
import java.util.*;

public class 字母异位词分组_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> maps = new HashMap<String, List<String>>();
        for (String str : strs) {
//            string to charry 可以直接利用 Arrays.sort(array); ,对字符进行排序
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
//                   利用map的kv特性.,进行比对,根据key取出list.map的每一个key的value都是list
            List<String> list = maps.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            maps.put(key, list);

        }
        return new ArrayList<List<String>>(maps.values());
    }



    public static void main(String[] args) {
        字母异位词分组_49 test = new 字母异位词分组_49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};



    }


}
