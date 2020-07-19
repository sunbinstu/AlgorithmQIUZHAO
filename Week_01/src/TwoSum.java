
import java.util.HashMap;
import java.util.Map;


/**
 * @description: ����֮��   1
 * @author: ���
 */
public class TwoSum {
	
	//ʱ��O(n),�ռ�O(n)
	//����HashMap����Ƿ��ɷ��ϵ�����
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
	