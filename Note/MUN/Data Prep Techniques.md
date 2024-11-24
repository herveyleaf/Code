# Introduction to NumPy

数据集可以来自多种格式，比如文档、图片、音频，甚至是任何形式，尽管这些数据格式上有所不同，但是它们大多都可以用数组表示，所以不管数据是什么格式，进行数据分析的第一步是将它们转换成一系列数组

NumPy中将数据存储在内存中进行操作，在某些程度上来说，NumPy像是python内置的列表，但是numpy的数组对于较大的数据有着更好的存储方式和操作方式，numpy是数据科学的核心

# Understanding Data Types

python易用性在于动态输入，区别于C、Java这些语言，需要对每一个变量进行类型声明，而python不用

python是基于c语言编写的，所以python object实际上是c语言的结构，不仅仅包含值，还包含其他信息。实际上python变量是一个指向c语言结构的指针，包含几个值

例如，一个python的整数是一个指针，指向一块包含所有python对象信息的内存，含有所要求的整数值，和其他信息。这些其他信息让python可以动态的变化数据类型，所有这些额外的信息都给python带来了大量的开销，随着数据越来越多，这些开销也就越来越明显

原生python的列表允许同时存在不同的数据类型，为了达成这一目的，列表中的每个元素都必须有它自己的类型、引用和其他信息，也就是说，每一个元素都是一个完整的python对象，列表包含一个指针指向内存中一块存放指针的地址，这些指针又分别指向一个完整的python对象；而对于numpy的数组，有一个固定的数据类型，所以整个数组只包含一个指针指向一块连续的数据

python已经支持固定数据类型的数组，但是更为实用的是numpy中的n维数组

numpy中创建n维数组的函数是 **np.array()** ，其中可以使用dtype参数指定数组的数据类型

还有 **np.zeros()** 函数，创建所有元素均为0的数组， **np.ones()** 创建所有元素均为1的数组，  **np.full()** 创建所有元素均为指定值的数组， **np.arange()** 创建一组线性元素，函数有3个参数，起始值、终止值、步长

**np.random.random()** 创建一组范围为0到1的随机数， **np.random.normal()** 创建一组均值和标准差为指定值的随机数， **np.eye()** 创建一个单位矩阵， **np.empty()** 创建一组未初始化的数组，内存中是什么那么数组的值就是什么

# The Basics Of NumPy Array

numpy中对数组的操作与python中的操作都是对应的

numpy中访问子数组：数组名[start : stop : step]，对于多维数组来说，每个参数用，分开，即数组名[n维, n-1维, ... 1维]

numpy中的数组切片是以views返回，而不是硬拷贝，即子数组与原数组依然指向同一块地址，而想要硬拷贝数组，需要用 **copy()** 函数

对于一个数组，可以使用 **reshape()** 函数进行重新构建维数，但是元素个数和所构建的维数必须匹配，这个函数返回的是一个硬拷贝的数组，通常是将1维数组重新排序为2维数组，这时可以使用x[np.newaxis, :]来构建行数组，用x[:, np.newaxis]构建列数组，其中np.newaxis是增加新的维度的意思，放在哪里就在哪个位置增加新的维度

如果想合并数组，可以使用 **np.concatenate() np.vstack() np.hstack()** 函数，np.concatenate()函数接受元组或者数组作为第一个参数，对于一维数组，只需要所需合并的数组作为参数，对于n维数组，需要指定从第几维合并，否则默认为第1维。而对于混合维数的数组合并来说，可以使用np.vstack()和np.hstack()函数更加清晰的表示，意思是垂直方向合并还是水平方向合并

如果想分割数组，可以使用 **np.split() np.vsplit() np.hsplit()** 函数，np.split()函数需要2个参数，第二个参数为分割点，n个分割点得到n+1个子数组

# Computation on Arrays Ufuncs

numpy数据运算的关键是向量化操作，通过numpy的universal functions(ufuncs)实现

python的默认操作十分慢，一部分原因是动态数据、解释型语言，还有一部分原因是一些小操作被重复许多次，尤其是循环操作，因为每一轮循环都要做类型检查和函数分配等操作，而编译型语言则在代码执行前就知道数据类型，使代码运行效率很高，可以使用%timeit()函数对操作时间进行测定

向量化让python操作变得和其他编译型语言一样直接，向量化是基于SIMD(Single Instruction/Multiple Data)架构

ufunc不局限于一维数组，可以对n维数组进行同样快速的操作，通常向量化操作比循环要快速的多

ufunc有两种，Unary ufuncs，只有一个输入；Binary ufuncs，有两个输入，ufunc将python原生的操作符号进行了重载，可以直接使用

numpy也可以使用python内置的绝对值函数，或 **np.absolute()** ，也可以简写为 **np.abs()** ，numpy还提供许多有用的ufuncs，比如三角函数和反三角函数 **np.sin() np.cos() np.tan() np.arcsin() np.arccos np.arctan()** ，还有指对数函数 **np.exp() np.exp2() np.power() np.log() np.log2()** ，对于对数函数，np.power()在计算非常小的数字的时候精确度不如np.exp()

numpy有许多许多的ufuncs，可以通过scipy.special来导入许多不常用的数学计算函数

对于所有ufuncs，都可以在函数内指定参数out来指定数据存储的位置

对于二元ufuncs，aggregations可以直接作用于这些计算上

reduce()函数代表作累积操作，accumulate()函数代表作累计操作，并且把每一步的过程给打印出来，对于这些操作，ufuncs不是进行vectorized计算，也就是说ufuncs不全是向量化操作

对于所有ufuncs，可以用outer()函数将每个单独的element进行配对并计算，即遍历所有组合

