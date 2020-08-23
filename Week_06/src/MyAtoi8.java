

/**
 * @description: 字符串转换整数
 * @author: 孙彬
 */
public class MyAtoi8 {

    public static int myAtoi(String str) {
        if (str.isEmpty()) return 0;

        int sign = 1, base = 0, index = 0;
        //请求开始的空格
        while (str.charAt(index) == ' ')
            index++;
        //判断正负
        if (str.charAt(index) == '-' || str.charAt(index) == '+')
            sign = str.charAt(index++) == '-' ? -1 : 1;
        int n = str.length();
        while (index < n && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(index++) - '0');
        }
        return base * sign;
    }
}
