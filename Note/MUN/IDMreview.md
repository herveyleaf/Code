#

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

# 

clustering是unsupervised，而classification是supervised，需要data有已知的labels

partitioning method是直接指定需要的groups数量然后进行分类，只对spherical shape的data效果不错，但是对复杂的数据效果不佳，常用的算法是k-means

k-means的步骤如下

首先user指定the number of clusters k，然后在dataset的n个objects中随机选出k个objects作为initial cluster centers，再通过计算剩下的每个objects与cluster centers的euclidean distance，将the most similar objects放到对应的cluster中，然后update cluster centers，重复这个步骤直到no change

由于initial centroids are chosen randomly，所以运行多次可能会得到多个不同的结果。复杂度是O(n * k * t)，n是number of iteration。k-means可能达不到global optimum，通常是得到一个local optimum，并且initial cluster center和outliers会影响到结果

对于一种clustering的好坏的衡量，通常使用SSE，Sum of Squared Error。对于每个point，error是the distance to the nearest cluster，所以SSE = ΣΣ dist^2(x, ci) = ΣΣ (||x - ci||^2)，就是每个data point与其cluster center的距离的平方和。减小SSE最简单的方法就是增加k，而一个good clustering with smaller K的SSE可能比poor clustering with larger K要高，当k = n时，SSE是0

由于k-means算法对初始状态sensitive，不同的initialization可能得到相当不同的clustering result，所以提出了k-means++这个优化

算法的步骤是：
1. First Centroid：choose one initial point randomly
2. Remaining Centroid：对于剩下的k-1个centroids
    - 对于dataset中的每一个point，计算其与距离最近的centroid之间的距离
    - randomly pick the next centroid，with a probability that is proportional to the square of the distance to the nearest centroid，与任何一个centroid距离都较远的point有更高的概率被选中，有助于spread them out
3. 重复步骤2直到有k个centroids被选中

k-means++相较randomly select centroids会更慢一些，但是结果更好，尤其是在降低SSE这方面。基于概率进行centroid的选择让算法更加balanced and robust，可以避免选中outlier作为centroid，并且避免deterministic patterns

由于k-means算法对outlier也sensitive，所以设计出k-medoids算法，目的是reduce sensitive to outliers。k-medoids从dataset中selects an actual point作为center(medoid)，每个data point都被assigned to the cluster with the closest medoid，这样可以最小化absolute-error。当k=1时，复杂度是O(n^2)，而当k是general positive number时，k-medoid problem是NP-hard

因为k-medoids算法是NP-hard，所以只是一个理论上的算法，实际应用会使用PAM，Partitioning Around Medoids算法。PAM的每一次decision-making都是即时的，基于cost的，不会考虑到全局最优，所以这是一种贪心算法，这也意味着PAM不能保证得到optimal solution

PAM的步骤如下：
1. Initialization：随机选取k个objects作为initial medoids
2. Assignment：assign所有non-medoid object到距离其最近的medoid来形成clusters
3. Swap Evaluation：随机选取1个non-medoid objects o_random
    - calculate the cost of swapping each medoid with o_random
    - 如果swapping reduces the overall clustering cost(measured by a change in abolute error)，那么就perform the swap
4. 重复步骤2和3直到没有swaps improve the cost

PAM对于较小的dataset的效果较好，而对于较大的dataset则不是很好，因为算法的复杂度很高

由于PAM计算量较大，且median与mean相比，对outlier的sensitive更小，所以k-medians算法也是一种优化

这种算法先随机选择k个points作为initial representative objects，然后assign every point to its nearest median，并且重新计算每个cluster的median，重复以上两步，直到criterion function收敛

k-means不能处理categorical data，而k-modes则是用modes替换means以扩展可处理的数据类型。distance通过dissimilarity between object X and the center of a cluster Z来计算，并且这个算法也是会迭代并进行centroid update的。对于categorical和numerical的mix of data，可以使用k-prototype算法

