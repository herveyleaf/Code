# Cellular Automata Part One

## Cellular Automata(CA)

- 一个 Cellular Automata包含一个可以是任何多维度的grid of cells
- 每个cell在任一一个确定的时间有一个确定的状态，有defined neighbourhood of other cells
- 迭代规则描述cell如何改变状态，且状态的变化是基于当前cell自身和neighbouring cells的状态

## Elementary Cellular Automata

一个简单的一维的line of cells，8个cells，只有两种状态0和1，每个cell neighbourhood包含自身和左右两边的两个cells

### Transition Rules

CELL state at time t = f(CELL neighbourhood at time t-1)

Transition Rules定义了任何可能的neighbourhood的下一次迭代会是什么状态

对于Elementary Cellular Automata，有256种rules，组成一个8位的二进制数，二进制数转换为对应的十进制数，则相应的每种规则称为Rule XX(如Rule 90)

### Sensitivity to Initial Conditions

Cellular Automata的迭代过程是由迭代规则和最初的状态同时决定的，有些规则永远导致下一次迭代情况可以预测，无论最初状态是什么样子；但是有些规则而却对最初条件很敏感

### Walfram Classification

Wolfram通过直接观察的方法将所有规则分为4类

1. Uniformity

    在经过一定次数的迭代后，所有cell的状态将保持不变

2. Repetition

    在经过一定次数的迭代后，所有的cell状态将保持有规律的变化

3. Random

    cell状态没有确定的状态

4. Complexity

    cell状态将表现出一些复杂的性质

Random和Complexity的区别是完全混乱还是有一定的特征

### Rule 30

Rule 30属于Random分类，Rule 30通过了所有对于randomness的检测，它被用于产生随机数

### Rule 110

2004年Rule 110被证明是Turning Complete的，所以它具有universal computatin的能力

由于难以进行configure并且速度很慢，所以用Rule 110进行universal computatin是不现实的，但是elementary CA表明一个十分多变的计算可以通过非常简单的系统完成

# Cellular Automata Part Two

## Two Dimensional CA

一维的CA表明CA的实用性，如果我们想在CA中模拟真实的行为，那应该使用二维CA，Game Of Life就是一种二维CA

## Game Of Life

Game Of Life可以简称为Life，于1970年被发明，目的是定义一个interesting and unpredictable的CA

规则的定义基于以下几个原则：

1. 不能有爆炸式的增长
2. 应该存在简单的初始状态迭代出现复杂且不可预测的结果
3. 应该存在满足von Neuman universal constructors的可能
4. 规则应当简单且可行

最后呈现的效果是一个复杂的系统

von Neuman's definition of life：可以自我繁殖、可以模拟一个Turning Machine

### State & Neighbourhood

每个cell有两种状态，0代表dead，1代表alive，使用Moore neighbourhood

### Rules

对于alive的cell，如果neighbours不为2或3，就变为dead，对于dead的cell，如果neighbours恰好为3就变为alive

### Topology

Life使用2维grid，这个grid是wraps around的，因此在上下左右边界的cells也有完整的Moore neighbourhood

### Patterns

- stills：从不改变
- oscillators：在两种状态间变化
- spaceship：在grid中移动

### Rule Table

Life有4条规则，可以像Elementary CA一样将所有可能列举出来成为一个Rule Table，对于Moore neighbourhood，如果每个cell只有两种状态，这个rule table将会有2^9行，如果有k种状态，就会有k^9行，所以枚举所有状态是不可行的

Life是将几个2D CA的规则合并起来，而对于所有2D CA，可能的rule tables将有k^(k^2)种

## von Neumann Universal Constructor

于1940年代被发明，on paper，因为当时没有计算机，基于一个机器人建造另一个机器人的思想，是一个抽象的机器，运行时复制自身

是一个有用29种状态的2D CA，包含3个部分：

