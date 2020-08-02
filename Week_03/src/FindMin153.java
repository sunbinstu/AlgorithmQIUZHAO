

/**
 * @description: 寻找排序数组中最小值
 * @author: 孙彬
 */
public class FindMin153 {

    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return -1;
        int left = 0, right = n - 1;
        if (n == 1 || nums[left] < nums[right]) return nums[0];
        while (right >= left) {
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[0] < nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

}
