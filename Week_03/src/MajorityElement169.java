

/**
 * @description: 多数元素
 * @author: 孙彬
 */
public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int number = nums[0];
        int count = 1;
        int n = nums.length;
        for (int i = 1;i<n;i++) {
            if (number == nums[i])
                ++count;
            else if (--count == 0){
                number = nums[i];
                count = 1;
            }
        }
        return number;
    }
}