# Computation on Arrays Aggregates

numpy内置了所有聚合操作，包括求和、最大最小值、均值和方差，比python原生的操作快得多，可以用axis参数指定行或列(只考虑二维)

# Computation on Arrays Broadcasting

对于相同size的数组，numpy的二元操作是element-by-element的，对于标量，numpy会把常数给展开成相同size的数组，对于两个不同size的一维数组，会展开成二维数组

## Rule of Broadcasting

如果两个数组的维度数量不同，那么维度较少的数组将会复制leading side(left-side)维度的数据将维度数量补齐，如果只有一个1维的数组，要补齐成2维，将用这1维的1行数据复制出多行补齐；如果某一维度的数据不匹配，若这一维度的shape为1，那么会用这1行/1列的数据去stretch来match shape，如果任何一个维度的size有不同，并且都不为1(即不能stretch)，那么就报错

# Boolean Array and Masks

## Comparison

<, >, ==, !=, <=, >=六种比较运算都可以进行向量化的运算，不用通过循环来遍历整个数组，比较结果是boolean类型的数组

可以通过np.count_nonzero()函数来计算比较值为True的数量，如np.count_nonzero(x < 6)，另一种方法就是用np.sum()函数来累加计算，而使用sum()函数的一个优点就是可以指定维度，比如计算每一行或每一列的满足条件的数量

用np.any()函数和np.all()函数可以检查是否全为True或是否有一个为True，这两个函数也可以指定维度

## Boolean Operators

python有内置的位运算操作符&, |, ^, ~，这些运算符在numpy中进行了重载，变成了对于数组的element-wise的逻辑运算操作符

这些运算符的优先级高于>, <等比较运算符号，所以进行逻辑运算时要注意使用括号

python内置的and和or等逻辑运算符是将操作数当作一个整体，而&, |等位运算符是将操作数分解成最小的个体(二进制的位)来按位运算，所以重载到numpy中，位运算符便是对数组中的每个最小个体(即元素)进行操作，而对numpy数组进行and和or的运算，便是将数组作为整体进行比较

## Boolean Array as Masks

对于一个数组，我们可以得到它对于某个条件的是否满足的逻辑数组，如x < 5，还可以用x[x < 5]来得到一个一维的数组，其所有值都满足比较运算的条件，然后我们就可以对这些满足条件的数据做某些操作

# Fancy Indexing

可以通过传递一组数组indices来访问数组中的元素，这种方法被称为fancy或者vectorized indexing，可以允许我们访问和修改复杂的子数组

## Exploring Fancy Indexing

当传递array作为index时，index的shape决定了获取的子数组的shape，而不是原数组的shape，传递的index数组也服从broadcasting rules

## Combined Indexing

可以将fancy index和simple index混合使用，会进行broadcasting；可以将fancy index和slice结合，比如x[1:, [2, 0, 1]]；可以将fancy index和masking结合，这样将只选取mask数组对应为True的元素

## Modifying Values with Fancy Indexing

通过fancy indexing赋值时，这不是一个vectorized操作，而是根据index array的顺序逐个赋值，比如x[[0, 0]] = [4, 6]，那么x[ 0 ]最终将等于6。对于x[ i ] += 1，最后的值并不会累加起来，因为对于这种简写，实际上是x[ i ] = x[ i ] + 1，而x[ i ] + 1在最初就已经赋好值了。如果想进行累积操作，需要使用at()函数，如np.add.at(x, i, 1)

# Sorting

## Sorting Arrays

np.sort()函数可以对数组进行更快的排序，相较于python原生的排序函数来说，如果对数组直接进行操作，如x.sort()，将会改变原数组的值的顺序，这个函数可以通过axis参数指定轴

np.argsort()将会返回排序后相对于原数组的index数组

np.partition(array, k)函数可以将函数最小的前k个值移到最前，剩余的数不保证排序，最前的k个值也不保证排序，只保证他们是所有值中最小的k个，这个函数可以通过axis参数指定轴

np.argpartition()可以返回原数组经过partition后的index，是完整的index array

# Structured Data

## Structured Arrays

可以通过对ndarray的列命名和声明构建一个结构化的array，比如data = np.zeros(4, dtype = {'names':('name', 'age', 'weight'), 'formats':('U10', 'i4', 'f8')})，这样就可以通过data[ 'name' ]这样来访问列，以上是通过字典形式来声明，也可以使用列表形式，如np.dtype([('name', 'S10'), ('age', 'i8'), ('weight', 'f4')])

## Compound Types

在声明数据类型的时候，可以在第3个参数位置来声明shape，形成一列中的每个数据又是一个ndarray

## Record Arrays

可以通过np.recarray来将结构化数组的列名作为array的属性，比如data_rec = data.view(np.recarray)，假如data有age列，不使用该方法，要访问age列就要data[ 'age' ]，使用该方法可以data.age这样访问，但是record array访问的速度比原生访问方法要慢

# Pandas Objects

pandas objects可以被看作功能强化的Numpy structured arrays，行和列通过labels进行索引，而不是简单的整数值索引

pandas的数据结构有3种，Series，DataFrame和Index

## Series

pandas series是一个具有索引的一维array，可以通过list和array来建立，比如pd.Series(data, index = index)，其中index参数是optional，如果没有指定index则会生成默认index

可以通过array和dictionary这两种观点来看待一个Series，所以也可以以建立字典的方式来建立一个series

### Series as NumPy Array

1d numpy array和pandas series的本质区别就是，numpy array只有一个内置的默认的索引，而series有一个可由用户自行定义的index

### Series as Speciallized Dictionary

与python的dictionary相同，series可以通过任意一个key去访问任意一个value，但是二者不同的点是，series是指定数据类型的，比python的动态类型要高效

