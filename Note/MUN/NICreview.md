cellular automaton(CA)包含一个任何维度的grid of cells，每个cell在任意一个时间都具有一个确定的state，并且有被定义的neighbourhood of other cells，transition rules描述了cell会如何变化

elementary CA是一个简单的一维的line of cells，8个cells，只有0和1两种状态，因为只有左右两个neighbours，所以算上自己，neighbourhood的状态一共有8种，这8个状态可以根据neighbourhood值对应的二进制大小排序成一个8位的二进制数，称为rule X

同样的transition rule对于不同initial conditions，最后呈现的过程和结果也会是不同的，这叫做sensitive of initial conditions

transition rules根据最后的outcomes分为了四类

1. uniformity：经过一定迭代次数后，所有的cell状态将保持不变
2. repetition：经过一定迭代次数后，所有的cell状态将保持有规律的变化
3. random：cell状态没有确定的规则
4. complexity：cell状态表现出一些复杂的规则

对于random类和complexity类，尽管最后的outcome有些相似，但是对于这两类的区分还是通过肉眼观察，二者的区别是完全的混乱，和混乱中有一定的特征

rule110被证明是turning complete，所以具有universal computation的能力，这也证明了elementary CA是具有universal computation的能力

game of life是满足von Neumann universal constructors。每个cell有2个状态，1和0.使用Moore neighbourhood，即一个cell的neighbours是周围的8个cells，并且因为life是使用wrap around的grid，所以在上下左右边界的cells也具有完整的Moore neighbourhood

除了Moore neighbourhood，另一种更通用的type是von Neumann neighbourhood，这种neighbourhood的定义是取Manhattan distance小于n的cells为neighbours，最简单的是取1，即上下左右4个neighbours

对于使用Moore neighbourhood的life，且每个cell只有2个状态，如果将一个规则的所有情况列出来，rule table会有2^9行，如果有k种状态，那么一个规则的rule table会有k^9行。对于k种状态，那么最后的outcome也会有k种，rule table的每一行都对应k种情况，所以k种状态的CA的所有情况，将会是k^(k^9)种，这是一个非常巨大的数，不可能列举出所有情况

von Neumann universal constructor是on paper的，因为当时没有计算机，是基于一个机器人建造另一个机器人的思想，即运行时复制自身。它是一个具有29种状态的2D CA，包含3个部分，拥有一个用于自身的blueprint，拥有一个可以理解任何blueprint并且可以根据该blueprint创建新machine的机制，拥有一个可以复制任何blueprint的机制

problems可以被归为四类，black box model，search problems，optimization vs constraint satisfaction和NP problems

- black box model分为3个部分，input，model和output，这三个部分，每一个部分是unknown的时候就又构成了一个新的问题
    - optimization：input是未知的，目标就是找到提供预期output的input
    - modelling：model是未知的，目标是找到一个满足输入和输出对应的model，modelling是可以转换成optimization问题的
    - simulation：output是未知的，目标是找到input根据model得到的output，通常被用来回答what-if问题

- search problems就是通过在一个巨大的set of possible solutions里找到解，所以需要知道output，而optimization和modelling就是属于这类问题，但是simulation不是

- optimization vs constraint satisfaction
    - objective function：用来表示possible solution的value，从而可以反映解的quality而进行优化
    - constrain：binary evaluation，用来表示是否达到了所要求的限制
    - mixture：混合了以上两种，在满足一定的constrain的情况下来maximize或者minimize

- NP problems，search space是discrete的，即有限个可能解或者无穷个countable的可能解，所以最优解是可以穷尽搜索出来的，根据问题的维数和问题所需的变量个数来定义problem size，算法所需的操作数为running-time，如果时间是n^k，即polynomial多项式时间内可以找到，那么就是easy的，如果是k^n，即exponential时间，那么就是hard的，根据找到最优解的难易程度可以分为以下几类
    - P：可以在polynomial时间内解决
    - NP：可以被解决，并且任何解法都可以在polynomial时间内，被其他的一些算法verify，(P∈NP)
    - NP-complete：这类问题是NP的子集，并且除此以外的任何其他NP类问题都可以通过某个polynomial时间的算法简化到NP-complete中
    - NP-hard：难度不低于任何NP-complete类的问题，但是不需要满足可以在polynomial时间内被其他的一些算法verify

