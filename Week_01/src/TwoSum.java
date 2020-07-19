
import java.util.HashMap;
import java.util.Map;


/**
 * @description: 两数之和   1
 * @author: 孙彬
 */
public class TwoSum {
	
	//时间O(n),空间O(n)
	//借助HashMap检查是否由符合的数据
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int num = target-nums[i];
            if (map.containsKey(num)){
                result[0]=i;
                result[1]=map.get(num);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
	
}
	