

/**
 * @description: 2的幂
 * @author: 孙彬
 */
public class IsPowerOfTwo231 {

    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (((n & 1) == 1) || n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
        //return (x&(x-1)) == 0;
    }
}
