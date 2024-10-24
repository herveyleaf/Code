Mean，平均数

Median，中位数。Approximate median for grouped data，median = L1 + ((n/2 - (sum before the median interval)) / median frequency) * (L2 - L1)

Mode，众数，如果众数只有1个，就是unimodal，有2个就是bimodal，3个就是trimodal

如果中位数、平均数、众数都是同一个值，那么数据分布就是symmetric对称的，如果数据集中在左边，就是positively skewed，如果集中在右边，就是negatively skewed

方差的计算公式是每个值减去数据平均值之差的平方之和除以数据数量，如果是样本方差的话除以的是n-1，如果是总体方差的话是除以N

Chi-square，即卡方分析，通过计算每个值的期望，然后与实际的值通过公式计算出卡方，然后对比P值表来判断是否可以拒绝零假设

- 计算某一个值的期望，通过该行和该列的总数相乘，再除以整个数据的总数来得到，比如该行总数为450，该列总数为300，整体总数为1500，那么该值的期望就是450*300/1500
- 卡方的计算公式是，实际值减去期望值之差的平方，除以期望，即Σ(O - E)^2 / E
- degree of freedom，DF，自由度，即在直到总数的前提下，一张数据表中有几个值是可以随意改变的数量，计算公式是(行数-1) * (列数-1)，比如一个2行4列的数据，自由度就是3，因为在知道一行的所有数据之后，通过总数就可以得知另一行的各个数据，在知道n-1列的数据之后，通过总数就可以得知最后一列的数据
- 查表首先要知道自由度，然后将计算出的卡方值与表中数据进行比较，如果大于该数据，就可以在对应P值的confidence level下拒绝零假设
- 零假设就是假定两个变量没有关系，一般零假设是需要被推翻的假设，备择假设就是两个变量有关系

函数的方差其实就是E((X-μ)^2)，复合函数的期望与普通期望一样，就是每个复合函数的值乘上得到该值的概率之和，对于连续型的函数则通过微积分累积。通过化简后可以得到方差的公式：E(X^2) - (E(x))^2，平方的期望减期望的平方

协方差与方差相似，只是方差的公式是E((X-μ)^2)，而协方差将X-μ的平方换成了(X1-μ) * (X2-μ)，最后的公式化简形式就是E(X1X2) - E(X1) * E(X2)，如果协方差的值大于0，那么就是正相关，如果小于0就是负相关；如果二者不相关，即相互独立，那么协方差的值为0，但是反过来协方差为0不代表二者不相关

correlation相关度，即协方差除以两个变量各自方差之积，σ12/σ1σ2，相关度的值的范围在-1到1之间，小于0代表负相关，大于0代表正相关，且相关度的绝对值越大，则代表两个变量之间有着越紧密的相关性

box-plot，箱的上下界分别是Q3和Q1，箱里的线是median，也是Q2，箱外延伸出去的两条线是whisker，最高处即max，最低处即min，IQR是Q3-Q1，超过1.5*IQR的值即为outlier

histogram，直方图，以bar-plot的形式展现一个变量各个值的频率分布，比箱线图展现出来的信息要多，比如如果两份数据的min，Q1，median，Q3，max都是相同的，那么他们的箱线图就是相同的，但实际上这两份数据的直方图可以不一样

quantile plot，将数据的每个百分比所对应的值表现出来

QQ plot，将数据两个维度的值通过各自的百分比来相互对照

scatter plot，散点图可以很直观的看出数据的聚类、outlier等属性

similarity，相似度，通过计算两个对象的距离，并标准化到0到1这个范围内来进行比较

dissimilarity，不相似度，也可以叫distance距离，也是通过计算两个对象的距离，一般可以标准化到0到1之间，也可以直接用原始数据，范围是0到∞

proximity，临近度，一般指similarity和dissimilarity

对于numeric类型的数据，直接用距离来表示

- manhattan distance，即计算两个对象各个维度(属性)之间的差值，并直接求和

- euclidean distance，即计算两个对象各个维度之间的差值的平方，求和后开根号，是几何距离

Z-score标准化，将原始数据减去期望再除以标准差

proximity measure分为4种

- binary，用(1, 0)和(0, 1)数据的和除以总数，如果(1, 1)或(0, 0)过多，即不对称了，那么在分母去掉这部分

- categorical，一般是统计有多少对变量是匹配的，记为m，两个对象的距离就是变量总数p-m再除以p。也可以化为哑变量、独热编码

- ordinal，一般将其按顺序排列，两个变量之间的距离z=(r-1)/(M-1)，M为该变量取值的总数，r为在该变量取值中的排位

- mix，对于混合类型的数据，距离d为各个变量的距离之和，有一个系数δ，如果某一个变量中存在缺失值，或者该变量是不对成的binary型，且两个对象这个变量的值都是0，那么这个系数δ就是0，即不计算该变量，否则就是1，代表计算。最后将各个变量的距离求和，再除以系数δ之和

    - 如果该变量是numeric，那么将距离d用min-max标准化处理
    - 如果该变量是nominal或binary，那么距离d只有0和1两个值
    - 如果该变量是ordinal，那么将其排位值z当作numeric处理