1. 拥有一个用于自身的blueprint
2. 拥有一个机制，可以理解任何计算模型并且建造由这个blueprint规定的机器
3. 拥有一个机制可以复制任何blueprint

关键在于这种机器扮演两种角色：既是复制过程的执行者，也是复制过程的目标

类似于DNA或者计算机病毒

## Langton Loops

于1984年被发明，移除了von Neumann结构的universality condition

# Problems To Be Solved

## Types of Problem

Problems可以被归为一些不同的类别：

1. black box model
2. search problems
3. optimisation vs constraint satisfaction
4. NP problems

## Black Box Model

这个模型包含3个部分：Input，Model和Output，每一个部分是未知的时候，都会产生一个新的问题

### Optimization

model和output是已知的，目标是找到提供预期output的input，比如class scheduling, travelling problem, eight-queens problem

#### Class Scheduling

有一个巨大的搜索空间，大到无法遍历所有情况，并且许多潜在的解是不可行的。课程表的制定要足够好，最小化课程冲突、最小化换教室的路程、保证教室足够容纳所有学生、保证教师没有课程冲突等等

#### Travelling Problem

最小化遍历所有城市的距离，可能的解有n!种，大到遍历所有情况是不可能的

#### Eight-Queens Problem

在一个8*8的棋盘上，没有任何一个queen出现在同一行、同一列、同一对角线上

### Modelling

input和相应的output是已知的，目的是找到一个model满足输入可以得到对应的输出，modelling是可以转化成optimization问题的

### Simulation

model和input是已知的，目的是得到符合input通过model规则得到的output，通常被用来回答what-if问题，比如天气预测

## Search Problems

这类问题通过搜索一个巨大的可能解集来解决，所以optimization和modelling就是这类问题，但是simulation——不知道理想的output，就不是这类问题

这种问题的搜索空间就是所有的解集，解决方法是告诉计算机如何遍历整个搜索空间

## Optimisation versus Constraint Satisfaction

- objective function：来评价解的质量的评价函数，比如最大化8-queens问题中un-checked queens的数量、最小化tour visiting的路程长度
- constraint：二元要求，即一定要满足某种条件或一定不能怎样，比如8-queens问题中不能有queens互相check
- mixture：比如找一条最短路线，且必须先到Y才能去到X

## Non-Deterministic Polytime Problems(NP Problems)

搜索空间是离散的变量，有限个数或者无限个可数的解，所以搜索空间是可以被遍历的。可以通过解的复杂度来进行简单分类，比如：
- easy：存在一个快速的搜索方法来找到最优解
- hard：不存在快速的搜索方法

### NP Problems

- problem size：问题的维数和问题所求的变量个数
- runnnig-time：算法所需的操作数
- 以最坏结果作为problem size的定义方法
    - polynommial：easy，n^k
    - exponential：hard，k^n

### Classes

#### P

能够在一个多项式时间内找出解

#### NP

能够在一个多项式时间内验证解

#### NP-complete

这类问题属于NP类，任何NP问题都可以通过复杂度为多项式时间的算法归约(变换成另一个问题)为NP-complete问题

#### NP-hard

如果所有NP问题都可以多项式时间归约到某个问题，那么就称其为NP-hard问题。这类问题的复杂度至少与NP-complete问题相当，但是解不一定能在多项式时间内被验证

# Evolutionary Computing Origins

## Inspiration from Biology

Evolution <-> Problem Solving  
environment <-> problem  
individual <-> candidate solution  
fitness <-> quality

### nature

一个environment中包含许多individuals，它们的目的是生存和繁衍，每个individual的fitness代表它们生存和繁衍的几率，由environment决定，其中国包含了它们的同类

### computing

在已有一个可能的解集下，用一个随机的不断试错的过程来解决一个问题，每个candidate solution的quality是来评价这些解的效果有多好，并且决定这些解被保留作为进一步构建candidate solution的几率

## Darwinian Evolution

population包含一系列不同的individuals，利于适应环境的traits的结合将导致更高的representation。individuals是units of selection，population是unit of evolution