可以确定的是P与NP-hard类问题不相等，但是不清楚P是否可以跟NP类问题划等号，假设P不等于NP，那么就是NIC发挥的场景了

NIC是从biology中得到的启发，problem solving对应着evolution，environment对应着problem，individual对应着candidate solution，fitness对应着quality

Darwinian evolution的观点中，population包含着一系列的individuals，而环境中的资源有是有限的，利于适应环境的traits的结合会导致更高的representation，其中individual是unit of selection，而population是unit of evolution

EA是随机且基于现有的population的，crossover和mutation是variance operators，它们创造出多样性，使新的candidate更多，而selection通过去除低质量的solution来减少多样性，但是会提升quality，两种过程共同作用来使fitness上升

一个general的EA步骤是：initialization生成最初的population，然后进行parent selection得到parents，这些parents通过crossover和mutation生成offspring，再将parents和offspring通过survivor selection从而得到新一轮的population，往复循环直到population满足termination

EA的主要成分有以下这些

1. representation：即encode所需要解决的问题，比如编码表达出candidates，如何进行crossover和mutation。phenotype就是原问题，而genotype就是计算机可以理解的形式。一个genotype一定对应一个确定的phenotype，而一个phenotype可能不止有一个genotype对应
2. fitness function：来衡量candidate的fitness，一般是构造出一个求最大值的优化问题，不过也可以写求最小值的优化问题
3. population：即candidates的集合，是evolution的基本单位，selection是在population level，而variation才是在individual level，这与前面的individual是unit of selection不冲突
4. selection mechanism：有parents selection和survivor selection，其中parents selection是基于概率的，而不是确定的，即使fitness差的个体也可能被选中，而survivor selection是基于客观的fitness rank的
5. variation operators：当input只有一个时，是mutation，当input大于1时，是recombination，当input等于2时是特定的情况，叫crossover，大于2的情况是可能的，但是不用于EC
    - mutation，生成一个小的、随机的变化
    - recombination，将parents的的特征结合起来传递到offspring，哪些特征被选择是随机的，大多数的offspring可能会比parents的fitness差或者相当
6. initialization & termination：initialization一般是随机的，termination一般是满足以下这些条件之一
    - 达到特定的fitness level
    - 达到最大的迭代次数
    - 达到最低限度的diversity
    - 经过指定次数的迭代依然没有fitness improvement

四种不同的EA对应着不同的data type
- binary string：genetic algorithm
- real-valued vectors：evolution strategies
- finite state machines：evolution programming
- LISP tree：genetic programming

optimization的过程一般是，population早期随机分布，中期集中在往各个peak的evolution上，最后集中在各个peak上。当迭代到一定程度，最后一点点的提升可能需要成倍的时间，这个时候就需要结合需求决定是否要停止了。对于大多数的问题来说，problem-specific的解法是比general search algorithm要好，但这些解法不能作用于其他的问题，而EA可以提供对许多问题性能都一样好的解法

crossover和mutation方式的选取一般是基于实际问题的，但是存在一个事实，即mutation-only是可行的，而crossover-only是不行的，因为mutation可以创造新的信息，而crossover只能结合两个parents的信息，如果所有个体的genotype都是0或者1，那么永远都不会有新的变化

- 对于binary的genotype
    1. mutation
        - bitwise，即以概率Pm，从头到尾每个一bit都以该概率进行一次mutation，如果mutate，那么就从0变1或者1变0，如果不mutate就不变。但是bitwise的方法存在一个问题，就是二进制下一个小小的改变可能导致genotype与原先的差异非常大，这里可以用格雷码解决

    2. crossover
        - 1-point，在parents上随机选取一个相同的点，从crossover point分开然后交换，得到两个children，这种方法存在的问题是永远不可能将两端的gene结合在一起，这种现象叫做positional bias
        - n-point，即在parents上随机选取n个点，但是这种方法依然会有一定的positional bias
        - uniform，从头到尾，每个bit都以50%的概率进行交换，这种方法没有positional bias

