package com.leetcode.homework;

/**
 * @description: 丑数
 * @author: 孙彬
 */
public class NthUglyNumber49 {

    public int nthUglyNumber(int n) {
        int a = 0,b = 0,c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i=1;i<n;i++){
            int n1 = res[a] * 2;
            int n2 = res[b] * 3;
            int n3 = res[c] * 5;
            res[i] = Math.min(n1,Math.min(n2,n3));
            if (res[i] == n1) a++;
            if (res[i] == n2) b++;
            if (res[i]== n3) c++;
        }
        return res[n-1];
    }
}
