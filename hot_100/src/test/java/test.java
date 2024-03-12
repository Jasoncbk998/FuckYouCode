import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> maps = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = maps.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            maps.put(key, list);
        }
        return new ArrayList<List<String>>(maps.values());
    }

    public static void main(String[] args) {
        test test = new test();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = test.groupAnagrams(strs);
        System.out.println(lists);
    }
}