hierarchical method是建立一个tree-like的cluster structure，有agglomerative(bottom-up)或divisive(top-down)两种方向，常用的是agglomerative。这种方式的缺点是，一旦作出了决定，就不能回头了，也就是说error不能被修正，所以这种方法是deterministic的，在不更改参数的前提下，即使多次运行，得到的结果也始终是一样的

这种方法最重要的就是similarity measurement，用于对每个cluster是否要合并进行计算，不同的similarity measure会得到不同的merge结果

single-linkage，即使用minimum distance，根据两个clusters之间距离最近的points之间的距离进行join判断；complete-linkage，即使用maximum distance，根据两个clusters之间距离最远的points之间的距离进行join判断。与k-means算法一样，single-linkage和complete-linkage都是sensitive to outrilers，可以使用mean或者average distance进行计算来避免outlier的影响

使用mean时，叫做centroid-linkage，而使用average时，叫做average-linkage，或者GAAC

GAAC是考虑要合并的两个cluster中的所有pairs，不包括原本就在同一个cluster的两个points，以所有pairs之间的距离的平均值作为两个clusters之间的距离，所以GAAC的计算量非常大；而在centroid clustering中，以两个clusters的质心，即两个clusters原本的centroid之间的距离作为clusters之间的距离，计算量减少

ward's criterion则是与partitioning methods中最小化SSE的思想一样，即每次进行merge时，选择两个合并后的SSE最小的cluster进行合并，在所有的similarity measure中，ward's criterion的效果是最好的

density-based method对于complex shape的data效果较好，其中常用的算法是DBSCAN

核心思想是identify dense region to form clusters，这里有两个参数，ε和min-points，ε是neighborhood的半径大小，而min-points是衡量一个point是否为core point，如果neighborhood中的points数量不小于min-points，那么就是core point

DBSCAN中的每个points可以分为以下几类：
- Core Object：neighborhood中有不低于min-points的points的object，统计neighborhood中points时要算上其自身
- Border points：在core object的neighborhood中，但是其自身不是core object，即其自己的neighborhood内points数量达不到min-points
- Outliers：或者叫做noise points，即不在任何core points的neighborhood中的point

DBSCAN又有如下几个概念：
- Directly Density-Reachable：如果一个点p属于点q的neighborhood，并且q的neighborhood中的points大于等于min-points，即q是core point，p是q的neighborhood中的point，那么p is directly density-reachable from q
- Density-Reachable：对于点p和点q，如果两点之间有a chain of points is directly density-reachable可以连接起来，即q和p可以通过n1, n2, ..., ni+1个core points连接起来，其中n1是q，ni+1是p，nj-1与nj directly density-reachable，那么p is density reachable from q
- Density-Connected：如果有一个点o，从o出发，其与点p和点q都是density-reachable的，那么p is density-connected to q

DBSCAN的步骤如下：
1. 随机选取一个点p
2. 如果p是core point
    - 创建一个cluster并将p和其neighborhood中的所有points加入到cluster中
    - 检查neighborhood中的其它所有点，如果也是core point，就扩展neighborhood，重复此过程直到无法继续扩展
3. 如果p不是core point
    - 如果p是border point，那么将其归到所属的core point的cluster中
    - 如果p是outlier，将其标记，不归到任何cluster中
4. 重复以上步骤，直到所有points都被访问过

outlier detection和clustering高度相关但是不同，clustering是找到dataset中的majority patterns，而outlier detection是找exceptional cases；outlier detection可能是supervised，而outlier detection通常是unsupervised

outlier是与大部分objects差异很大的points，而noise相对来说差异没有那么大

novelty有时与outlier是等价的，所以novelty detection和outlier detection有很多共性，区别是，在novelty detection里，一旦novelty被confirm，那以后再出现这样的objects将会被认为是normal的

