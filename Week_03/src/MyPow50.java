

/**
 * @description: pow(x,n)
 * @author: 孙彬
 */
public class MyPow50 {
    public double myPow(double x, int n) {
        long N = n;
        return (N >= 0)? fastPow(x,N) : 1/fastPow(x,-N);
    }
    public double fastPow(double x,long n) {
        if (n == 0) return 1.0;
        double half = fastPow(x,n / 2);
        return (n % 2 == 0) ? half * half : half * half * x;
    }
}
