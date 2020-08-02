

import java.util.Arrays;

/**
 * @description: 分发饼干
 * @author: 孙彬
 */
public class FindContentChildren455 {
    public int findContentChildren(int[] g, int[] s) {
        int n1 = g.length;
        int n2 = s.length;
        if (n1 == 0 || n2 == 0) return 0;
        int g1 = 0;
        int s1 = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (g1 < n1 && s1 < n2) {
            if (g[g1] <= s[s1]) {
                g1++;
            }
            s1++;
        }
        return g1;
    }
}
