
/**
 * @description:88.�ϲ�������������
 * @author: ���
 */
public class Merge {

   //ʱ��O(n),�ռ�O(n)
   //��ͷ������
	 public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        System.arraycopy(nums1,0,nums3,0,m);
        int p = 0;
        int p1=0;
        int p2=0;
        while (p1<m&&p2<n)
            nums1[p++] = nums3[p1]<nums2[p2] ? nums3[p1++] : nums2[p2++];

        if (p1<m)
            System.arraycopy(nums3,p1,nums1,p,m-p1);
        if(p2<n)
            System.arraycopy(nums2,p2,nums1,p,n-p2);
    }
    
		//ʱ��O(n),�ռ�O(1)
		//��β������
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p2 >= 0 && p1 >= 0)
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }
	
	
}