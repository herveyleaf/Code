# Pandas essentials

pandas的基础是数据框df(DataFrame)，一个df由如下几个部分组成

- 列标签
- 列数据
- 列数据类型
- 索引
- 元数据

pandas有三种函数来导入数据为df，并且可以通过url从网站上读取数据

- read_csv()
- read_excel()
- read_sql_query()
- read_pickle()

df有自己的构造函数DataFrame(params)，参数有data,columns,index

pandas有三种函数将df保存在硬盘上

- to_pickle()
- to_csv()
- to_excel()

head(rows)和tail(rows)函数显示前n行和后n行数据，如果不填写rows参数，则默认为5

对于一个df，它具有以下几个属性

- values：数组格式的值
- index：行索引
- columns：列的名字
- size：元素的总数
- shape：行列数

可以使用replace()函数对列名进行替换，例如df.columns = df.columns.str.replace()

info()函数返回df的一些信息，nunique()函数返回每列中唯一值的统计次数，describe()函数返回每个数字类型的列的统计数据

对于一列数据，可以以series访问，即使用df.column_anme，或者df[ column_name ]；也可以df访问，即df[[ columns_name ]] 。而多行数据是一定要以df访问

query()函数可以执行一些操作和运算，所以可以使用query()函数来访问指定条件的数据

loc[]和iloc[]可以通过指定行和列访问元素，loc[]是根据label，也就是行索引和列名称来进行定位，iloc[]是根据位置，也就是几行几列来定位

sort_values(columns, ascending)函数可以进行排序，columns可以接收一个列表来指定多个列，ascending默认为true，即正序排列，也可以接收一个列表进行混合排列

还有一些函数既可以作用于series，也可以作用于df，比如：count(),mean(),median(),min(),max(),std(),sum(),cumsum(),quantile(q)

python内置的数学运算符可以作用于df上，可以使用这些对列的运算的结果对df添加新的列，只需要指定一个不存在的列名并且赋值，对存在的列名赋值会修改原有的值

使用replace()函数对值进行修改则需要填写参数，replace()函数有两种形式：replace(to_replace, value, inplace)，其中to_replace和value可以为一个列表；replace(old, new)，直接指定存在的数据并且对其进行修改，其中可以使用字典对多个值进行修改

df的索引值默认是从0开始的整数，但是也可以通过set_index()函数来指定以某一列的值为索引，但是这样可能导致索引重复，需要指定verify_integrity参数为True，进行索引重复的检查。并且可以通过列表指定多个列为索引，称为多重索引

pivot()函数用来对数据集进行重塑，有三个参数，分别是index,columns,values，index用来指定某一列为索引，columns用来指定某一列的值为列标签，values指定某一列为值

melt()函数用来将宽度上的表现形式转换为在长度上的表现形式，有四个参数，分别是id_vars,value_vars,var_name,value_name，id_vars指定作为索引的列，value_vars指定要作为变量、取消透视的列，即将它们合并在一列，var_name指定变量列的列名称，value_name指定value列的列名称

groupby()函数将数据进行分组并进行组内运算，只有一个参数，即columns列名，可以是列表

agg()函数是聚合函数，将多个函数的执行结果聚合到一起

# Introduction to Data Mining

# Types of data

1. Record Data
2. Graphs and Networks
3. Ordered Data
4. Spatial, image and multimedia Data

##  Data Objects

数据集由数据对象组成，一个数据对象，也可以称为样本，代表一个实体，例如：
- 销售数据库：顾客、商品、售卖
- 医疗数据库：病人、治疗方案
- 大学数据库：学生、专业、课程

数据对象由它的属性描述，所以整体结构是：数据库的每一行→数据对象→属性

## Attributes

属性，也称为维度或者变量，描述一个数据对象的特征，例如客户id，名字，地址

## Attribute Types

### Nominal

标称属性，每个值代表某种类别、编码或状态，又被看作是分类用的属性，这些属性没有特定的意义，不是定量，例如头发的颜色 = {黑色，棕色，金色，白色}

### Binary

二元属性，只有两个状态，0和1

### Ordinal

序数属性，取值可以由有意义的序来评定，但是相继值的差是未知的，例如成绩= {优，良，中，差}，不能比较每个取值之间差别是怎样的

### Numeric

数值属性是可以度量的，用整数或者实数值来表示，有区间标度和比率标度两种类型

#### Interval

区间标度用相等的单位尺度度量，区间属性的值是有序的，所以可以进行定量比较，例如身高。区间标度是没有真正零点的，比如温度，可以计算温度的差距，但是不能说10°比5°温暖两倍

#### Ratio

比率标度的度量是按比率的，可以用比率来比较两个值，即一个值是另一个值的倍数，也可以计算每个值之间的差，比如开氏温度是有绝对零点的，还比如工龄和字数等计数的属性，所以比率标度是有真正零点的

### Discrete & Continuous

