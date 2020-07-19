


import java.util.Stack;

/**
 * @description: 42.����ˮ
 * @author: ���
 */
public class Trap {
    public static void main(String[] args) {
        //0,  1, 0, 2, 1, 0, 1, 3, 2, 1, 2 , 1
        trap6(new int[]{0,2,0,1,0,3,1,1});
    }

   //˫ָ��
    public static int trap(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // ����ָ���ȥ
        for (int i = 1; i < height.length - 1; i++) {
            //�����Ҹ�
            //����ǽ�ͣ���������ǽ
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //���ҵ����
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        System.out.println(sum);
        return sum;
    }
    
    
		//����ջ
    public static int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //���ջ���ղ��ҵ�ǰָ��ĸ߶ȴ���ջ���߶Ⱦ�һֱѭ��
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //ȡ��Ҫ��ջ��Ԫ��
                stack.pop(); //��ջ
                if (stack.empty()) { // ջ�վͳ�ȥ
                    break;
                }
                int distance = current - stack.peek() - 1; //����ǽ֮ǰ�ľ��롣
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++; 
        }
        return sum;
    }


}
