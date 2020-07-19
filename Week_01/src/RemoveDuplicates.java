

/*
  26.删除排序数组中的重复项
  孙彬
*/
public class RemoveDuplicates {
	//双指针
	public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if  (n== 0) return 0;
        int i = 0;
        for (int j=1;j<n;j++) {
            if(nums[j]!=nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}