具有有限或者无限个可数的值，比如学生成绩属性。如果一个属性的取值是无限的，但是可以与自然数建立一个一一对应的关系，那么也是离散属性。如果一个属性不是离散的，那它就是连续的

# Statistics of Data

1. Mean

    样本均值、整体均值、权重均值、截尾均值(掐头去尾取平均)

2. Median

    如果中位数是两个数那就取均值，对于分组的值可以用估计中位数的公式：median = L1 + ((n/2 - (Σfreq)l) / (freq)median) * width

    L1是中位数所在区间的下限，(freq)l是中位数区间之前的频率之和，width是中位数区间的宽度

3. Mode

    对于众数的数量不同，有单峰分布、双峰分布、三峰分布，对于图像的形态，有正态分布、偏态分布等等

    对于偏态分布，如果数据分布的图像中右边的观测值较少，称为正偏态分布，如果左边的观测值较少，称为负偏态分布

# More Statistics

## Correlation Analysis

chi-square test

χ^2 = Σ((Oi - Ei)^2 / Ei)

null hypothesis是两个变量是独立的，对χ^2值贡献最大的cell与期望的差距非常大，χ^2越大，那么变量相关的可能性越高

degree of freedom是指可以随意改变的、不受限制的变量，对于a + b = 6，那么自由度为1，因为一旦一个变量确定了，另一个变量就也确定了

## Variance and Covariance

### Variance

平方的期望E(x^2)是Σ(x^2)*p，方差的公式是E(x^2) - E(x)^2

### Covariance

协方差的公式是E(x1x2) - E(x1)*E(x2)

如果x1和x2是相互独立的，那么协方差σ12=0，但协方差等于0不代表x1和x2相互独立

## Correlation

相关度的公式是ρ12 = σ12 / (σ1 * σ2)

如果相关度大于0，那么x1和x2正相关，如果小于0则负相关，等于0时则相互独立

## Covariance Matrix

## Graphic Display

### Boxplot

Box代表数据的中间50%，即Q1到Q3的范围，Box内部的线表示Median(Q2)；Whiskers是从Box延伸出来的两条线，分别延伸至数据集的最大值和最小值，但不包括Outliers，Outliers是落在Box外的单独点，定义为超过Q1-1.5IQR或者Q3+1.5IQR的值

### Histogram

直方图显示列表形式的频率，图像类似柱状图，histogram和bar chart的区别是histogram被用于表现一个变量的值的分布，而bar图用于比较不同变量；histogram

histogram通常展现比boxplot更多的信息，因为对于两组数据，它们可能有同样的min,Q1,median,Q3,max，这样画出来的boxplot就是一样的，但是它们的分布可能不一样

### Quantile Plot

将所有百分位的数据画出来

### Quantile-Quantile Plot

两个轴为两组数据的百分位，进行对照

### Scatter plot

散点图

# Similarity Matrix

## Motivation

Patter Mining, Clusting, Outlier Detection

## Dissimilarity

Dissimilarity(Distance) matrix是用来衡量两个数据之间的距离d(i,j)，且d(i,j) = d(j, i)

### Numeric Distance Metrics

- Manhattan distance：不同维度的直线距离的绝对值相加，即|xi1 - xj1| + ... + |xil - xjl|
- Euclidean distance：欧氏距离，根号下不同维度直线距离的平方之和

### Standardizing Numeric Data

Z-score：z = (x - μ) / σ

min-max：y = ((x - min)/(max - min)) * (new_max - new_min) + new_min

x是待处理的原始数据，μ是均值，σ是标准差，标准化的目的是让所有维度的数据都处在同一衡量尺度下，避免某一维度数据巨大导致距离的权重失衡

### Proximity Measure

#### Binary

sum of (1, 1) = q, (1, 0) = r, (0, 1) = s, (0, 0) = t

对于对称数据来说，d(i,j) = (r + s) / (q + r + s + t)

对于不对称数据来说，d(i,j) = (r + s) / (q + r + s)，去掉了(0, 0)这个over-represented的数据，如果是(1, 1)这个数据over-represented的话，那就去掉q

对于不对称数据的的相似性，sim(i,j) = q / (q + r + s)，也是去掉了(0, 0)这个数据，但不是因为over-represented

对于一组数据，计算公式要选同一个，不能因为某些数据对是对称的/不对称的，就更换计算公式

#### Categorial

也叫做nominal类型

1. Simple matching

    m：匹配的变量的数量，p：变量的总数量

    d(i,j) = (p - m) / p

    对于单个变量之间的距离，相同就是1，不相同就是0

2. One-hot encoding

#### Ordinal

将ordinal变量根据rank排序进行1 2 3 ... M的编号，然后通过zif = (rif - 1) / (Mf - 1)将其映射在0到1的范围内，这样一个类型的变量，各个值之间的距离就可以计算出来，再通过计算numerical类型的方法来计算

#### Mixed

d(i,j) = (∑ δij * dij) / ∑ δij

