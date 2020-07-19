/*
	189.旋转数组
	孙彬
*/
public class Rotate {

		
    //时间复杂度O(n),空间复杂度O(1)
    //通过旋转链表[1,2,3,4,5,6,7]
    //1.整个翻转[7，6，5，4，3，2，1]
    //2.翻转头部k个[5,6,7,4,3,2,1]
    //3.翻转剩余数据[5，6，7，1，2，3，4]
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