## DataFrame

与series一样，DataFrame也可以被看作Numpy array或者Pyhton dictionary

### DataFrame as Generalized NumPy Array

如果series是一个具有指定索引的一维array，那么dataframe就是具有行索引和列索引的二维array，同时也可以认为dataframe是一个1维array，每个元素是一个series，此时的index依然是原来的行索引，列索引被称为columns

### DataFrame as Specialized Dictionary

如果把dataframe看作dictionary，那么dataframe是通过columns来map每一个series元素

### Contructing

#### from a single series object

pd.DataFrame(data, columns = [ 'columns' ])用来建立dataframe

#### from a list of dicts

任何一个list of dictionary都可以被转换成dataframe，在这个过程中可能有些值是缺失的，这时pandas会用NaN(Not a Number)值来填充

#### from a dictionary of series objects

#### from a two-dimensional numpy array

对于一个2darray，可以将其作为数据转换成一个dataframe，但是需要通过参数指定colums和index

#### from a numpy structured array

## Index

pandas的index可以看作一个不可修改的array，或者一个有顺序的set

### Index as Immutable Array

index跟array十分相似，唯一的不同就是不可被修改

### Index as Ordered Set

index跟python内置的set类型非常相似，所以可以使用unions，intersections，differences和其他的combinations函数进行选取

# Data Indexing and Selection

## Data Selection in Series

如前面所说，series可以被看作1d numpy array或者python dictionary

### Series as Dictionary

任何对python dictionary的操作，都可以作用在series上

### Series as One-Dimensional Array

series是建立在dictionary-like interface上的，并且提供array-style的selection，可以使用numpy array的slice，masking和fancy index这些特性

但是通过指定的index和内置的默认index操作是不一样的，比如explicit index进行slicing是包含最后一个元素，而implicit index是不包含的。并且如果explicit index是整数的话，选取单个元素data[ 1 ]使用的是explicit index，slicing的时候却使用implicit index

因为pandas还是建立在python之上的，所以要能够使用python的基本操作，虽然这样会有confusion

所以pandas有两个属性loc和iloc，loc代表使用explicit index，iloc代表使用implicit index

## Data Selection in DataFrames

DataFrame可以被看作2d或者structured array，也可以被安坐dictionary of Series

### DataFrame as Dictionary

dataframe可以通过columns列索引来访问指定列，这时每一列就是一个series，同时也可以以attribute来访问列，但是只针对columns是string时，如果是数字就不可以使用，或者列名和dataframe内置的函数重名了也不行

以字典的观点来看dataframe，主要是因为我们通过列来进行操作，而非某一个特定的element

### DataFrame as Two-Dimensional Array

之前提到的，我们也将dataframe看作一个enhanced 2d array，主要原因就是pandas具有一个强大的index数据类型，可以通过列索引columns来选取一列，也可以用loc和iloc来选取行

对于列的选取，因为每一列是一个series，所以只能得到一列，即一个series，而对于行，可以使用loc或iloc进行slicing，masking等操作，如果使用loc和iloc，就可以将其看作2d array，不仅可以选取行，还可以选取列，对特定element进行操作

### Additional Indexing Conventions

对于dataframe的indexing有一些规范

1. dataframe的index是对列进行的，用loc和iloc的slicing是对行进行的
2. direct masking是row-wise而不是column-wise

# Operating on Data in Pandas

numpy的一个优点就是可以快速的以element-wise进行基本运算和复杂的操作，pandas继承了这些numpy的功能

但是一些一元ufuncs会保留index和column，而二元操作会合并index

## Index Preservation

因为pandas是基于numpy而形成的，所以numpy的ufuncs依然可以作用于pandas的series和dataframe上，这些ufuncs的结果都会保留index

## Index Alignment

对于二元操作，pandas将会合并index

### in Series

二元操作时，index是取的二者indices的并集，并且如果缺少对应index的话，该行的值会取NaN(Not a Number)

如果对于缺失值，不想用NaN填充的话，可以在调用函数的时候指定参数值fill_value，来给缺失值指定一个填充值

### in DataFrame

在dataframe中既有index，也有column，发生在series中的合并也作用于dataframe的index和column上

index和column的合并不关心它们在两个对象之中的顺序，最后的结果会自动sort，对于缺失值，也是使用与series一样的方法，通过指定参数fill_value

### between DataFrame and Series

对于dataframe和series之间的操作，结果与numpy中的一维数组与二维数组之间的操作结果相似，默认是以row-wise的方向进行broadcasting，如果想以column-wise的方向的话，可以通过参数axis实现，最终结果也会自动的合并index和column，缺失值以NaN填充

# Missing Value

目前主要有两类方式来表现缺失值，一种是利用mask在整体中指出哪些是缺失值，另一种是用一个sentinel value来表达缺失值

在mask这种方式，需要用一个独立于原数据的Boolean array来表达，或者占用原数据中的某一个bit来表明它的缺失状态

在sentinel这种方式中，可以针对不同的数据类型来指定不同的表达缺失值的方式，比如整数值用-9999表达，也可以全局都用NaN

无论哪种方式，都是有一定取舍的，单独的使用mask会需要占用额外的空间去创建一个Booelan array，而sentinel value又会减少valid value的范围，或者需要extra logic in CPU and GPU，所以没有一个通用的最优方法，不同的计算机语言使用了不同的方法

## Missing Value in Pandas

Pandas处理缺失值的方式主要依赖于Numpy，而numpy是没有原生表达缺失值的浮点类型的值，又由于numpy支持许多种数据类型，不像R语言一样只有4种主要的数据类型，所以不能用数据中的一个bit来标识缺失值