outlier有很多种类，global和local，contextual(conditional)和collective。global outlier是与所有objects都不相似的，local outlier在全局来看不是outlier，但是限定在其所在的一定范围内会发现它是outlier；contextual outlier是在一定的前提条件下才是outlier，对于contextual outlier detection，data objects有两个attributes，contextual和behavioral，contextual是定义condition的部分，behavioral是用于判断是否为outlier的values；collective outlier是单个的object不是outlier，但是一小部分objects组合在一起出现就是outliers

基于data labels可以将outlier detection methods分为supervised，unsupervised和semi-supervised，semi-supervised是需要一些labeled examples，这些examples数量通常较小

基于outlier和normal data不同的assumption，可以将methods分为statistical，proximity-based和reconstruction-based

statistical methods是基于given dataset得到一个generative的model，然后用model对需要检测的dataset的每个object进行判断，落在low-probability region的objects就是outliers

该方法又可细分为两类，parametric和nonparametric，parametric method假设normal data符合一个含有有限个parameters的distribution，用该distribution来计算likelihood，较低的就是outlier，而nonparametric method是直接基于input来构建一个model

这种方法的缺点是有些model的计算量较大，对高维的dataset效果不好

proximity-based methods是通过检测data points之间有多相似来进行outlier detection，如果一个point与大多数其他的data points都不相似，那么就被认为是outlier

这种方法基于不同的proximity measurement又可以分为两类，distance-based和density-based

distance-based主要考虑各个points之间的距离，如果一个point没有engough nearby points，那么就是outlier

nearby由distance threshold r决定，enough有fraction threshold Π决定。首先count在distance r范围内的points，如果count小于Π*total points的值，即nearby的points数量占整个dataset的比例小于一个threshold，那么就是outlier

最直接的方式是计算每一个point与其他所有points的距离，但是这种方式的计算量十分大，不过在实际应用中，这种方式并没有想象中的那么耗时，因为对每个point的计算过程都可以在得知它明显不是outlier后提早停止，而大多数的data points都是这样

算法的步骤如下：
1. 遍历每个data points
2. 对每个data points，计算与其他所有points之间的距离
3. 如果在计算过程中，小于distance threshold r的neighbors数量已经不少于Π个了，那么直接标记为不是outlier，并且停止剩余的计算
4. 如果对于一个point的计算结束了，还没有足够的neighbors，那么就标记为outlier

density-based是compare how crowded(dense) or empty(sparse) the neighborhoods are，如果所在的neighborhood较为sparse，那么就是outlier