其中δ的值为0或1，若数据i和j在某一个变量缺少值，即不能计算距离，那么就取0，如果可以计算距离，就取1，而d就是某个变量之间的距离，根据变量的类型来选择计算公式

### Cosine Similarity

计算两个向量之间的cosine值，cos(d1, d2) = (d1 · d2) / ||d1|| × ||d2||

# Data Normalization

## Min-Max Normalization

将原数据的范围转换为[new_min, new_max]

假设原数据为v，公式是v' = (v - min) * (new_max - new_min) / (max - min) + new_min

## Z-score Normalization

公式为v' = (v - μ) / σ，其中μ是均值，σ是标准差

## Normalization by Decimal Scaling

v' = v / 10^j

根据需要将原数据的范围转换到-1到1

# Dimension Reduction

有两种数据降维方法

- Feature selection：找到一个可以保留大部分信息的数据子集
- Feature extraction：将数据从原本的高维度转换到更少维度

## PCA

PCA的目标是在保证最重要的信息保留的情况下减少变量数，即维数

通过构建新的PCA变量来获取原数据的关键信息，构建的方法是

- 原变量的线性组合
- 根据重要性的程度来进行排序

### Steps

1. Normalize Data：将数据转换为统一范围，避免过大的数值导致重要性失衡
2. Compute Principal Components：找到k个保留最多原数据信息的正交的向量
3. Sort Principal Components：重要性最高的component表示保留了最多的信息量，第二高的表示保留了第二多的信息量，以此类推
4. Reduce Data：舍去保留较少信息的components，用剩余的components来描述数据信息

## Attribute Subset Selection

目标是通过减少无关或冗余的属性来降低数据的维数

但是选择合适的属性是十分耗费时间的，尤其是在对数据没有太多了解时，并且使用错误的属性会导致数据挖掘的低质和低效

一般通过heurisic methods，即试探法来选择good sbuset，并且可能得到全局最优解

### Decision Tree

可以通过决策树来选取所需的属性

从所有数据的根节点开始，选取best attribute来将原数据切分成一个子集，best通常表示这个属性可以很好的区分不同的类别，重复这个步骤，直到遍历了决策树的所有结论

对于一个决策树，任何一个出现在其中的属性都是与你的任务相关的，没有出现在决策树当中的属性被认为是不相关的

#### Steps

1. Load the Data
2. Preprocessing：处理缺失值，对类别型变量进行编码
3. Decision Tree：基于数据集训练一个decision tree model
4. Feature Importance：从训练出的决策树模型中导出各个属性的重要性
5. Subset Selection：基于属性的重要性来选择subset

## Nonlinear Dimensionality Reduction Methods

PCA是一种线性的降维方法，每一个principal component是原数据的属性的线性组合，对于线性不可分的数据集，PCA对其不起作用

### General Steps for Nonlinear Methods

1. Constructing Proximity Matrix：建立一个临近度矩阵来计算每个数据点与其他数据点的相似性
2. 根据这个临近度矩阵来创建一个新的、维数更低的representation，这个新的representation应当尽可能的保持原数据的关系，即临近度

### KPCA and SNE

- KPCA(Kernel PCA)
    - 用一个kernel function来计算每一对数据点之间的相似度
    - 在计算结束后，KPCA试图在一个低维的空间维持这个相似度

- SNE(Stochastic Neighbor Embedding)
    - 通过其他方法建立临近度矩阵
    - 类似KPCA，SNE也将在一个低维的空间维持这个临近度

# Pattern Mining

## Basic Concepts

patterns是某些item在数据集中经常同时出现，patterns是datasets固有的、重要的属性，是itemset

- itemset是一个含有1个或多个items的集合，比如I = {I1, I2, ..., Im}
- k-itemset是一个含有k个items的集合
- absolute support(count)是一个itemset X在数据集中出现的次数，比如sup{X} = 3，即X在数据集中出现3次
- relative support是itemset X在数据集中出现的比例，比如s{X} = 60%，即60%的数据中都包含X
- frequent itemsets(patterns)，如果一个itemset的support不小于minsup threshold σ，那么这个itemset就是frequent itemset，比如如果σ = 50%，那么support大于等于50%的都是frequent itemset
- association rules，表示A -> B，即A会导致B发生
    - confidence，即条件概率，c = sup(X, Y) / sup(X)

association rule mining的步骤有两步
1. 找到所有的frequent itemsets，这一步的计算量非常大，这种mining的性能由这一步决定
2. 根据frequent itemsets生成strong association rules，要满足minsup和mincon，这一步又可以分为如下两步
    - 列出每个frequent itemset l的非空子集
    - 对于每个非空子集s，根据公式s -> (l - s) if sup_count(l) / sup_count(s) >= mincon得到association rules

对于一个较大的数据集，会有过多的frequent patterns，不可能全部储存起来，对于这种情况有两种解决方法
1. closed patterns

    一个pattern X是closed，如果X是frequent itemset，并且X不是任何一个跟X具有相同support的itemset的子集

    closed pattern是lossless compression，可以减少pattern数，但是不丢失任何support information

