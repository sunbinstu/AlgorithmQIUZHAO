

/**
 * @description: 283.�ƶ��㵽����ĩβ
 * @author: ���
 */
public class MoveZeroes {
    //˫ָ��
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