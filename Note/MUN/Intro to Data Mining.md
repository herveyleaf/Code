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