2. max-patterns

    一个pattern X是max-pattern，如果X是frequent，并且X不是任何一个frequent itemset的子集

    max-pattern是lossy compression，只能知道itemset是frequent的，但是不知道子集的具体support

## Apriori Algorithm

对于一个frequent itemset，它的所有subset都是frequent的，这就是downward closure(Apriori) property，所以可以得到一个高效的mining思想，如果itemset S的任何一个subset是infrequent，那么S不可能是frequent，所以就不需要关注S了

### Approach

- scan DB所有的1-itemset得到candidates，选取candidates中的frequent 1-itemset
- repeat，根据上一步的frequent k-itemset来生成k-item candidates，选取frequent (k+1)-itemset
- 直到无法生成(k+1) candidates或者candidates中没有frequent itemset

### Pro/Con

这种算法的优点是易于实现，利用了large itemset property，但是缺点是假设DB可以驻留在内存中

## FP-growth Algorithm

即frequent pattern growth，克服了apriori算法的缺点，比如生成太多的candidate sets，需要重复扫描整个DB等，FP-growth算法不需要生成candidate，而是将数据压缩到一个较小的结构中，效率更高。apriori算法是广度优先的，而FP-growth是深度优先的

### Approach

- 扫描一次DB，得到所有的frequent 1-itemsets
- 将所有的frequent 1-itemsets按从大到小排列
- 再次扫描DB，将每一条数据改写成ordered frequent itemlist
- 根据改写的itemlist，构建一个FP-tree
    - 将每条数据依次以树的形式写出来，每有一个新的顺序，就建立一个分支
- 对每一个frequent item，列出一个conditional database of pattern，根节点上的item不计入
- 通过conditional pattern database来构建conditional FP-tree，也需要满足minsup
- 最后根据FP-tree得出frequent patterns

## Pattern Evaluation

pattern-mining会产生很多patterns，但不是所有的patterns都是有用的，有两种类别的方法来判断

- Objective Measures
    - Support：过一个pattern出现的频率
    - Confidence：通过一些items在一个rule中有多少次一起出现
    - Correlation
- Subjective Measures
    - Relevance：是否与user的需求有关
    - Unexpectedness：pattern是否显现出一些出人意料的knowledge
    - Freshness：是否是新的information
    - Timeliness：是否是与当下有关的

有时Strong Association Rules其实是misleading的，比如一个10000条数据的DB，6000条包含A，7500条包含B，4000条同时包含A和B，这时如果考虑rule {A} -> {B}，support是40%，confidence是66%，如果min_sup是30%，min_conf是60%，那么这就是一个strong rule，这就是misleading的，因为P(B)是75%，大于confidence，所以其实A和B是negatively associated，因为购买A其实降低了购买B的可能

从以上的例子可以看出，support和confidence其实是insufficient的，所以可以在measure中加入correlation

### Lift

Lift(A, B) = s(A, B)/(s(A)*s(B)) = P(A∪B)/P(A)P(B)

如果lift(A, B) = 1，那么A和B是不相关的，如果>1，那么是正相关，如果<1，那么是负相关

### χ2

还可以用卡方分析的方法来判断是否相关，通过计算卡方值和查表来判断是否相关，然后通过计算出来的期望值和实际值比较来判断是正相关还是负相关

### Null-Invariance

null transaction就是neither A nor B，有时如果null transaction过多，那么得到的结论就不是很好，比如如果A和B同时出现的transaction只有100，A或B有1000，而A和B都不出现的有10000，那么用lift和卡方分析得到的结论都是A和B是强正相关的，但是数据上来看其实二者很少同时出现

有一些measure是不受null transaction影响的，这些measure就是null-invariance，而受影响的就不是，卡方分析和lift就不是null-invariance

不是null-invariance的方法就不适合应用于有过多或者过少null transaction的数据

# Clustering

## Basic concepts and Methods

clustering是unsupervised learning，groups是未知的，而classification是supervised learning，用已知的labels去训练一个model

common algorithms有：
- K-means, K-medoids
- agglomerative clustering
- density based clustering

### Requirements for clustering analysis algorithms

- Ability to handle different types of data
- scalability(handle large datasets)
- discovering clusters with arbitrary shapes
- reducing the need for domain knowledge
- robustness to noisy data

### Overview of Basic Clustering Methods

#### Partitioning Methods

将dataset的n个objects分为k个clusters，k由user指定

像k-means和k-medoids算法会step by step的得到一个good enough的结果，但是这些算法只在roughly spherical in shape的数据作用较好，而在complex or irreguar shapes的数据中效果不佳

#### Hierarchical Methods

建立一个tree-like的cluster structure，有agglomerative(bottom-up)或divisive(top-down)两种方向

这种方式的缺点是，一旦作出了决定，就不能回头了，也就是说error不能被修正

#### Density-Based and Grid-Based Methods

寻找densely packed together的data points