- 对于integer的genotype，大多数人都认为numerical会比binary好
    1. mutation
    
        binary类型中的bit-flipping的方式可以在integer中扩展为两类
        - random resetting，每个gene都选取一个新值
        - creep，为每个gene加上一个很小的正整数或者负整数v，v是从一个以0为中心的分布中随机选取的
    2. crossover

        n-point和uniform crossover依然适用

- 对于real number的genotype，虽然计算机中的浮点数是有精度限制，不可能遍历所有的candidate，但是对于mutation和crossover，依然当作连续的
    1. mutation

        对于一个浮点数集，每个元素Xi都有上限Li和下限Ui，这些Xi可以被mutate成为一个新的集合，分别为X'i
        - uniform，X'i是上下限范围内随机的一个值，类似于binary和integer中的bit-flipping和reseting
        - non-uniform，这种方法是最常用于real-value的，类似于integer中的creep，通常是对每个元素Xi加上一个从高斯分布N(0,σ)中随机选取的值，并且保证X'i在上下限范围内，这种方式保证了大多数的变化是非常小的，但是也可能会有很大的变化，其中标准差σ叫做mutation step size，它决定了这个过程
        - self-adaptive，这种方法是改进了non-uniform的，将step size也包含在evolve过程中，并且可以为每个Xi都赋予一个专门的step size。这种方法必须先mutate step size σ，然后再mutate genotype，否则本轮的σ不会发挥作用。这种方式在evaluate时先判断X'是否理想，然后再判断step size是否理想。根据σ又可分为以下几种
            - uncorrelated：如果只有一个全局的step size的话，σ的mutation包含learning rate τ和一个来自N(0, 1)的随机值，通常τ的值为1/(n^0.5)，这个值保证了大部分情况下都是较小的变化，并且σ增大减小的概率相等。由于过小的step size会有负面效果，所以通常设定一个lower bound ε，如果σ<ε，那么将σ的值设为ε

                如果每个gene都有自己的σi的话，σi的mutation包含overall learning rate τ，coordinate-wise learning rate τi，还有从N(0, 1)中选取的一个随机值。这种方式可以通过learning rate的设定来选择倾向于某个方向生成offspring
            - correlated：这种方式允许任何搜索方向，通过一个co-evolving rotation parameter实现

        随着gene数量的增加，我们需要增加搜索空间的大小，所以使用一个复杂的mutation operator所带来的开销可能会得不偿失，所以我们需要考虑实际问题来采取mutation方法，一个通用的方式是从uncorrelated mutation with n σ values开始，然后根据情况
        - 如果可以得到理想结果，但是速度较慢的话，可以使用更简单的model，比如一个σ，或者fixed σ，即non-uniform
        - 如果不能得到理想结果，那么改用更复杂的model，比如correlated mutation

    2. crossover

        - discrete，后代的每个gene的value都是从两个parents的对应gene中以相同概况选取的，即Zi = Xi or Yi
        - intermediate，采用了arithmetic recombination，即以一定的比例对parents的对应gene进行组合，该比例可以改变
            - single：随机选择一个gene，后代只在该gene的位置上进行crossover
            - simple：随机选取一个gene作为crossover point，该gene之后的每个gene都进行arithmetic crossover
            - whole：最常用的方式，即对每个gene都进行arithmetic crossover
            - blend：这种方式允许新生成的值在[Xi, Yi]范围之外，di为Xi和Yi之间差值的绝对值，新生成的值是[Xi - αdi, Yi + αdi]这个范围内的一个随机值，事实表明alpha是0.5的时候效果最佳

    mutation只用到一个genotype，传统的crossover用到两个parents，而对于大于2个parents也是可以实现的，主要有以下两种方法

    - segment and recombine，比如n个parents的diagonal crossover，选取n-1个crossover points，然后按对角线的方向来重新组合
    - arithmetical combination of alleles，比如后代的第i个gene的值是所有parents的该gene的均值