cosine similarity，即计算两个对象的cos值

PCA通过对原变量进行线性组合，构造新的主成分变量，选取一定数量包含信息量最大的主成分代表整个数据，n个原变量可以构造n个主成分，因为各个主成分变量都是正交的

attribute subset selection，通过选取与结果相关的属性，排除掉所有不相关的属性进行降维，可以通过决策树来选择出相关变量，决策树会列出所有的情况

PCA是一种线性的降维方法，不适用于非线性，非线性方法有KPCA和SNE等

itemset，一个包含1到多个items的集合，k-itemset就是包含k个items的集合

absolute support，也是count，即一个集合在数据集内出现的次数，relative support是一个集合出现的次数除以数据集的总数，即该集合在总的数据集中占的百分比

frequent itemset，设置一个minsup系数σ，如果一个itemset的relative support大于等于σ，那就是frequent itemset

association rule，即set X -> set Y，计算confidence，sup(X, Y) / sup(X)，如果confidence大于等于minconf，那么就是strong association rule

association rule mining的步骤就是，先找到所有的frequent itemsets，对于每一个frequent itemset l，生成l的所有非空子集，对于每个非空子集s，生成rule s -> (l-s)，然后计算confidence，如果大于等于minconf，那么就是association rule，这里不需要考虑子集是否是frequent itemset，因为一个frequent itemset的任何非空子集都是frequent的

由于一旦数据集稍微大一点点，那么所有frequent itemsets的数量将非常非常大，无法储存下来，所以可以用两种pattern进行压缩

- closed patterns，如果一个pattern(itenset) X是frequent的，并且不存在一个与X的support相等的超集Y，令X是Y的子集，那么X是closed，这种pattern会减少patterns的数量但是不会丢失任何support信息

- max-patterns，如果一个pattern X是frequent的，且不存在任何一个超级Y，令X是Y的子集，那么X是max-pattern，这种pattern不关心max-pattern子集的实际support值，只能知道这个max-pattern的support值，所以是lossy compression

apriori算法，也是downward closure property，理论基础就是，任何一个frequent itemset的subset都是frequent，那么如果任何一个subset不是frequent的，就不需要考虑该itemset，因为它已经不满足association rule的条件——itemset是frequent。该算法的步骤如下

- 首先扫描整个DB去得到所有的frequent 1-itemset
- 然后重复以下步骤
    - 通过frequent k-itemsets的组合，生成(k+1) candidate itemsets
    - 找到candidate itemsets中的frequent itemsets
    - k = k+1
- 直到没有frequent或candidate itemset可以生成
- 剩下的所有frequent itensets即为所求

可以通过hash-based technique来让apriori算法速度更快，通过扫描DB来得到所有frequent 1-itemsets，合并它们得到一些更大的itemsets，然后通过一个hash function给每个itemset赋予一个hash值，根据这些hash值来把各个itemset归到一个bucket中，如果bucket内的itemset数量低于一个min support count，那么这个bucket中的所有itemset将在下一轮中被舍弃

FP-growth算法，即frequent pattern growth，克服了apriori算法的缺点，比如生成太多的candidate sets，需要重复扫描整个DB等，FP-growth算法不需要生成candidate，而是将数据压缩到一个较小的结构中，效率更高。apriori算法是广度优先的，而FP-growth是深度优先的，步骤如下

- 扫描一次DB，得到所有的frequent 1-itemsets
- 将所有的frequent 1-itemsets按从大到小排列
- 再次扫描DB，将每一条数据改写成ordered frequent itemlist
- 根据改写的itemlist，构建一个FP-tree
    - 将每条数据依次以树的形式写出来，每有一个新的顺序，就建立一个分支
- 对每一个frequent item，列出一个conditional database of pattern，根节点上的item不计入
- 通过conditional pattern database来构建conditional FP-tree，也需要满足minsup
- 最后根据FP-tree得出frequent patterns

有时Strong Association Rules其实是misleading的，因为即使满足了min_sup和min_conf，这样看上去它们是strong association rules，但其实实际数据表明，confidence(A, B) < P(A)或P(B)，即同时出现A和B降低了A或B出现的可能，即A和B其实是negatively associated

可以用Lift或者卡方分析来避免这种misleading，Lift(A, B) = P(A∪B)/P(A)P(B)，如果lift等于1那A和B就是不相关的，如果大于1就是正相关，小于1就是负相关。卡方分析的结果可以分析出是否相关，通过实际值与期望值比较可以得到正相关或负相关

但是卡方分析和lift不是null-invariant的，这就意味着如果数据中有过多或者过少的null数据，即(0, 0)型的数据，就会产生与实际情况不符的结论，比如只有很少的数据表明A和B同时出现，又有很多的数据显示A和B都不出现，最后计算的结果就是A和B是强正相关的，但实际上并不是，那么这个时候就需要使用null-invariant的measure