由于这些缺点和取舍，pandas有两种储存和操作null value的方法，默认的方法是用一个sentinel value，比如NaN或者None，取决于具体的数据类型，或者利用pandas提供的nullable data type来构建一个mask array来标识缺失值，这些缺失值以一个特殊的值，pd.NA来表示

None，NaN，和NA这三个值都有各自的缺点和优点

### None

对于某些数据类型，pandas使用None作为缺失值的标识，None是一个python原生的数据类型，它可以表示任何形式的缺失值，十分通用，但是缺点就是一旦用了这个值，那么根据pandas固定数据类型的原则，整个df或者series的数据类型就变成python的object类型了，数据操作的效率就非常低下

并且python的None值是不支持一些数据操作的，比如aggregation，所以pandas不使用None来表示numeric的缺失值

### NaN

NaN是一个特殊的浮点值，这个值的特点是，许多与NaN作运算的结果都会是NaN，不过可以用一些函数的nan版本，忽略掉缺失值

NaN的缺点是，这是一个浮点值，整数、字符串或者其他的数据类型中，没有一个与之等价的值

在pandas中，None和NaN是混用的，有时候你赋值为None，会自动转换成NaN，以提升效率

### pd.NA

在早期的pandas中，只有NaN和None两个值来标识缺失值，这就带来了一些缺点，主要的一点就是有些数据类型无法用这两个值标识，比如整数，后来pandas引入了nullable dtypes，用首字母的大小写来区分该数据是否含有缺失值，这样NaN，None和pd.NA都会转换成pandas的nullable类型

### Operation

isnull()函数可以生成一个Boolean mask来标明哪些值是缺失的

notnull()函数标明哪些值不缺失

dropna()函数返回一个去掉缺失值的版本的数据，不能只drop一个single value，而只能drop含有缺失值的整行或整列，默认情况下是drop所有含有缺失值的列，但是可以通过指定参数axis来换成drop行，同时也可以通过指定参数how和thresh来具体丢弃某些含有缺失值的行列

fillna()函数返回一个用指定值填补缺失值的版本的数据，可以指定参数method来表明填补的方式，比如ffile和bfill，对于df，同样可以指定参数axis来表明填补方式的方向

# Hierarchical Indexing

index中元素的数据类型可以是元组，这样可以简单的实现multi index，但是这种其实依然是一个对象作为一个index，不能选择这个元组中的某一个值来进行操作

pandas的MultiIndex数据类型可以为一个值创建多个index，这个multiindex是具有层次结构的，在第一层index下，可以有第二层index，一个第一层的index可以对应多个第二层的index

实际上，每一层额外的index，就代表这一个额外的维度，可以使用stack()和unstack()函数来将dataframe转换成multiindex的series，或者相反

pandas中最直接的创建multiindex的方式就是传入一组list或者array作为index，这种方式既可以对series生效，也可以对dataframe生效。如果以字典的方式创建，传入一组元组作为index，pandas也会默认的识别出来这是multiindex

以上都是implicit创建，也可以explicit创建，直接使用pd.MultiIndex类

multiindex创建后可以作用在任何series和dataframe上

也可以为multiindex的每一层指定一个name tag，便于理解每层index的意义，这实际上是为index的每个维度命名

在dataframe中，column和index实际是对称的，column也可以有multiindex

对于dataframe的multiindex，可以使用loc和iloc进行slicing，但是不能对行或列进行多维的slicing，比如data.loc[(:, 1), (:, 'HR')]，在tuple中对index或column进行多个维度的slicing是会产生error的，如果想要实现这种slicing，需要explicit的表示index slicing，步骤是创建一个IndexSlicing对象，idx = pd.IndexSlicing，然后data.loc[idx[:, 1], idx[:, 'HR']]

许多对于multiindex对象的slicing操作会因为index没有sort而产生错误，我们可以用最简单的sort_index()函数来对multiindex进行sort

对于通过unstack()函数将multiindex的series转换成一个二维的dataframe，可以通过指定参数level来表明要将哪一个层次的multiindex转换到column上

另一种将multiindex的series转换成二维dataframe的方式是使用reset_index()函数，这个函数会将所有的index全部投影到column上，并且包含series中的数据列，可以通过name参数指定数据那一列的column名。这个函数也有对应的相反作用的函数，set_index，可以将一个有多个column的dataframe转换成一个具有multiindex的dataframe，通过参数来指定哪些column作为index

# Concat and Append

pd.concat()函数可以用来拼接dataframe或者series，对于dataframe，默认情况下这个函数是以row-wise的方向进行拼接，但是也可以通过参数axis来指定方向

与np.concatenate()这个函数不同的是，pd.concat()函数会保留indices，即使这些indices中含有重复的

对于以上情况，可以通过指定参数verify_integrity来解决，如果该参数为true，那么如果有重复的index，concat()函数就会抛出一个异常

如果index不重要，可以通过参数ignore_index来忽略掉原有的index，concatenate后的新的数据将会用默认生成的index

如果想要保留原有的index，可以通过为每个不同data的index指定一个key，用于生成multiindex

对于dataframe的拼接，有时会有部分column是重复的，默认的操作是将缺失值用NaN填补，对应的是join参数的值为outer，也可以将参数值赋为inner，这样就只会保留共有的column。如果只想保留某一个dataframe的column，可以先对另一个dataframe以想保留column的dataframe进行reindex

因为直接进行拼接是一个很常用的操作，所以series和dataframe都有一个append()函数可以更方便的完成这个操作，这里的append()函数不会对原本的object进行修改，而是创建一个新的对象，所以这个方法效率不是很高

# Merge and Join