- 对于permutation的genotype，用于number representation的variation操作会得到不可行解
    1. mutation，由于排序问题，值域是一个固定的小范围，不能用值域以外的值，并且不能重复，所以我们需要一次性同时改变gene，而不是逐个mutate
        - swap：随机选择两个gene然后交换位置
        - insert：随机选择两个gene，将第二个gene插入到第一个gene之后，剩下的gene保留相对位置
        - scramble：选择一个subset of genes，将这个subset内的gene随机打乱
        - inversion：随机选择两个gene，然后将这个subset倒置，这个方法可以保留adjacency但是会打乱order
    
    2. crossover，对于需要保留order info还是adjacency info，有不同的方法
        - order1：从第一个parent的gene中随机选取一个subset，将其复制到offspring的gene的对应位置上，然后从第二个parent对应的最后一个的下一个gene开始，按顺序将未使用过的gene复制到后代中，保证没有重复
        - cycle：将parents中所有的cycle依次识别出来，然后依次交替插入到offspring中
        - edge：edge即1个element在两个parents中的neighbours，是wrap around的，这种方式只产生一个offspring，并且保留了很多adjacency info
            - 首先生成一个table来列出每个elements的edges，如果有edge同时出现在两个parents中，那么在table以+号作标记，并且这个共同的edge将在child中被保留
            - 构建好table后，随机选择一个element作为child的第一个gene，并将被选中过了的element从table中划去
            - 在table中找到目前所选的element，该element的edges将作为candidates，如果candidates中有被+标记的edge，那么选择该edge作为下一个gene，如果没有，那么选择candidate自己的edges最少的那个，如果都没有，那就随机选一个
            - 如果所选的元素的edges是空集，那么就再在剩余的elements中随机选一个开始
            - 循环，直到所有elements被选中，然后就会生成一个child

- 对于tree的genotype，这个最通用的结构可以represent很多类型的问题，包括非线性的genotype。terminal set中的元素作为leave nodes，function set中的元素作为internal nodes
    1. mutation，最常用的方法就是随机选取一个subtree，然后用一个随机生成的subtree来替代
    2. recombination，在两个parents中分别随机选择一个subtree，然后交换，生成两个offspring

有两种不同的population management models
- generational model：每一个个体只存活一代，整个parents set被offspring替代
- steady-state model：在每一代之间，有一些个体是会存活到下一代，population size固定为μ，每次生成λ个offspring

selection发生在两处，一个是parent selection，选择目前这代individuals，有哪些会被选入到mating pool中，另一个是survivor selection，在这代的parents和offspring，有哪些会存活到下一代

selection的方式有以下几种
- fitness proportionate，每个individual的fitness是Fi，那么每个个体被选择的概率是P(i) = Fi / ΣFj。但是这种selection会有一些问题
    - 一个非常fit的个体将会迅速take over，如果其他个体不是很fit的话
    - 当个体之间的fitness程度相近，会有loss of selection pressure
    - 如果fitness function改变，behave将会有很大区别

    scaling可以解决后两个问题，scaling即将原始的fitness通过一个function来得到一个新的fitness，比如windowing，就是将原fitness减去一个值，这会增大selection pressure，而将原来的fitness以相同的function增大，就会减少selection pressure
- rank-based，通过给fitness排序，以个体之间fitness的相对顺序作为selection概率的依据，而非fitness的绝对值，根据ranking方式不同，可以分为以下几种类型
    - linear ranking，P(i) = (2-s)/μ + 2i(s-1)/μ(μ-1)，s作为factor调节整个function，s的范围是(1, 2]，μ是population size。根据定义，s不能为1，但是假设s=1，那么结果就是每一个个体，不论fitness，都会均等概率的被选中；如果s=2，那么fitness最差的个体将永远不会被选中。由此可以看出，s即pressure，s越大，pressure越大
    - exponential ranking，P(i) = (1 - e^(-i)) / c，参数c是一个用来保证selection probabilities之和是1.0的值
- roulette wheel algorithm，即作一个pie chart，以转盘的形式选择，每个个体的proportion即各自的selection probability。有时这种算法给出的选择并不是一个好的distribution，所以相较于选择多次，每次只选一个，可以一次选择多个。stochastic universal sampling(SUS)，就是一次选择λ个，具体做法是将λ个spins均等划分后再转动转盘，这种方式会让结果与期望更加相近

