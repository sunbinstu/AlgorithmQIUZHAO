

/**
 * @description: 283.移动零到数组末尾
 * @author: 孙彬
 */
public class MoveZeroes {
    //双指针
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (index != i) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
                index++;
            }
        }
    }
}