merge和join两个操作是高性能，在内存中进行的合并。pd.merge()函数的底层逻辑是关系代数

pd.merge()函数实现了多种类型的joins操作，one-to-one，many-to-one和many-to-many，这三种不同的类型，都可以通过merge()函数统一进行，具体使用哪一种，是根据传入的数据类型决定的

merge是以column为key进行匹配合并，大多数情况下index是不重要的，对于要合并的那列数据，merge()函数会自动的保留一定的顺序，只有在一些特定的情况下才会按index进行合并

## One-to-One Joins

即待合并的列中的数据都是一一对应的，那么就是非常简单的合并

## Many-to-One Joins

即待合并的列中的数据，在其中一个dataframe中是有多个同样的值，merge()函数会自动的正确的保留并复制这些一对多的情况，那些没有重复的列会重复

## Many-to-Many Joins

即待合并的那一列，在两个dataframe中都有多个重复的值，这时merge()函数会将这些重复的值一一组合，确保所有情况都被合并过

## Specification of the Merge Key

以上这些规则，都是merge()函数的默认应对方法，它默认需要合并的列的名称都是相同的，但实际上真正的数据大多并不是这样，而是需要合并的列，在不同的dataframe中有着不同的列名

对于两个dataframe有共同的列名时，我们可以通过指定on参数，来explicitly的指定要合并哪一列

对于想要合并两个dataframe中不同列名的列，可以用参数left_on和right_on来指定，但这样合并后的结果会产生两个相同的列，因为pandas不知道要用那个列名作为合并后列的名称，所以就将两个列名都保留下来，有两个重复的列

这个时候可以用drop()函数来指定drop掉多余的列

不仅可以merge column，还可以merge index，即row。merge index则需要指定参数left_index、right_index，这两个参数的值是True或Fals

每个DataFrame都有一个内置的函数join()，可以直接指定与其他DataFrame进行index-based merge，不需要其他的keywords

也可以同时进行column-based和index-based的merge，只需要每个参数都进行指定，并且merge操作同样适用于multi index和multi column

## Specifying Set Arithmetic for Joins

默认情况下，merge后的结果是取两df的intersection交集，也叫做inner join，我们可以通过指定参数how来指定set arithmetic，值可以是outer，left，right等，outer的结果就是df的union

## Overlapping Column Names

如果merge的两df含有同名的column，pandas会自动的加上suffixes，比如_x和_y这些，也可以指定参数suffixes来调整

# Aggregation and Grouping

对于同样适用于NumPy的aggregation操作，作用在series上时，返回值是single value，作用在dataframe上时，返回值是一个series，是对每个column进行这个aggregation操作，但是通过指定axis，可以指定aggregation是对每一行进行的

## Groupby

groupby()函数可以conditionally aggregate在一些label或者index上

groupby的操作可以分解为3个步骤

1. split：这一步是根据指定的label进行分割，按要求将数据split
2. apply：这一步是将所要进行的aggregation操作分别作用在split后的每一部分数据上
3. combine：将计算结果merge后返回一个output array

以上这些操作可以手动进行，但是使用groupby的好处是不需要将中间步骤实例化，也就是说可以节省开销，更加高效

因为groupby后的type其实是一个特定的类型，DataFrameGroupBy object，而不是一连串的DataFrame。所以每进行一个groupby操作，就一定要跟着一些操作，比如aggregate，filter，transform，apply，否则单独进行groupby只会得到一个特定的对象，而不是所需的结果

### Column indexing

groupby后的对象可以进行行方向的选取，即column indexing，可以选取某一行进行操作

### Iteration over groups

groupby后的对象支持直接在groups之间进行迭代操作

### Aggregate, Filter, Transform, Apply

#### Aggregate

aggregate method可以将多个aggregation操作同时计算出来

#### Filting

filting可以根据group属性来drop data

比如df.groupby('key').filter(filter_func)，将会得到根据filter_func进行drop后的结果，filter_func应该是表示哪些数据通过了filter，哪些被filt的Boolean值

#### Transformation

可以将groupby后的数据在进行一些分组后的操作后，再转换成input时的形式返回

#### Apply

apply函数可以允许你对group的结果施加任何function

施加的function应该接受一个DataFrame作为input，返回一个pandas object或者一个标量

### Specifying the Split Key

不仅可以按一个single column name进行split分组

分组的key可以是一个与df的index互相match的series或者list，来指定每一行被分到哪一个group

key也可以是一个字典形式的map，来指定不同的index被分到哪一组

也可以传递一个python function作为key，将会以index作为input然后执行传入的python function，再进行group和aggregation等操作

也可以将以上的这些key的选择结合起来，然后会得到一个multi index的结果

# Introduction To Matplotlib

matplotlib是基于numpy array，并且work with broader scipy stack，matplotlib最重要的一个feature是它在许多operating systems and graphics backends上工作的很好

matplotlib中的pyplot，简称plt，这个interface是最常用的

如果在script中使用matplotlib，那么就需要调用plt.show，这个function的功能是open one or more interavtive windows to display all currently active Figure objects。plt.show在每个python session中应该只使用一次，并且通常在script的结尾使用，multiple show会造成unpredictable behavior

如果在ipython shell中使用matplotlib，需要使用%matplotlib这条指令去进入matplotlib mode。使用这条指令后，plt command会打开一个figure window，并且further commands会在plot中update，但是有一些操作不会draw automatically，需要用plt.draw去force，plt.show在matplotlib mode中不是必需的

如果在jupyter notebook中使用matplotlib，同样需要使用%matplotlib命令，并且可以specify，如果是%matplotlib inline，将会embed static images，如果是%matplotlib notebook，则会embed interactive plot

