### 动态规划算法
将一个问题分解为若干个子问题，前一个子问题的解能给后一个子问题的解能提供有用的信息，因此动态规划算法最明显
的特征为
- `最优子结构` 子问题的解是当前问题的最优解
- `自问题重叠` 前一个子问题的解在后面的问题的解中多次用到
- `问题独立性` 每个问题的解都不会影响以后的决策，也就是每个子问题都是个独立的问题！

#### 最长递增子序列问题
有一个数组{3,1,4,1,5,9,2,6,5,7},获取其最长子序列{3,4,5,6,7}的过程属于动态规划算法的经典问题。
过程分析：{X1,X2...,Xn}的组成递增序列可以分解为{X1,X2...,X（n-1）} 集合的最长子序列加上Xn的问题，若Xn
比X(n-1)大，则Xn也可以加入这个序列，否则则弃用之因此我们只要找出第一个子问题的解，则可以获得其最终结
