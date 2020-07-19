/*
	189.��ת����
	���
*/
public class Rotate {

		
    //ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
    //ͨ����ת����[1,2,3,4,5,6,7]
    //1.������ת[7��6��5��4��3��2��1]
    //2.��תͷ��k��[5,6,7,4,3,2,1]
    //3.��תʣ������[5��6��7��1��2��3��4]
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}