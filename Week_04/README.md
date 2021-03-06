# 学习总结(week4)

## 动态规划

定义：**将一个问题拆成几个子问题，分别求解这些子问题，即可推断出大问题的解**。

关键：

1. 最优子结构opt[n] = best_of(opt[n-1],opt[n-2], ...)

2. 定义好状态空间，存储中间状态：opt[i]

3. 递推公式：状态转移方程或者DP方程

   Fib：opt[i] = opt[n-1]+opt[n-2]

   二维路径：opt[i, j] = opt[i + 1] [j] + opt[i] [j + 1]（且判断a[i, j]是否也为空地）

4. 自上而下推导，自底向上求解

动态规划重点：

1. 打破自己的思维惯性，形成机器思维：找重复性
2. 分治思想是理解复杂逻辑的关键，这也是职业进阶的要点要领
3. 学习算法，一定要注重算法的模板框架
4. 计算机解决问题其实没有任何奇技淫巧，它唯一的解决办法就是穷举，穷举所有可能性。算法设计无非就是先思考“如何穷举”，然后再追求“如何聪明地穷举”。列出动态转移方程，就是在解决“如何穷举”的问题。