### Survival of the Fittest

所有environments都有有限的资源，所以只能承受有限的个体；life forms有基本的繁衍形式，所以某些选择是不可避免的；能够最有效争夺资源的个体会增加繁衍的可能性

### Diversity Drives Change

如果表现型导致繁衍的可能性更高，并且可以被后代继承，那么这些个体将在后代中占比更高，导致新的特征结合

# Evolutionary Algorithms

## Recap of EC Metaphor

EA是随机且基于population的，crossover和mutation是variance operators，他们创造出多样性，使新的candidate solution更多，selection通过去除低质量solution来减少多样性

## General Scheme of an EA

Initialization -> Population -> [Parent selection -> Parents -> Recombination(crossover) Mutation -> Offspring -> Survivor selection] -> Population -> Termination

通过mutation和recombination来增加population的多样性，将population推向novelty，通过selection减少population的多样性，将population推向quality

两种趋势共同作用导致fitness的上升

## Main EA Components

### Representation

编码出可能解，并且可以有多种变化，有两种形式

- phenotype：在原问题中的形态
- genotype：用代码去表示的形态

encoding是从phenotype到genotype，不一定是一一对应的；decoding是从genotype到phenotype，一定是一一对应的

genotype包含通常是固定的位置，称为loci，还有值

比如通过二进制数转换为十进制数，二进制数就是genotype，十进制数就是phenotype

### Fitness Function

表示任务是否完成，和需要去达成的要求，可以被看做environment，通过提供比较原则来实现选择功能，也可以叫做quality function或者objective function，通过对所有phenotype进行分数为整实数的打分来进行评判优劣，一般是求最大值，但是也可以写出最小化的方程

### Population

将可能解作为个体，因为一个population是个体们的集合，所以个体表现型的重复是可能的。population是evolution的基本单位，不是individuals

在一些复杂的EA中会有空间结构，每个个体会有自己的邻居，这会影响个体之间的繁殖和选择，但是总的来说，selection操作通常作用在整个population上，所以繁殖操作与当前的generation有关，一个population的diversity可以通过不同的fitness，phenotype和genotype来衡量

### Selection Mechanism

用来区分哪些个体将称为parents，哪些个体将存活到下一代，将整个population推向更高的fitness

parent selection一般是基于概率论的，更高的quality代表更高的被选中率，但是只是概率，即使是最差的quality也有可能被选中

survivor selection是决定哪些个体可以存活到下一代，大多数EA有一个固定的population size，所以需要有一个机制来选择parents和offspring保留到下一代，这种选择是基于客观条件的，比如基于fitness或者age，有的时候会基于随机选择和客观条件的结合，比如保证fitness在前10%的个体存活到下一代，剩下的个体随机选择

### Variation Operators

用来生成新的可能解，通常根据输入个体的数量，分为以下几种情况

- arity 1：mutation
- arity >1：recombination
- arity 2：crossover
- arity >2：可行，但一般不用于EC

### Mutation

生成小的、随机的变化，作用在一个genotype上，传递到另一个

### Recombination

将parents的特征结合起来传递到offspring，哪些特征被选择是随机的，大多数offspring可能会比parents的fitness差，或者相当，但是期望是后代结合了parents的优点，使其有更好的traits，在EA中一般特指crossover

### Initialisation & Termination

initialisation一般是随机的，需要保证个体尽可能分散，termination condition用来检查每个generation是否应该终止，如果满足以下这些条件

- 达到特定的fitness level
- 达到最大的迭代次数
- 达到最低限度的diversity
- 经过指定次数的迭代依然没有fitness improvement

## Typical EA Behavior

### Stage of Optimisation

通过一个一维的fitness landscape展现，早期呈现一个随机的population distribution，中期population在hills处聚集，末期population集中在high hills

### Progression of Fitness

当迭代到一定程度，一点点提升可能需要几倍迭代时间，这时就需要结合需求考虑是否要进行下去，还是在较早的阶段停止，得到一个可接受的解