matplotlib有两种interfaces，一种是convenient MATLAB-style state-based interface，另一种是powerful object-oriented interface

## MATLAB-style Interface

matplotlib最初是为MATLAB用户编写的，让python也可以作图，所有的MATLAB-style tools都包含在pyplot(plt)中

这种情况下，interface是stateful的，it keeps track of the current figure and axe，一旦建立了second figure，如果要再对first figure进行修改就会clunky

## Object-oriented Interface

这种interface适用于更加复杂的情况，相较于依赖active figure or axe这种notion，object-oriented interface的plotting function会explicit create Figure and Axes objects

# Simple Line Plots

在matplotlib中，figure is and instance of the class plt.Figure，即一个canvas，而axes is an instance of the class plt.Axes，是subplot，在object-oriented interface中，如果需要画subplot，就需要explicitly创建axes

如果要画多条lines，只需要多次调用plt.plot即可，并且可以指定参数color来调整颜色，指定linestyle来调整线的style

可以使用plt.xlim()和plt.ylim()function去调整两个轴的上下限；使用plt.axis()去调整轴的style；还可以使用plt.title()，plt.xlabel()和plt.ylabel()去调整整个图的title和两个轴的label；如果一个图中有多个数据，可以在plt.plot中指定每个数据的label，然后用plt.legend()标出

大多数的plt function都会translate directly to ax methods，比如plt.plot -> ax.plot，但是不是所有的commands都是这样，尤其是set limits, labels and titles，相较于call these functions individually，更常用的是使用ax.set()，可以set all properties at once

# Simple Scatter Plots

除了-和--来specify draw line plots，还可以用其他的keywords去指定画出不同的dots，circle或者其他shape，还可以将-和o结合起来用，绘制出带有dot的line plot

除了generally使用plt.plot，并指定shape去绘制scatter plot，还可以直接调用plt.scatter。plt.scatter与plt.plot最主要的区别是，properties of each individual points can be individually controlled or mapped to data，比如调整color和size，这样可以通过color和size去convey information，这实际上是变相的增加了信息维度，而plt.plot不行，它只能对整体进行调整

不过对于较大的datasets来说，plt.plot的效率比plt.scatter要高很多，原因就是plt.scatter可以对每个point进行individually的调整，而plt.plot是保证所有point都是一样的，所以the work of determining the appearance of the points in done only once

# Errorbars

## Basic Errorbars

可以用plt.errorbar()去create a basic errorbar，参数fmt用来control the appearance，除此之外，还有很多其他的参数可以customize the errorbar plot

## Countinuous Errors

matplotlib没有built-in的function去创建errorbars on countinuous quantities

可以用plt.fill_between()来实现countinuous errorbar的效果

# Density and Contour Plot

可以用plt.contour去创建一个contour plot，其中有三个基本参数，x, y, z，x和y对应着在plot中的位置，z对应着contour levels，还可以指定参数cmap，用colormap更好的展现第三个维度

如果觉得plot的留白会distracting，可以使用plt.contourf去创建filled contour plot，参数和plt.contour一样

可以额外使用plt.colorbar()，如果需要add information with labeled color，这样可以区分出peak和valley

如果觉得discrete的颜色不够美观，可以用plt.imshow to generate a smooth representation

# Histograms and Binnings

histogram和bar plot的区别是，histogram可以展现一种数据的distribution

可以直接用plt.hist()去创建一个histogram

如果想创建二维的histogram，也可以直接用plt.hist2d()function，然后用plt.colorbar()去标注count

如果想创建一个更加美观的二维histogram，可以使用plt.hexbin()去创建一个grid为六边形的2d hist，参数和plt.hist2d()一样

# Customizing Legends

legends assign meaning to the various plot elements，最简单的创建legend的方式是直接使用plt.legend()，可以通过指定参数loc来改变legend的位置，ncol来改变number of columns，还有很多其他的参数来指定appearance

默认情况下legend会包含所有labeled elements，如果只需要绘制出某些数据的legend，可以向plt.legend()中传递参数，指定绘制需要的labels。不过更清晰的方式是多次调用plt.plot()，一条条的绘制出每一个需要label的data

# Customizing Colorbars

legend identify discrete labels，而对于continuous labels，labeled colorbar can be a great tool

availabel colormaps都在plt.cm namespace中，选择合适的colormap是非常subtle的

有三种类型的colormaps

- sequential colormaps：these are made up of one continuous sequence of colors，这种cmap的range是even brightness，所以information是连续的
- divergent colormaps：these contain two distinct colors，这种cmap由于是dual-color，所以可以展现出positive and negative deviations
- qualitative colormaps：these mix colors with no particular sequence，这种cmap的范围很大，但是是uneven brightness，可能会emphasize unimportant information

colorbar自身实际上是an instance of plt.Axes，所以可以对其做出很多变化，比如如果有很多noise影响的plot，可以指定参数extend来扩展color的范围，使其更加清晰

colormap默认情况是continuous的，但是也可以指定为discrete，通过plt.cm.get_cmap()function实现

# Multiple Subplots

subplot其实就是axes，创建一个axes最基础的方式是plt.axes()function，其接受一个optional argument of list，这个list中的4个值分别是left, bottom, width和height，从bottom left到top right的range是0到1

在object-oriented interface中，plt.axes的equivalent是fig.add_axes()

对于MATLAB interface，则是通过plt.subplot()，并指定subplot的row和column，从左上角到右下角依次编号实现

plt.subplots()相较于MATLAB interface中的plt.subplot()，多了一个s，这个function可以一次性创建多个subplots

to go beyond a regular grid of subplots，可以使用plt.GridSpec()，这种方式创建出来的figure，可以进行slicing，从而令一个subplot使用多个subplots所占据的空间