density-based clustering根据number of points in a neighborhood进行cluster，可以对任意shape的数据进行cluster，不像partitioning methods一样只对spherical shape有效，并且可以分辨出noise和outliers

grid-based clustering将data space分为a grid of cells，个悲剧density of points in the cells进行cluster，这种方法十分迅速

## K-Means

首先user指定the number of clusters k，然后在dataset的n个objects中随机选出k个objects作为initial cluster centers，再通过计算剩下的每个objects与cluster centers的euclidean distance，将the most similar objects放到对应的cluster中，然后update cluster centers，重复这个步骤直到no change

由于initial centroids are chosen randomly，所以运行多次可能会得到多个不同的结果

centroids通常是the mean of the points in the cluster

复杂度是O(n * k * t)，n是number of iteration

### Pre Processing and Post Processing

- pre-processing
    - normalize data
    - remove outliers：避免skewing of cluster centers
- post-processing
    - eliminate small clusters：可能是noise
    - split loose clusters：对于SSE高的cluster，将其划分为更小的clusters
    - merge close clusters：降低SSE

### Challenges

k-means可能达不到global optimum，通常是得到一个local optimum，并且initial cluster center会影响到结果

### Sum of Squared Error(SSE)

对于每个point，error是the distance to the nearest cluster

所以SSE = ΣΣ dist^2(x, ci) = ΣΣ (||x - ci||^2)

x是cluster Ci中的一个data point，ci是Cluster Ci的center，所以SSE就是每个data point与其cluster center的距离的平方和

对于两个clusters，SSE小的cluster更优

减小SSE最简单的方法就是增加k，而一个good clustering with smaller K的SSE可能比poor clustering with larger K要高，当k = n时，SSE是0

## Improvements to k-means algorithm

### K-Means++

K-Means is sensitive to initialization

不同的initialization可能得到相当不同的clustering result，所以original proposal select K seeds randomly and run multiple times

k-means++相较randomly select centroids会更慢一些，但是结果更好，尤其是在降低SSE这方面

算法的步骤是：
1. First Centroid：choose one initial point randomly
2. Remaining Centroid：对于剩下的k-1个centroids
    - 对于dataset中的每一个point，计算其与距离最近的centroid之间的距离
    - randomly pick the next centroid，with a probability that is proportional to the square of the distance to the nearest centroid，与任何一个centroid距离都较远的point有更高的概率被选中，有助于spread them out
3. 重复步骤2直到有k个centroids被选中

基于概率进行centroid的选择让算法更加balanced and robust，可以避免选中outlier作为centroid，并且避免deterministic patterns

与常规的k-means相比，k-means++ is generally preferred，因为即使用到其它的advanced initialization strategies，k-means++ is generally the best；同时，k-means++ has better quality guarantee than k-means；在实际应用中，k-means++比k-means的速度和质量都要更优秀

k-means在clusters are differing sizes, densities, non-globular shapes时会出现问题，并且dataset包含outliers时也会有问题

### K-Medoids

k-means is sensitive to outliers

k-means基于averaging points in each cluster计算the center of clusters，所以outliers肯能会pull the average toward them

k-medoids是k-means的变种，设计的初衷就是reduce sensitive to outliers

instead of using the mean，k-medoids从dataset中selects an actual point作为center(medoid)，每个data point都被assigned to the cluster with the closest medoid，这样可以最小化absolute-error，即total distance from each point to its closest medoid

当k=1时，复杂度是O(n^2)，而当k是general positive number时，k-medoid problem是NP-hard

#### Partitioning Around Medoids(PAM)

PAM iis a popular way to perform k-medoids clustering，PAM的每一次decision-making都是即时的，基于cost的，不会考虑到全局最优，所以这是一种贪心算法，这也意味着PAM不能保证得到optimal solution，但是这也让k-medoid这个NP-hard问题有了一个实际的operation

PAM的步骤如下：
1. Initialization：随机选取k个objects作为initial medoids
2. Assignment：assign每个non-medoid object到距离其最近的medoid来形成clusters
3. Swap Evaluation：随机选取k个non-medoid objects o_random
    - calculate the cost of swapping each medoid with o_random
    - 如果swapping reduces the overall clustering cost(measured by a change in abolute error)，那么就perform the swap
4. 重复步骤2和3直到没有swaps improve the cost

k-mediods clustering就是找到representative objects，即medoids

PAM则是从initial set of medoids开始，并且iteratively replaces one of the medoids by one of the non-medoids，PAM对于较小的dataset的效果较好，而对于较大的dataset则不是很好，因为算法的复杂度很高

### K-Medians

medians are less sensitive to outliers than means

这种算法先随机选择k个points作为initial representative objects，然后assign every point to its nearest median，并且重新计算每个cluster的median，重复以上两步，直到criterion function收敛

### K-Modes

k-means不能处理categorical data，而k-modes则是用modes替换means以扩展可处理的数据类型

distance通过dissimilarity between object X and the center of a cluster Z来计算，并且这个算法也是会迭代并进行centroid update的