### Flexible Approach

对于大多数问题来说，problem-specific解法可能比generic search algorithm要好，但这些解法不能适用于其他的问题，而EA可以提供对许多问题性能都一样好的解法

# Probability

概率是期望的值，不是确定值

# Binary and Integer Representations

## Recap

### Representation

对于EA，需要一个representation来进行exploration和exploitation，实现exploration要求可以represent所有的可行解，实现exploitation要求能够对representation进行细微的改变，这样fitness的改变也是细微的

### Mutation

- mutation rate：mutation发生的概率
- mutation operator：如何实现mutation

### Recombination

- recombination rate：如果Pc是recombination rate的话，那么children与parents不同的比例是Pc，相同的比例是1-Pc
- recombination operator：如何实现recombination

## Binary

### Mutation

对于binary类型通常进行bitwise mutation，但是由于二进制的进位问题，会导致一个bit的改变导致与原本的值相差很大，这时可以用格雷码解决

### Crossover

#### 1-point crossover

在parents上选取一个随机的点，将parents的representation从crossover point分开然后交换，得到children

这种方法有一个问题，尽管可以保留每个gene所临近的gene，但是永远不能将两端的gene结合在一起，这种现象叫做Positional Bias

#### k-point crossover

选取n个crossover points，但是这种方法依然会有一定程度的positional bias

#### uniform crossover

指定parents的一边为head，一边为tail，从头到尾对每一个gene进行一个50%概率的选择，如果成功就将该gene进行调换，这种方式消除了positional bias

### Choose

crossover和mutation方式的选取一般基于实际问题选取，但是存在一个事实，mutation-only的EA是可行的，但是crossover-only的EA不可行

因为，exploration是在search space里寻找理想的区间，是gaining information，但是exploiation是在理想区间内寻找最优解，是using information

crossover是explorative的，它可以jump to an area somewhere in between two parents，而mutation是exploitative，它create random small diversions，near the parents

只有crossover可以结合两个parents的信息，但是crossover不能创造变化，例如如果所有个体的gene都是0，无论如何变化都是0；只有mutation可以带来新的信息，去得到所需的最优解

## Integer

大多数人都认为将变量encode为numerical更好

### Recombination and Mutation

n-point和uniform crossover依然适用

在binary类型中的bit-flipping principle可以在integer类型中扩展为两类
- random resetting：以概率Pm为每个gene选取一个新值。这种方式最适合cardinal attributes，因为所有gene value都是等概率的
- creep：以概率Pm为每个gene加上一个很小的正数或者负数v，v是从一个以0为中心的分布中随机选取的。这种方式最适合ordinal attributes

# Real Number Representation

许多问题都是以实数形式，在计算机中将实数表示为浮点数，但是所有的浮点都有精度限制，所以不可能用计算机遍历所有的可能解。但是对于mutation和recombination，我们将浮点数当作连续的，所以适用于integer类型的rep就不适用了

## Mutation

对于一个浮点数集，每一个元素Xi都有上限Li和下限Ui，这些值可以被mutated为一个新的集合，元素分别为X'i

### uniform mutation

uniform mutation中，X'i被随机赋值为上下限范围内的任意一个随机值，类似于binary和integer中的bit-flipping和resetting，所以每个gene都有相同的mutation概率Pm

### non-uniform mutation

non-uniform mutation是最常用于real-value的，类似于integer中的creep，所以每个变化也都是很小的。最常用的方法是对每个变量加上一个从高斯分布N(0, σ)中随机选取的值，并且保证X'i在上下限范围内，这样大多数的变化都是非常小的，但是也有可能会有很大的变化，标准差σ是mutation step size，决定了这个过程

### self-adaptive mutation

在这种mutation中，step sizeσ被包含在genotype，并且自己也会进行变化。step size并不是被用户所指定的，而是随着变化一同变化，这样做的好处是不同的理想strategies可能在不同的阶段被使用

