import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _260 {

    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int num:nums){
            maps.put(num,maps.getOrDefault(num,0)+1);
        }
        int[] ints = new int[]{};
        int index=0;
        for (Map.Entry<Integer, Integer> entry:maps.entrySet()){
            if(entry.getValue()==1){
                ints[index]=entry.getKey();
                index++;
            }
        }

return ints;
    }
}