a mixture of categorical and numerical data, using K-Prototype method

## Hierarchical methods

hierarchical methods分为两类，agglomerative和divisive，前者是自底向上的，最终得到一个cluster，后者是自顶向下的，最终每个object都会自成一个cluster，agglomerative在实际应用中更加popular

### Agglomerative

基本思想是建立一个tree，初始状态时每个object作为一个独立的cluster，然后找到最相近的两个cluster，合并为一个新的cluster，重复这个步骤直到所有object都合并到一个cluster中，这时整个过程就呈现出一个树状的结构，然后user指定需要几个clusters

这种方法的优点是不需要像k-means一样预先指定需要多少个clusters，而是在做完所有步骤后根据user需求自行split，缺点则是这种方法是没有going back的，即将两个cluster合并为一个新的cluster后，不会再将两个sub cluster分开重新与其他的cluster合并，一旦做出决定就不会进行修正了。这种方法是deterministic的，在不更改参数的前提下，即使多次运行，得到的结果也始终是一样的

#### Similarity Measure

不同的similarity measure会得到不同的merge结果，两个clusters之间的距离可以基于minimum distance, maximum distance, mean distance, average distance，每种不同的计算方式对结果的影响都是不同的

如果使用minimum distance，这时叫做single-linkage algorithm，即根据两个clusters之间距离最近的points之间的距离进行join判断；如果使用maximum distance，这时叫做complete-linkage algorithm，根据两个clusters之间距离最远的points之间的距离进行join判断。与k-means算法一样，single-linkage和complete-linkage都是sensitive to outrilers，可以使用mean或者average distance进行计算来避免outlier的影响

GAAC和centroid clustering在distance calculation的公式是相同的，但是GAAC是考虑要合并的两个cluster中的所有pairs，包括原本就在同一个cluster的两个points，以所有pairs之间的距离的平均值作为两个clusters之间的距离，所以GAAC的计算量非常大；而在centroid clustering中，则是排除了原本处在同一个cluster的pairs，以两个clusters的质心之间的距离作为clusters之间的距离，计算量减少

Ward's criterion则是与partitioning methods中最小化SSE的思想一样，即每次进行merge时，选择两个合并后的SSE最小的cluster进行合并，在所有的similarity measure中，ward's criterion的效果是最好的

## Density-based Clustering methods

traditional clustering techniques struggle with non-spherical, arbitrary shapes，此时partitioning和hierarchical methods就不适用了

而density-based methods则可以discover non-spherical clusters，identify complex-shaped clusters

### DBSCAN

核心思想是identify dense region to form clusters，这里有两个参数，ε和min-points，ε是neighborhood的半径大小，而min-points是衡量一个point是否为core point，如果neighborhood中的points数量不小于min-points，那么就是core point

DBSCAN中的每个points可以分为以下几类

- Core Object：neighborhood中有不低于min-points的points的object，统计neighborhood中points时要算上其自身
- Border points：在core object的neighborhood中，但是其自身不是core object，即其自己的neighborhood内points数量达不到min-points
- Outliers：或者叫做noise points，即不在任何core points的neighborhood中的point

DBSCAN又有如下几个概念

- Directly Density-Reachable：如果一个点p属于点q的neighborhood，并且q的neighborhood中的points大于等于min-points，那么p is directly density-reachable from q
- Density-Reachable：对于点p和点q，如果两点之间有a chain of points is directly density-reachable可以连接起来，那么p is density reachable from q
- Density-Connected：如果有一个点o，与点p和点q都是density-reachable的，那么p is density-connected to q

DBSCAN的步骤如下

1. 随机选取一个点p
2. 如果p是core point
    - 创建一个cluster并将p和其neighborhood中的所有points加入到cluster中
    - 检查neighborhood中的其它所有点，如果也是core point，就扩展neighborhood，重复此过程直到无法继续扩展
3. 如果p不是core point
    - 如果p是border point，那么将其归到所属的core point的cluster中
    - 如果p是outlier，将其标记，不归到任何cluster中
4. 重复以上步骤，直到所有points都被访问过

# Outlier Detection Introduction

## Outlier Detection vs Clustering

两个高度相关但是不同的tasks

- differnece in purpose
    - clustering finds the majority patterns in dataset
    - outlier detection capture exceptional cases that deviate from the majority patterns
- difference in methodology
    - outlier detection might also use supervision
    - clustering is typically unsupervised

## Outlier vs Noise

outlier is a data object that deviates significantly from the rest of the objects, as if it were generated by a different mechanism

noise is a random error or variance in a measured variable thus is not interesting

## Outlier Detection and Novelty Detection

novelty may initially appear as outliers, to this extent, outlier detection and novelty detection share some similarity in modeling and detection methods

difference: in novelty detection, once new topics are confirmed, they are usually incorporated into the model of normal behavior so that follow-up instance are not treated as outliers anymore

## Types of Outliers

### Global Outliers