- parent selection
    - tournament selection，这是一个只用到local fitness info的方法，这个方法的步骤如下
        - 先随机选取k个个体，可选择有放回和无放回，sample size k越高，那么selection pressure越高
        - 选择k个个体中fittest的individual，将其加入到mating pool
        - repeat直到选择到足够的parents
    - uniform，这种方式没有selection pressure。先进行over-selection，将总体分为两个group，first group是总体的top x%，second group是总体的bottom 100-x%，在first group中选择更多个体，一般这个比例是8：2

- survivor selection
    - age-based，不考虑fitness
    - fitness-based replacement
        - elitism：即永远保留最少一个fittest solution(或者top % of solutions)的copy，这种方式是被广泛使用的
        - genitor(delete-worst)，这种方式会rapid takeover，所以最好只在large population的情况下使用
        - round-robin tournament，将每一对个体进行对比，记录下每个个体获胜的次数，然后选取μ个获胜次数最多的个体保留至下一代
        - (μ,λ)-selection，这种是在λ>μ的情况下，只考虑offspring，选取其中最优的μ个
        - (μ+λ)-selection，这种是考虑parents和offspring，选取其中最优的μ个
    
    通常选用(μ, λ)-selection，因为这种方式可以更好的避免local optima，同时可以更好的follow moving optima；而如果有些bad value十分适合局部最优的话，(μ+λ)-selection会将它们保留很多代。一般认为λ = 3是一个比较好的选择

selection pressure，如果best individual take over的时间越短，那么pressure就越大，反之越小

大多数问题都有不止一个局部最优解，有限的population在全局mixing和selection的情况下，最终总会得到一个最优解。大多数算法都想得到多个可能的局部解，为了更好的将算法套用到其他问题上去，并且有时次优解可能more attractive

preserving diversity有两种方法
- explicit
    1. fitness sharing，因为good solution在稠密空间内的fitness会比comparably good solution在空旷空间内的fitness要低，这会降低这些good solutions的chance of selection，所以需要fitness share来根据与其他个体的相似度来调整fitness。每个个体之间的距离可以根据genotype space，通常用Hamming distance，或phenotype space，通常用Euclidean distance来计算
    2. crowding，这个算法是保证新的个体在population中所替代的是一个相似的个体，所以offspring替代与它们最相似的parents。这种方法被认为有很多不足，改进后的方法叫做deterministic crowding，这种改进方法的特点有
        - parent population是随机配对的
        - 每一个配对通过recombination产生两个offspring
        - offspring在mutate后会进行evaluation
        - 计算parents与offspring之间的pairwise distances
        - 每一个offspring与一个parent竞争survival，使用两对之间距离之和最小的配对

- implicit
    1. automatic speciation，使用mating restrictions，要么只mate genotype或者phenotype相似的个体，或者在representation中加入tag，比如一个额外的gene作为label来标记genotype属于哪一类
    2. island model，在多个population中并行运行，在一个指定的代数之后，与neighbors交换一部分个体，然后重复运行直到达到迭代停止的条件，有人发现随机选择个体交换比挑选出最优个体交换的效果要好。每个neighbor之间的具体操作可以不一样
    3. cellular EAs，这种方法的selection和replacement基于EA中出现过的neighborhood，parent和survivor selection会用不同的grid搜索不同的space，同时，由于neighborhood的重叠，最终good solution会在一定代数后传遍整个空间

主要有以下几种EA variants
- Genetic Algorithms (GA and SGA)

    现在有了许多变种，所以原型叫做simple genetic algorithm。SGA通过bit-strings来进行representation，recombination的方式是1-point crossover，mutation的方式是bit flip，parent selection是通过roulette wheel进行的fitness proportional selection，survivor selection是generational的

    目前SGA仍然作为novel GAs的benchmark，有许多缺点，比如representation限制过多，mutation和crossover只对bit-string和integer的representation有效等等

