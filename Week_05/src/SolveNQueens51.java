

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: N皇后
 * @author: 孙彬
 */
public class SolveNQueens51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //列
        boolean[] column = new boolean[n];
        //此对角线
        boolean[] u = new boolean[2 * n - 1];
        //主对角线
        boolean[] d = new boolean[2 * n - 1];
        //数据
        int[] h = new int[n];
        helper(res,column,u,d,h,n,0);
        return res;
    }

    public void helper(List<List<String>> res,boolean[] column,
                       boolean[] u,boolean[] d,int[] h,int n,int row){
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i=0;i<n;i++) {
                char[] cs = new char[n];
                Arrays.fill(cs,'.');
                cs[h[i]] = 'Q';
                list.add(new String(cs));
            }
            res.add(list);
            return;
        }
        for (int col=0;col<n;col++) {
            if (column[col] || u[col + row] || d[row - col + n - 1] ) continue;
            column[col] = true;
            u[col + row] = true;
            d[row - col + n - 1] = true;
            h[row] = col;
            helper(res,column,u,d,h,n,row + 1);
            column[col] = false;
            u[col + row] = false;
            d[row - col + n - 1] = false;
        }

    }
}
