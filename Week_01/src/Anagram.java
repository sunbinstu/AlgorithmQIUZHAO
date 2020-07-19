


import java.util.Arrays;

/**
 * @description:242.有效字母异位词
 * @author: 孙彬
 * @create: 2020-07-19 17:23
 */
public class Anagram {
	 //使用hash
    public boolean isAnagram(String s, String t) {
        if (s.length() !=  t.length()) return false;
        int[] hash = new int[26];
        char[] c1 = s.toCharArray();
        for (char c : c1)
            hash[c - 97]++;

        char[] c2 = t.toCharArray();
        for (char c : c2) {
            hash[c - 97]--;
            if (hash[c - 97] < 0) {
                return false;
            }
        }
        return true;
    }
    //排序后比较
    public boolean isAnagram2(String s, String t) {
        if (s.length() !=  t.length()) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }
}