- Evolution Strategies (ES)

    通常用于numerical optimisation，优点是速度快和对实数效果好，特点是有self-adaptation的mutation parameters

    ES的representation是实数向量，recombination是discrete或者intermediary，mutation基于高斯分布，parent selection是均匀随机的，survivor selection是(μ，λ)或者(μ+λ)

    - representation：包含3个部分，每个genes，X1, ..., Xn，还有两个参数，mutation step size和rotation angles，并不是两个参数都会用到
    - mutation：从正态分布N(0, σ)中取一个随机数，σ是mutation的步长，σ根据1/5 success rule进行vary，即，每k代进行一次检测，如果超过20%的steps are successful，那么增大步长，如果低于20%就减小，否则保持不变
    - recombination：ES只生成一个offspring，使用discrete或intermediary的crossover方式。如果parents超过两个的话，有两种选择方法，一个是local，即选取两个parents，每个gene都用这两个parents生成，另一个是global，即每个gene会选择不同的parents
    - parent selection：通过随机分布选取，是无偏的，每个individual被选取的概率相同
    - survivor selection：更常使用(μ,λ)，因为(μ,λ)丢弃掉所有的parents，所以可以避免local optimal；并且如果fitness function会随着时间改变，(μ+λ)将会保留outdated解，所以难以follow the moving optimal；(μ+λ)阻碍了self-adaption，因为错误的adapted strategy parameters可能在相当长的一段时间内存在。selective pressure在ES中非常高，因为λ一般比μ高很多

- Evolutionary Programming (EP)

    EP是将evolution通过learning process进行模拟，目的是生成人工智能，智能的定义是有adaptive behaviour，所以具有预测的能力是智能的关键

    传统EP是根据finite state machines来预测，而现代的EP是numerical optimization，EP的特点是具有非常open的框架，任何representation和mutation都可以在EP下进行，现代EP与一些ES技术有重叠，所以很难说什么是标准的EP

    EP特别的地方在于，没有recombination，标准的现代EP具有参数的self-adaption

    EP的representation是实数向量，没有recombination，mutation是根据高斯分布进行的，parent selection是deterministic，即每个parent只产生一个offspring，survivor selection是probabilistic(μ+μ)

    finite state machine(FSM)包含：state(S)，input(I)，output(O)，transition function(δ) S × I -> S × O。这种机制可以用于prediction，比如在一个序列中预测下一次的input，quality就是预测的准确度

    现代EP没有预先定义的representation，所以也没有预定义的mutation，不过mutation必须与representation match，通常会对mutation参数使用self-adaption

    - representation：两个部分，genotye Xi和mutation step size αi
    - mutation：是correlated的，每个step size是self-adaptive的
    - recombination：EP没有recombination，因为在EP中，search space中的一个点代表整个species，而不是一个individual，所以不可能有species之间的crossover
    - parent selection：每个individual通过mutation产生一个child，是deterministic的，不是biased by fitness
    - survivor selection：parents和offspring混合在一起后，通过stochastic round-robin tournaments进行survivor selection

- Genetic Programming (GP)

    GP的产生主要是应用在机器学习中，特点是需要huge population，并且速度较慢，chromosome是非线性的，比如tree、graph，并且mutation是可行但非必要的

    GP的representation是tree structure，recombination是exchange of subtrees，mutation是random change in tree，parent selection是fitness proportional的，survivor selection是generational replacement

    对于一个可行的GP model，总体框架是：IF formula THEN good ELSE bad，未知的部分只有formula，因此search space(phenotype)就是一系列formulas，最直观的fitness方法就是一个formula正确classify的比例

    - initialization：最常用的方法是ramped half-and-half，initial population的每个member是通过full method或者grow method生成的，full method即生成的树的branch depth都是Dmax，grow method则是depth小于等于Dmax
    - offspring creation：GP的scheme是基于一定概率选择使用crossover或者mutation，mutation的话通常是一个很低的或者是0的mutation rate，GP的雏形根本没有mutation，后来有人建议以一个较低的rate，比如5%左右进行mutation。目前的共识是crossover在GP中有large shuffling effect，可以被看作一个macromutation
    - parent selection：通常是fitness proportionate，在非常大的population时，经常进行over-selection，以提高效率
    - survivor selection：传统情况是使用generational scheme，当下主要使用steady-state
    - 随着时间的增加，tree size也会增加。countermeasure有：禁止可能导致too big children的variation，但这样会inhibit search；所以通常使用parsimony pressure，即对oversized进行一定惩罚