# Categories of Data Visualization

there are five categories of plots: Comparison, Sequence, Distribution, Relationship, Part-whole

## Comparison

### Bar charts

bars can lie horizontally or vertically, the length or height of the rectangular bars depict the value of the data, this chart can easily compare the values

### Paired bar(a variation of bar charts)

if you want to show comparisons within categories, you can specify another bar under the same variable

for example, to compare the number of people of each country, you can specically compare the number of men and women, which means divide whole people into two parts

### Stacked bar(a variation of bar charts)

paired bar chart shows two or more data values for each category, but it subdivides the data within each category

with stacked bar, you still have one bar under each category like simple bar chart, but you use some way like differnet color to sign the different subgroup

the drawback of this kind of chart is it can be difficult to compare the different value of the segments within the chart, because they don't start in the same endpoint

### Dot Plot(a variation of bar charts)

it likes paired bar, but use dot to specify the value, and use a line to connect two or more subgroups to show the difference between each subgroup under each category

### Heatmap

it uses colors and color saturations to represent data values, it often used to visulize data when patterns and frequency are more important than exact data

because it adds another dimension, so it can compare both across and within categories

## Sequence

### Line Chart

data values are connected by lines to show values in a sequence, this kind of chart helps with the detection of trends and patterns

there isn't limitation of the number of sequences you can include in a single line chart, so the final chart is comprehensive

### Area chart & Stacked Area chart

area chart is line graph with the area below the line filled in, giving the series more visual weight

stakced area chart can show the whole data in one chart rahter than showing independently

there are two options, stack on the total sum or percentage

## Distribution

### Histogram

it's a specific kind of bar chart that presents the frequency of data

the difference between bar chart and histogram is, the two axis in bar chart represent counts and categories, but in histogram, the graph focus on the data of one category, one axis represents the different values of category, another axis means the counts of each value

### Histogram with Error bars

it's not a strict histogram, because it's still a bar chart, but with error bar, it can tell the distribution information of data

### Box-and-Whisker plot

box plot in short, it shows the median, Q1 and Q3, two whiskers end at two extream, and you can tell the outliers throught this plot

you can place the box plots of each category together like a bar chart, which can tell more information

### Violin chart

an element of violin chart is the transverse shape of distribution, then place them into one chart, you can compare each category and see the distribution of them

### Strip plot

it likes the bar chart, but rather than use a rectangle(bar), this graph plots the data points in a line, then user can see the distribution

some data points in strip plots can become obscured because it's too dense, so you can use different colors or place them separatly

### Higher dimension

heatmap can be used to visualize 2 dimension, also called 2d histogram

## Relationship

### Scatter plot

it's the most common way to visualize the correlations between two variables

### Bubble plot

it can be called bubble scatter plot by varying the size of the circles according to a third variable, which add the dimension to the representation

### Correlation matrix

the matrix list the correlation coefficien between each category

with numbers, it would be hard to tell the relationship, but you can use color density or sized shape to reveal the patterns

### Tree diagrams

tree diagrams show levels of hierarchy

## Part-to-whole

### Pie charts

it indicates how a whole consists of parts through slice of a pie

### Treemap

it uses tree structure

# Data Cleaning

perfect data对应的是一组数据，满足
1. 每一行都是一个unique的instance
2. 每一列都表示一个single的变量
3. 每一个值都应该是complete, valid, correct

imperfect data会导致一系列可能的问题，而data cleaning就是the process of reducing the imperfections of imperfect data

对于data cleaning，一共有五个topics：duplicate instances, compound variables, missing data, data validation和data correctness

## Duplicate instances

duplicates会alter the distribution of variables，尽管duplicates不一定是harmful的

duplicate的impact取决于
1. 哪些records是duplicated
2. duplication有多频繁
3. 具体的task

有时duplicity是非常subtle的，比如，如果data是从不同的来源得到的，那么这些不同的来源可能会将相同的数据以不同的measurement来记载，尽管它们看上去不是明显的相似，但是实际上是duplicate；有时一些application还会将超过boundary的值记为相同的

在一些dataset中会有identifier，可能会出现重复项的identifier不同这种情况

definition of duplicity can be extended，比如一些非常相近的值可以被视作duplicate

## Compound variables

compound variable是一个实际上包含多个变量的单个变量，这种variable既可以是incohesive的，比如由于输入错误，将两个值输入到一个变量中；也可以是cohesive的，比如将年月日储存在一个变量作为日期

user可以通过observation, domain knowledge, metadata和experts来identify incohesive compound variables

对于cohesive compound variables，可以根据task的需求和feedback from task来决定是否需要split

通常情况下是将compound variable转换为string type，便于处理

## Missing data

对于missing data，没有统一的处理方式，因为：不同的软件有不同的表示missing value的方式；不同的missing value也包含了不同的信息

由于representation的多样，所以treatment应该做到
1. 能够识别出dataset中的representation of missing data
2. 知道target environment是如何represent missing data的
3. 保证treatment process的integrity

user可以通过textual queries或者visualization来对missing data有一定的认知。textual，比如missing values的数量、有1个或n个missing values的data instance的数量、哪些variables含有missing values；visualization，可以直观的展示出各个variables的missing values的distribution

一个missing value既可以是legitimate，比如在survey中允许不回答问题；也可以是illegitimate，比如跳过了必答题

不同的missingness所对应的treatment也不同，有如下三种mechanism
1. Structural deficiencies：missing是一个定义过的value，即允许missing的存在，并且有对应的表达方式
2. Random occurrences：以下任何一个子类都是
    - Missig completely at random(MCAR)：任何一个data point的value是missing的likelihood都是相同的
    - Missing at random：likelihood不同
    - difficult to distinguish
