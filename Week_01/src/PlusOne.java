

/**
 * @description:66.��һ
 * @author: ���
 * @create: 2020-07-19 18:43
 */
public class PlusOne {
	
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i=n-1;i>=0;i--){
            digits[i]++;
            digits[i] %= 10;
            //�Ƿ���Ҫ��λ
            if(digits[i] != 0)
                return digits;
        }
        //��λ+1
        digits = new int[n+1];
        digits[0] = 1;
        return digits;
    }
}
