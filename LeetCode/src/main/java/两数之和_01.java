import java.util.HashMap;

public class 两数之和_01 {
    /**
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
     * <p>
     * 基本思路
     * 通过map kv对形式来确定  map的key是具体数值 value是索引位置
     * 首先,map的k是arr的具体数值,通过target-nums[i]来确认是否存在,存在则返回
     * 不存在则put继续循环
     * put value  返回索引
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(target - nums[i])) {
                // 返回索引
                return new int[]{maps.get(target - nums[i]), i};
            }
            // put value
            maps.put(nums[i], i);
        }
        return null;
    }


    public int[] twoSum_1(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
//            9-2=7
            if (maps.containsKey(target-nums[i])){
                return new int[]{i,maps.get(target-nums[i])};
            }
            maps.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        两数之和_01 test = new 两数之和_01();
        int[] nums= {2,7,11,15,232323,54545,423,223,556,778,    99,11       ,22,33,44,55,66,77,88,998,7878,7567,5656,45656,88888888};

        int[] ints = test.twoSum_1(nums, 110);
        for (int i=0;i<ints.length;i++){
            System.out.println(nums[ints[i]]);
        }
    }
}