我们还可以为每个元素Xi指定一个单独的step size σi

这种mutation必须按照指定的顺序进行：先mutate σ，再mutate剩下的genotype。如果不这么做，那么在selection环节中，本轮mutation的σ的效果就不会体现出来，而是上一轮的σ

所以genotype将被evaluate两次，首先评判产生的X'是否理想，如果理想的话，再评判step size σ是否理想

### uncorrelated mutation with one σ value

genotype只有一个σ来决定distribution，σ的mutation是将其乘上learning rate τ和来自N(0, 1)中的一个随机值。通常τ的值为1/n^0.5，这个值保证了大部分情况下都是较小的变化，并且σ增大减小的概率相等

由于过于小的step size会有负面效果，所以通常设定一个lower bound ε，如果σ<ε，那么将σ的值设为ε，这里的learning rate τ是由用户自行设定的

这种mutation方式让每个方向(上下左右)都是等可能的产生个体

### uncorrelated mutation with n σ value

genotype有n个不同的σi对应每一个Xi，这里σ的mutation是乘上overall learning rate τ，再乘上coordinate-wise learning rate τi，每个Xi的这个learning rate是不同的，最后再乘上从N(0, 1)中选取的一个随机值。这里的两种τ也都是由用户自行设定的

这种mutation方式可以设定更倾向于某个方向来产生个体

### correlated mutations

这种mutation方式允许出现任何搜索方向，这个特性是通过一个co-evolving rotation parameter实现的

### overall

随着gene数量的增加，我们需要增加搜索空间的大小，所以使用一个复杂的mutation operator所带来的开销可能会得不偿失，所以我们需要考虑实际问题来采取mutation方法

一个通用的方式是从uncorrelated mutation with n σ values开始，然后根据情况
- 如果可以得到理想结果，但是速度较慢的话，可以使用更简单的model，比如one σ或者fixed σ
- 如果不能得到理想结果，那么改用更复杂的model，比如correlated mutation

## Crossover

- discrete

    每个后代的allele value z都是从parents(x, y)中，以相同概率得来的，Zi = Xi or Yi

- intermediate

    采用了creating children between parents的思想，即arithmetic recombination，Zi = (1 - α).Xi + α.Yi where 0 <= α <= 1

    α可以是连续的，也可以是根据某种规律变化的，也可以是随机的

### single arithmetic crossover

parents：< X1, ..., Xn > and < Y1, ..., Yn >

随机选取一个gene k，第一个后代就会是< X1, ..., Xk-1, α.Yk + (1-α).Xk, ..., Xn >，第二个后代就是第一个后代交换X和Y

即设定一个α，选取一个gene k，将后代的这个gene的值设为一个parent的gene k的值乘α，加上另一个parent的gene k的值乘1 - α

### simple arithmetic crossover

parents：< X1, ..., Xn > and < Y1, ..., Yn >

随机选取一个gene k作为crossover point，选取crossover points之后的所有gene，第一个后代就会是< X1, ..., Xk, α.Yk+1 + (1-α).Xk+1, ..., α.Yn + (1-α).Xn >，第二个后代就是第一个后代交换X和Y

即设定一个α，选取一个gene k，将后代的这个gene之后的所有gene的值设为一个parent的对应gene的值乘α，加上另一个parent的对应gene的值乘1 - α

### whole arithmetic crossover

最常用的方式

parents：< X1, ..., Xn > and < Y1, ..., Yn >

第一个后代是< α.Y1 + (1-α).X1, ..., α.Yn + (1-α).Xn >，第二个后代就是第一个后代交换X和Y

即设定一个α，将所有的后代所有gene的值设为一个parent的对应gene的值乘α，加上另一个parent的对应gene的值乘1 - α

### blend arithmetic crossover

这种方式允许新生成的值在[Xi, Yi]范围之外

parents：< X1, ..., Xn > and < Y1, ..., Yn >

