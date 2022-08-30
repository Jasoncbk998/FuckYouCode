import java.util.HashMap;

public class test_map {
    public static void main(String[] args) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        maps.put(1,1);
        maps.put(1,2);
        maps.put(1,3);
        maps.put(2,3);
        maps.put(2,3);
        maps.put(2,3);
        System.out.println(maps.get(1));
    }
}
