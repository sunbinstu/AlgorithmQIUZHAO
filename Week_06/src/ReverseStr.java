

/**
 * @description:
 * @author: 孙彬
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = (i + k - 1 < n) ? i + k - 1 : n - 1;
            while (left <= right) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        return new String(ch);
    }
}
