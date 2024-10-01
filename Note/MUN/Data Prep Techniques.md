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