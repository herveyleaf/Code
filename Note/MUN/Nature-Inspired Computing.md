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