假设Xi < Yi，则di = Yi - Xi，那么新生成的值就是[Xi - αdi, Yi + αdi]这个范围内的一个随机值，事实表明α = 0.5的时候是最佳的

简而言之就是，选取到[Xi, Yi]范围之内的概率和范围之外的概率相等

## Multi-Parent Recombination

mutation只用到了1个parent，传统的crossover用到了2个parent，一般parent数不会大于2，但是可以大于2，这种情况主要有两种解决方法

- segment and recombine

    比如n个parents的diagonal crossover，选取n-1个crossover points，然后按对角线的方向来重新组合

- arithmetical combination of alleles

    比如后代的第i个allele的值是所有parents的该allele的均值

# Permutations and Trees

## Permutation Representations

这一过程的目的是将一些对象以特定的顺序进行排列，比如规划旅行路线图

### Mutation

一些常用于其他number representations的mutation方法在这里会得到不可行解，所以我们必须同时改变gene，而不是逐个mutate，所以这里的mutation parameter代表着是否作用于整体，而不是是否对某一个gene进行mutation

#### swap mutation

随机选择两个allele然后交换它们的位置

#### insert mutation

随机选择两个gene，然后将第二个选择的gene插入到第一个选择的gene后，剩余的gene保留位置顺序

#### scramble mutation

随机选择一个subset of genes，对这个subset随机打乱

#### inversion mutation

随机选择一个subset of genes，将这个subset给inverse，优点是可以保留大多数的adjacency information，但是会打乱order information

### Crossover

一般的crossover操作会带来不可行解，所以对于需要保留order information还是adjacency information，有不同的crossover方法

#### order 1 crossover

从第一个parent的gene里随机选取一块，复制到后代gene的对应位置，然后从第二个parent对应gene的最后一个gene开始，按顺序将未使用过的gene值复制到后代

#### cycle crossover

将parent中所有的cycles genes给识别出来，然后交替插入到后代的gene中

#### edge crossover

edge是1个element在两个parents中的neighbors，这个neighbors是wrap around的。edge crossover只产生一个child，这种方式保留了许多adjacencies

整个crossover的过程如下

- 首先生成一个table来列出每个elements的edges，如果有edge同时出现在两个parents中，那么在table以+号作标记，并且这个共同的edge将在child中被保留

- 构建好table后，随机选择一个element作为child的第一个gene，并将被选中过了的element从table中划去

- 在table中找到目前所选的element，该element的edges将作为candidates，如果candidates中有被+标记的edge，那么选择该edge作为下一个gene，如果没有，那么选择candidate自己的edges最少的那个，如果都没有，那就随机选一个

- 如果所选的元素的edges是空集，那么就再在剩余的elements中随机选一个开始

- 循环，直到所有elements被选中，然后就会生成一个child

## Tree Representation

terminal set的元素作为leave nodes，function set的元素作为internal nodes

### Mutation

最常用的一个方法就是随机选取一个subtree，以一个随机生成的tree来替代

### Recombination

在两个parents中分别随机选择一个subtree，然后交换，生成两个children

# Fitness Selection and Population Management

## Population Management models

### Introduction

有两种不同的population management models

- generational model：每一个个体只存活一代，整个parents set被offspring替代
- steady-state model：在每一代之间，有一些个体是会存活到下一代，population size固定为μ，每次生成λ个offspring

### Fitness Based Competition

selection发生在两处

- parent selection：目前这代的个体，有哪些会被选作产生后代的
- survivor selection：哪些parents和offspring将会存活到下一代

selection是作用在所有个体上的

## Fitness Proportionate Selection

每个parent被选中进入到mating pool的概率P(i) = Fi / ΣFj，即每个个体的fitness得分占总分数的比例，但这种选择方式会带来一些问题

- 一个非常fit的个体将会迅速take over，如果其他个体不是很fit的话
- 当fitness程度相近，会有loss of selection pressure
- 如果fitness function改变，behave将会有很大区别