这种方式中有几个重要的概念
1. k-distance of o，表示为distk(o)，是data point o与其第k相近的neighbor之间的距离。k-distance neighborhood，表示为Nk(o)，即与o之间的距离小于等于distk(o)的data points，由于可能有多个points与o之间的距离恰好等于distk(o)，所以k-distance neighborhood内可能有多于k个的objects
2. reachability distance，用于衡量两个objects有多远，但是其有一个lower limit "k-distance"，如果actual distance比k-distance要大，那么使用actual distance。对于两个objects o和o'，reachdistk(o <- o') = max{distk(o), dist(o, o')}，并且reachability distance不是对称的，即reachdistk(o <- o') ≠ reachdistk(o' <- o)
3. local reachiability density，简称为LRD，用于量化一个object与其最近的neighbors有多近，LRD越低，标明object与其最近的neighbors越远，那么越有可能是outlier。lrd(o) = |Nk(o)| / Σreachdistk(o' <- o)，其中o'属于Nk(o)
4. local outlier factor，简称为LOF，用于量化一个object相较于它的neighbors有多isolated，LOF通过比较object o的LRD和其他neighbors的LRDs进行计算。LOF(o) = Σ(lrd(o') / lrd(o)) / |Nk(o)|，其中o'属于Nk(o)，如果LOF>1，即object o is less dense than its neighbors，那么它就又可能是outlier；如果LOF=1，即object o has similar density as its neighbors，那么它是normal的，如果LOF<1，即object o is denser than its neiighbors，那么它肯定不是outlier

distance-based outlier detection是着眼于整个dataset去检测outliers，这种方式检测出来的outlier被称为global outlier；density-based outlier detection是基于一个更小的local area去检测outliers，这样检测出来的outlier被称为local outlier

isolation forest，简称为iForest。大多数anomaly detection approaches都是基于normal instance建立一个model，然后将不符合这个model的data认为是anomaly。这种方式的缺点是只适合低维度和较小的dataset，而iForest是假设anomalies是minority，并且anomalies的attributes与normal data差异极大，从而直接isolate anomalies，而不是基于normal instance建立model。这种方法不依赖于distance或者density，这样就极大的减少了计算量，所以复杂度是linear time complexity，并且memory requirement很低，而且对于较大和高维的dataset效果较好

基本思想是在sample space中通过随机split构建一个unsupervised decision tree，直到所有的instance都被isolated，由于anomalies与normal instance比起来更加isolated，所以它们会更加靠近root，而normal points会出现在deeper end。然后基于不同的samples去构建更多的iTree，这些iTrees组成iForest，计算每个data point的average oath length，并且赋予一个anomaly score，得分高的points就是outlier

算法的步骤是：
1. 随机选择一个feature，然后用一个随机的value进行split
2. 重复这个步骤，建立一个tree
3. 计算每个data point的path length
4. 在建立很多个trees后，计算average path length，并且assign anomaly scores

算法的key parameters是：
1. n_estimators：trees的数量
2. max_samples：建立每个tree所用到的samples数量
3. contamination：proportion of expected anomalies

由于每个tree的建立都是通过randomly sample来得到subset作为dataset，这样会增加diversity to the model，并且每个sample dataset中的data points都是不放回的从full dataset中选中的，即一旦一个data point被selected，那么它不会再出现在其他的sample dataset中了。这种sample的方法减小了每个tree的size，making the process computationalyy efficient，并且由于某些anomalies在更小的sample中可能会更突出，使效果更好

clustering-based methods是unsupervised，假设outliers属于small or remote clusters or none at all。有以下三种方法

approach 1，如果一个data object不属于任何cluster，那么它是outlier，可以使用DBSCAN

approach 2，如果一个data object与其最近的cluster之间的距离很大，那么它是outlier。通常使用k-means clustering，每个data points都有一个outlier-ness score，dist(o, Co) / l，其中Co是该cluster的center，l是该cluster中所有data points到center距离的平均值，score越高，那么越有可能是outlier

approach 3，如果一个data object属于一个small or sparse cluster，那么这个small cluster的所有data objects都是outlier。前面两个approaches都是通过compare individual data point to larger data clusters one by one，在large dataset中，一些outliers可能不是isolated，而是会形成它们自己的small clusters，FindCBLOF algorithm就是这个approach的一个实现

以下是FindCBLOF算法的步骤：
1. 首先将所有clusters以size排列为descending order，一个threshold α作为区分large和small clusters的参考，如果cluster中的data points数量大于dataset中objects数的α%，那么就是large，否则是small
2. 然后assign CBLOF scores
    - 对于large clusters中的data points，CBLOF score = (size of cluster) × (similarity between the point and the cluster)，即cluster中data points的数量与similarity的乘积
    - 对于small clusters中的data points，CBLOF score = (size of cluster) × (similarity between the point and the closest large cluster)，即cluster中data points的数量与最近的large cluster的similarity的乘积
3. 最后基于CBLOF score判断outliers，score越低的越有可能是outlier，因为这种points要么是在一个small cluster中，要么与其最近的large cluster距离很远

clustering-based outlier detection approaches的优点是unsupervised，对很多种data types都有效，并且速度较快；缺点是依赖于所使用的clustering method，并且对于large dataset，计算量较高