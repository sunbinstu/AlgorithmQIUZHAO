


import java.util.Arrays;

/**
 * @description:242.��Ч��ĸ��λ��
 * @author: ���
 * @create: 2020-07-19 17:23
 */
public class Anagram {
	 //ʹ��hash
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
    //�����Ƚ�
    public boolean isAnagram2(String s, String t) {
        if (s.length() !=  t.length()) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }
}