a data object is global outlier if it deviates significantly from the rest of the dataset, it's the simplest type of outliers

most outlier detection methods are aimed at finding global outliers

### Contextual(Conditional) Outliers

in a given dataset, a data object is a contextual outlier if it deviates significantly with respect to a specific context of the object

for example, "it's 28 degree today" is exceptional if today is in winter, but not if today is in summer

contextual outlier detection has to specify the context as part of the problem definition

#### Contextual Attributes vs Behavioral Attributes

in contextual outlier detection, the attributes of data objects are divided into two parts: Contextual and Behavioral

- Contextual: define the object's context(condition), in example above, date and location may be

- Behavioral: define the object's characteristics(value), to evaluate whether the object is an outlier or not, in example above, temperature may be

#### Contextual Outliers vs Global and Local Outliers

contextual outliers are a generalization of local outliers

global outlier detection can be regarded as a special case of contextual outlier detection where the set of contextual attributes is empty

### Collective Outliers

given a dataset, a subset of data objects forms a collective outlier if the objects as a whole deviate significantly from the entire dataset, while importantly the individual data objects may not be outleirs

for example, a student is sick in a class may not be outlier, but 10% of students sick are sick on a single day may be outlier

### Comparison

a dataset can have multiple types of outliers, an object may belong to more than one type of outlier

global outlier detection is the simplest

context outlier detection requires background information to determine contextual attributes and contexts

collective outlier detection requires background information to model the relationship among objects to find groups of outliers

## Overview of Outlier Detection Methods

### Categories Based on Data Labels

- supervised: this kind of methods model data normality and abnormality, which can handle imbalanced classes

- unsupervised: this kind of methods make an implicit assumption that the normal objects are somewat "clustered"

- semi-supervised: this kind of methods obtain some labeled examples, but the number of such examples is often small

### Categories Based on Assumption about Outliers vs Normal Data

- Statistical methods(model-based methods): make assumption of data normality, normal data follows a probabilisitc model

- Proximity-based methods: assume that an object is an outlier if the nearest neighbors of the object are far away

- Reconstruction-based methods: matrix-factorization based methods and pattern-based compression methods. The normal data samples often share certain similarities

# Statistical Approaches

## General Idea

基于given dataset来得到一个generative的model，落在low-probability region的objects就是outlier

statistical approaches又可以分为两类，parametric method和nonparametric method，parametric method假设normal data object是符合一个含有有限个parameters的distribution；而nonparametric method则是基于input data来决定model

## parametric method

假设data服从某个distribution，然后使用该distribution来计算所有data的likelihood，如果过低的话，那么就是outlier

## nonparametric method

用已有的dataset来训练model，然后再将需要判断的data输入到model中进行判断

比如为已知的dataset画出histogram然后得到每个value出现的可能性，然后根据这个可能性和某个function去计算outlier score，如果score较高，那么就是outlier

## Pros and Cons

优点是outlier detection may be statistically justifiable，缺点是有些model的计算量较大，对于高维的data效果不好

# Proximity-based Approaches

这种方式是通过检测data points之间有多相似进行outlier detection，如果一个point与大多数其他的data points都不太相似，那么就被认为是outlier

proximity-based methods可以分为两类，distance-based和densitybased

## Distance-based

这种方式主要考虑各个points之间的距离，如果一个point没有engough nearby points，那么就是outlier

nearby由distance threshold r决定，enough有fraction threshold Π决定

首先count在distance r范围内的points，如果count小于Π*total points的值，那么就是outlier

最直接的方式是计算每一个point与其他所有points的距离，但是这种方式的计算量十分大，不过在实际应用中，这种方式并没有想象中的那么耗时，因为对每个point的计算过程都可以在得知它明显不是outlier后提早停止，而大多数的data points都是这样

### algorithm

1. 遍历每个data points
2. 对每个data points，计算与其他所有points之间的距离
3. 如果在计算过程中，小于distance threshold r的neighbors数量已经不少于Π个了，那么直接标记为不是outlier，并且停止剩余的计算
4. 如果对于一个point的计算结束了，还没有足够的neighbors，那么就标记为outlier

## Distance-based vs Density-based

distance-based outlier detection是着眼于整个dataset去检测outliers，这种方式检测出来的outlier被称为global outlier

density-based outlier detection是基于一个更小的local area去检测outliers，这样检测出来的outlier被称为local outlier

## Density-based

这种方式是compare how crowded(dense) or empty(sparse) the neighborhoods are

### k-Distance

k-distance of o，表示为distk(o)，是data point o与其第k相近的neighbor之间的距离

k-distance neighborhood，表示为Nk(o)，即与o之间的距离小于等于distk(o)的data points，由于可能有多个points与o之间的距离恰好等于distk(o)，所以k-distance neighborhood内可能有多于k个的objects

### Reachability Distance

it's a way to measure how far away two objects are, but it has a lower limit "k-distance"，如果actual distance比k-distance要大，那么使用actual distance