scaling可以解决后两个问题，比如windowing，这会增大increase pressure

### Rank-Based Selection

通过给fitness排序，以相对顺序作为selection概率的依据，而非fitness的绝对值，这种方法需要在算法实施前进行排序，不过排序所花费的时间与fitness evaluation比起来是微不足道的

#### linear ranking

P(i) = (2-s)/μ + 2i(s-1)/μ(μ-1)

s作为factor调节整个function，s的范围是(1, 2]，μ是population size

根据定义，s不能为1，但是假设s=1，那么结果就是每一个个体，不论fitness，都会均等概率的被选中；如果s=2，那么fitness最差的个体将永远不会被选中。由此可以看出，s即pressure，s越大，pressure越大

#### exponential ranking

P(i) = (1 - e^(-i)) / c

参数c是一个用来保证selection probabilities之和是1.0的值

### Roulette Wheel Algorithm

即作一个pie chart，以转盘的形式选择，每个个体的proportion即各自的selection probability

有时这种算法给出的选择并不是一个好的distribution，所以相较于选择多次，每次只选一个，可以一次选择多个

stochastic universal sampling(SUS)，就是一次选择λ个，具体做法是将λ个spins均等划分后再转动转盘，这种方式会让结果与期望更加相近

### Parent Selection

以上的所有方法都是以总体的statistics为基础，但这可能引起计算上的瓶颈，尤其是在并行计算的机器上，或者population十分大，这些方法依靠一个可能不存在的external fitness function

#### tournament selection

有一种只用到local fitness info的想法，即随机选取k个个体，然后选择其中最好的一个，重复这个过程选择更多个体

这种方法下，每个个体被选中的概率将取决于

- rank of i
- size of sample k，其中k越高，selection pressure会越高
- contestants是否会放回，如果会的话，selection pressure也会提高
- 是否样本中fitness最高的contestant一定会获胜(deterministic)，或者以概率p获胜(stochastic)

#### uniform

这种方法没有selection pressure，leave the job to the survivor selection

进行over-selection，将总体分为两个group，first group是总体的top x%，second group是总体的bottom 100-x%，在first group中选择更多个体，一般这个比例是8：2

### Survivor Selection

这个步骤是用来将EA所记录的μ个parents和λ个offspring缩减到μ个用于构建下一代的individuals，parent selection的方法也可以用到survivor selection中。survivor selection可以被划分为两种

- age-based selection：不考虑fitness，在一个稳定的GA中可以以delete-random的形式实现，但是这种方式不好；也可以以first-in-first-out(delete-oldest)的形式实现
- fitness-based replacement

#### fitness based replacement

elitism，即永远保留最少一个fittest solution(或者top % of solutions)的copy，这种方式是被广泛使用的

genitor(delete-worst)，这种方式会rapid takeover，所以最好只在large population的情况下使用

round-robin tournament，将每一对个体进行对比，记录下每个个体获胜的次数，然后选取μ个获胜次数最多的个体保留至下一代

(μ, λ)-selection，这种是在λ>μ的情况下，只考虑offspring，选取其中最优的μ个

(μ+λ)-selection，这种是考虑parents和offspring，选取其中最优的μ个

但是通常选用(μ, λ)-selection，因为这种方式可以更好的避免local optima，同时可以更好的follow moving optima；而如果有些bad value十分适合局部最优的话，(μ+λ)-selection会将它们保留很多代。一般认为λ = 3是一个比较好的选择

### Selection Pressure

takeover time τ是一种量化selection pressure的方式

### Multimodality

大多数问题都有不止一个局部最优解，有限的population在全局mixing和selection的情况下，最终总会得到一个最优解

大多数算法都想得到多个可能的局部解，为了更好的将算法套用到其他问题上去，并且有时次优解可能more attractive

## Approaches for Preserving Diversity

### Introduction

有explicit和implicit两种方法

