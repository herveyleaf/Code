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

