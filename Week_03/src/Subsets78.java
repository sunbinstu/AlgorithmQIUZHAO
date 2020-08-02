

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 子集
 * @author: 孙彬
 */
public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,nums,nums.length,res,new ArrayList<>());
        return res;
    }
    public void dfs(int index, int[] nums,int n,List<List<Integer>> res,List<Integer> ans) {
        if (index == n) {
            res.add(new ArrayList<>(ans));
            return;
        }
        dfs(index + 1,nums,n,res,ans);
        ans.add(nums[index]);
        dfs(index + 1,nums,n,res,ans);
        ans.remove(ans.size() - 1);
    }
}