3. Specific causes：也叫做not missing at random(NMAR)，即missing不是根据概率随机的，而是有一定原因导致的

### Treatment

#### Ignoring

ignore missing value既可能是necessary的，比如missingness是meaningful的；也可能是advisable的，比如在较大的dataset中只有很少一部分legitimate missing values；还有可能是harmful的，比如dataset具有severe missingness

#### Deletion

有两种delete方式，listwise deletion，将data instance给删掉；和variable deletion，如果某个variable的missingness非常严重，那么可以直接将这个variable去掉

在实际应用中，data instances一般比variables更重要，所以应当优先保留data instance

deletion的优点是简便，不需要大量的计算

缺点是可能因为删除掉legitimate missing values导致信息丢失；对于MCAR的data，missingness不是biased，删除的数据可能会很多；当dataset的数据较小时，deletion可能是harmful的；如果missingness非常严重，删除可能导致sample效果较差，得到poor result

#### Imputation

这种方式根据non-missing values相互之间的relationship来为missing values提供一个estimate来填补空缺，通常用在illegitimate missing data上

imputation可以分为两大类
1. Parameterized：imputation technique去猜测variable的distribution
    - Mean substitution：基于一个variable
    - Linear imputations：基于多个variables
    - Maximum likelihood：multivariate
    - Expectation-Maximization：multivariate
    - Multiple Imputation：multivariate
2. Non-parameterized：imputation techniques不对missing values作任何assumption of distribution
    - Non-parametric Multiple Imputation：multivariate
    - Machine Learning：multivariate

##### mean substitution

这种方式直接将missing value用该variable的mean替代，也可以extend为median或者mode

优点是方便快捷，计算量小，但是缺点是存在bias，并且如果variance较高或者data不是MCAR，表现通常不佳，尤其是MNAR的情况

##### multiple imputation

简称为MI，主要思想是最小化bias

主要过程就是通过多种不同的imputation方式，得到多个imputed dataset，然后将这些dataset通过某些方式合并，得到最终的结果

由于imputation不仅基于原本的data，也基于生成多个imputed dataset的random process，所以极大的消除了bias

MI的优点是对MCAR和MAR的效果非常好，并且在某些情况下，对MNAR的效果也不错

缺点是计算量非常大，并且要用多少个imputed dataset，要如何将它们合并也是需要user自行决定的

##### Machine Learning techniques

machine learning imputation，简称为MLI

由于ML主要用在预测target variable上，这对于missing value来说也是一样的，MLI通常不需要search for an underlying distribution，下面以kNNI为例

当impute a value for variable V时，kNNI计算与具有缺失值的instance最相似的k个data instance，并且这些instance都必须是complete的

然后，kNNI基于这k个data instance，以central tendency of the values of V来impute missing value

kNNI的优点是对于不是特别大的dataset时，计算量较小，并且可以用在MCAR和MAR的data上。但是对于较大的dataset，计算量很大，并且依赖于complete data instance，还对outlier敏感

## Data Validation

data validation是一个确保data满足某些certain assumption的过程，这个过程主要基于validation rules，这是一些statements，既包含一些general knwoledge，对于不同用途的数据还有特定的domain knowledge

## Data Correctness

data correctness意味着value与它被预期的representation相同

character of data是基于recorded instance所得到的，correct data表示values符合其character，而那些不符合的称为nonconforming instance或者extreme instance或者anomaly

识别出nonconforming instance的过程通常称为outlier detection。如果outlier is weak or less extreme的话，这种outlier称为noise

outliers既可以是harmful的，比如会影响到真实的pattern等；也可以是useful的，比如outlier是我们需要的target

outlier可能的source有：收集数据时产生的错误，外部因素，sample不当，transform造成的，或者其他难以解释的原因

### Categorization of Outliers

基于不同的standpoint，可以将outliers分为不同的类别

基于number of data instance，可以将outlier分为point outliers，即单个data point就是outlier，或者collective outliers，即单个data point不是outlier，但是多个points在一起就是一群outliers

基于context，在一定的条件下，一些data points被认为时outliers，但是在其他的条件下，它们又不是outliers

基于scope of comparison，outlier可以被分为local outlier和global outlier，local outlier是与其最近的neighbors比较起来是outlier，global outlier是与整个dataset比起来都是outlier

基于variables可以分为univariate和multivariate，univariate是基于一个variable决定的，而multivariate是基于多个variables

### Approaches for Outlier Detection

#### Nearest Neighbor

这种方式是假设normal data instance are closer to their neighbors，从而形成一个dense neighborhood，而outliers是远离这些neighbors的

有两种主要的方式，一个是kNN，即计算k个最邻近的距离，然后划分radius，如果超过一个threshold的话就是outlier；另一个是pre-specified radius，即user自行决定neighborhood的半径，如果该半径的neighborhood内没有足够的data points，那么该data point就是outlier

#### Clustering-Based

这种方法假设normal data属于某个large and dense clusters，而outliers属于small或sparse clusters，或者不属于任何clusters

### Handling of Harmful Outliers

对于harmful outliers有如下几种处理方式

1. removal：这种方法简单直接，但是会reduce sample size并且introduce bias or information loss，从而skew the results

2. outlier robust data-oriented solutions：即使用对outliers不敏感的算法来完成task，不对outliers进行处理

3. correction：可以通过transformation将outlier fold为normal instance，但是这种方法不保证一定有效，并且transforme后的data可能会变得难以去interpret；或者使用expert knowledge去modify the unrealistic values，即直接对不满意的data instance进行directly manipulate，不过这样可能会introduce bias