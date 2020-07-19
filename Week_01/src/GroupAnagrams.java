




import java.util.*;

/**
 * @description:  ��ĸ���� 49
 * @author: ���
 */
public class GroupAnagrams {
	  //����󣬲���HashMap,�ж��Ƿ����
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 || strs == null) return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String keyStr = String.valueOf(c);
            if(!map.containsKey(keyStr)) map.put(keyStr,new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