对于两个objects o和o'，reachdistk(o <- o') = max{distk(o), dist(o, o')}，并且如果reachability distance不是对称的，即reachdistk(o <- o') ≠ reachdistk(o' <- o)

### Local Reachiability Density

简称为LRD，用于量化一个object与其最近的neighbors有多近，LRD越低，标明object与其最近的neighbors越远，那么越有可能是outlier

lrd(o) = |Nk(o)| / Σreachdistk(o' <- o)，其中o'属于Nk(o)

### Local Outlier Factor

简称为LOF，measure how isolated an object o is relative to its neighbors，LOF通过比较object o的LRD和其他neighbors的LRDs进行计算

LOF(o) = Σ(lrd(o') / lrd(o)) / |Nk(o)|，其中o'属于Nk(o)

如果LOF>1，即object o is less dense than its neighbors，那么它就又可能是outlier；如果LOF=1，即object o has similar density as its neighbors，那么它是normal的，如果LOF<1，即object o is denser than its neiighbors，那么它肯定不是outlier

# Isolation Forest

anomalies即data characteristic与normal instance不同，大多数anomaly detection approaches都是基于normal instance建立一个model，然后将不符合这个model的data认为是anomaly。这种方式的缺点是只适合低维度和较小的dataset

isolation forest，简称为iForest，是直接isolate anomalies，而不是基于normal instance建立model。这种方法不依赖于distance或者density，这样就极大的减少了计算量，所以复杂度是linear time complexity，并且memory requirement很低，而且对于较大和高维的dataset效果较好

iForest假设anomalies are the minority and consist of fewer instances，并且anomaies have attribute values that significantly different from normal instance

## Basic Idea

construct a unsupervised decision tree which randomly partition the sample space with binary split until every single distance is isolated. Call this tree as iTree

由于anomalies与normal instance比起来更加isolated，所以它们会更加靠近root，而normal points会出现在deeper end

然后基于不同的samples去构建更多的iTree，这些iTrees组成iForest，计算每个data point的average oath length，并且赋予一个anomaly score，得分高的points就是outlier

## Basic Algorithm

1. 随机选择一个feature，然后用一个随机的value进行split
2. 重复这个步骤，建立一个tree
3. 计算每个data point的path length
4. 在建立很多个trees后，计算average path length，并且assign anomaly scores

iForest的几个key parameters是
1. n_estimators：trees的数量
2. max_samples：建立每个tree所用到的samples数量
3. contamination：proportion of expected anomalies

## Features

每个tree的建立都是通过randomly sample来得到subset作为dataset，这样会增加diversity to the model

每个sample dataset中的data points都是不放回的从full dataset中选中的，即一旦一个data point被selected，那么它不会再出现在其他的sample dataset中了

这种sample的方法减小了每个tree的size，making the process computationalyy efficient，并且由于某些anomalies在更小的sample中可能会更突出，使效果更好

# Clustering-based Approaches

## Clustering-based vs Classification-based

clustering-base是unsupervised methods，并且是基于data objects和clusters之间的关系进行判断，outliers属于small or remote clusters or none at all

classification-based是supervised methods，treat outlier detection as a classification problem，通过labeled data来训练模型，然后使用模型对outliers和normal data进行区分

## Three Clustering-based Approaches

### approach 1

如果一个data object不属于任何cluster，那么它是outlier

可以使用DBSCAN

### approach 2

如果一个data object与其最近的cluster之间的距离很大，那么它是outlier

通常使用k-means clustering，每个data points都有一个outlier-ness score，dist(o, Co) / l，其中Co是该cluster的center，l是该cluster中所有data points到center距离的平均值，score越高，那么越有可能是outlier

### approach 3

如果一个data object属于一个small or sparse cluster，那么这个small cluster的所有data objects都是outlier

前面两个approaches都是通过compare individual data point to larger data clusters one by one，在large dataset中，一些outliers可能不是isolated，而是会形成它们自己的small clusters

FindCBLOF algorithm就是这个approach的一个实现

#### FindCBLOF

1. 首先将所有clusters以size排列为descending order，一个threshold α作为区分large和small clusters的参考，如果cluster中的data points数量大于dataset中objects数的α%，那么就是large，否则是small
2. 然后assign CBLOF scores
    - 对于large clusters中的data points，CBLOF score = (size of cluster) × (similarity between the point and the cluster)，即cluster中data points的数量与similarity的乘积
    - 对于small clusters中的data points，CBLOF score = (size of cluster) × (similarity between the point and the closest large cluster)，即cluster中data points的数量与最近的large cluster的similarity的乘积
3. 最后基于CBLOF score判断outliers，score越低的越有可能是outlier，因为这种points要么是在一个small cluster中，要么与其最近的large cluster距离很远

## Pros and Cons

clustering-based outlier detection approaches的优点是unsupervised，对很多种data types都有效，并且速度较快；缺点是依赖于所使用的clustering method，并且对于large dataset，计算量较高