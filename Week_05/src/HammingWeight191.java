

/**
 * @description: 位1的个数
 * @author: 孙彬
 */
public class HammingWeight191 {
    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }
}
