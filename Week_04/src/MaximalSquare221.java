

/**
 * @description: 最大正方形
 * @author: 孙彬
 */
public class MaximalSquare221 {
    int n,m;
    public int maximalSquare(char[][] matrix) {
        n = matrix.length;
        if (n == 0) return 0;
        m = matrix[0].length;
        if (m == 0) return 0;
        int maLen = 1;
        return dfs(maLen, matrix,0);
    }

    public int dfs(int maLen, char[][] matrix, int k) {
        for (int i=k; i <= n-maLen; i++) {
            for (int j=0; j <= m-maLen; j++) {
                if (judge(maLen, matrix, i, j))
                    return Math.max(maLen*maLen ,dfs(maLen+1, matrix, i));
            }
        }
        return 0;
    }

    public boolean judge(int maLen, char[][] matrix, int i,int j) {
        if (maLen == 1 && matrix[i][j]=='1') return true;
        for (int k=i; k<i+maLen; k++) {
            for (int h=j; h<j+maLen; h++) {
                if (matrix[k][h]=='0')
                    return false;
            }
        }
        return true;
    }
}
