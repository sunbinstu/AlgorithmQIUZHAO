




import java.util.*;

/**
 * @description:  字母分组 49
 * @author: 孙彬
 */
public class GroupAnagrams {
	  //排序后，插入HashMap,判断是否存在
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
