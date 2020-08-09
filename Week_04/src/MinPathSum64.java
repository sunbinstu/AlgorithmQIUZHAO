

import java.util.Arrays;

/**
 * @description: 最小路径求和
 * @author: 孙彬
 */
public class MinPathSum64 {

    private int M;
    private int N;
    private int[][] memo;
    //dfs + 记忆
    public int minPathSum(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int r, int c) {
        //若越界，则认为不可达，距离为无穷大
        if (r < 0 || r >= M || c < 0 || c >= N) return Integer.MAX_VALUE;
        if (memo[r][c] > -1) return memo[r][c];
        //若到达终点，终点的贡献值是其本身
        if (r == M - 1 && c== N - 1) return grid[M - 1][N - 1];
        //右边的点到终点最短的路径
        int right = dfs(grid, r, c + 1);
        //下面的点到终点的最短路径
        int down = dfs(grid, r + 1, c);
        //取两者的较小值，计算出当前点的最小路径值
        int ans = Math.min(right, down) + grid[r][c];
        memo[r][c] = ans;
        return ans;
    }

    public int minPathSum0(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}
