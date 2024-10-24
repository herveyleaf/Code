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