- implicit
    - 使用一种与geographical separation等价的方法
    - 使用一种与speciation等价的方法
- explicit
    - 让相似的个体去竞争资源
    - 让相似的个体互相竞争，来选择存活的个体

正如生物进化存在于地理空间上一样，EA也有几种不同的空间

- genotype space：一些representable solutions，是decision space
- phenotype space：最终的结果，这里的空间结构可能跟genotype space没什么关系，是solution space
- algorithmic space：等价于地球上物种进化所在的地理空间

### Explicit

#### Fitness Sharing

因为good solution在稠密空间内的fitness会比comparably good solution在空旷空间内的fitness要低，这会降低这些good solutions的chance of selection，所以需要fitness share来根据与其他个体的相似度来调整fitness。每个个体之间的距离可以根据genotype space，通常用Hamming distance，或phenotype space，通常用Euclidean distance来计算

#### Crowding

crowding算法是一种保证新的个体在population中所替代的是相似的个体，所以offspring替代与它们最相似的parents

这种方法被认为有很多不足，改进后的方法叫deterministic crowding，这种改进方法的特点有

1. parent population是随机配对的
2. 每一个配对通过recombination产生两个offspring
3. offspring在mutate后会进行evaluation
4. 计算parents与offspring之间的pairwise distances
5. 每一个offspring与一个parent竞争survival，使用两对之间距离之和最小的配对

### Implicit

#### Automatic Speciation

使用mating restrictions，要么只mate genotype或者phenotype相似的个体，或者在representation中加入tag，比如一个额外的gene作为label来标记genotype属于哪一类

#### Island Model

在多个population中并行运行，在一个指定的代数之后，与neighbors交换一部分个体，然后重复运行直到达到迭代停止的条件

对于多少代进行一次交换，既不能太快，导致各个population cover到same solution，也不能太慢，浪费时间，通常是在25到150代进行一次；每次交换，通常交换2到5个个体，具体个数取决于population size，有人发现随机选择个体交换比挑选出最优个体交换的效果要好

每个neighbor之间的具体操作可以不一样

#### Cellular EAs

这种方法的selection和replacement基于neighborhood

parent和survivor selection会用不同的grid搜索不同的space

同时，由于neighborhood的重叠，最终good solution会在一定代数后传遍整个空间

# Popular Evolutionary Algorithm Variants

主要有以下几种EA variants
- Genetic Algorithms (GA and SGA)
- Evolution Strategies (ES)
- Evolutionary Programming (EP)
- Genetic Programming (GP)
- Particle Swarm Optimisation (PSO)
- Ant Colony Optimisation (ACO)

## Genetic Algorithms

由Holland发明，现在有了许多变种，所以原型现在叫做Simple Genetic Algorithm(SGA)

## Simple Genetic Algorithm

通过bit-strings来进行representation，recombination的方式是1-point crossover，mutation的方式是bit flip，parent selection是通过roulette wheel进行的fitness proportional selection，survivor selection是generational的

### SGA Reproduction Cycle

- 为mating pool选择parents，mating pool的size等于population size
- shuffle the mating pool
- 进行crossover，每一对parents以Pc的概率crossover，否则直接copy
- 为每个offspring进行mutation，以Pm的概率进行bit-flip的mutation
- 用offspring替代整个population

目前SGA仍然作为novel GAs的benchmark，有许多缺点，比如representation限制过多，mutation和crossover只对bit-string和integer的representation有效等等

## Evolution Strategies

通常用于numerical optimisation，优点是fast和对实数效果好，特点是有self-adaptation的mutation parameters

ES的representation是实数向量，recombination是discrete或者intermediary，mutation基于高斯分布，parent selection是均匀随机的，survivor selection是(μ，λ)或者(μ+λ)

### Representation

chromosomes包含3个部分
- 变量：x1, ..., xn
- 参数
    - mutation step size：σ1, ..., σn
    - rotation angles：α1, ..., αn

并不是每个部分都会被用到