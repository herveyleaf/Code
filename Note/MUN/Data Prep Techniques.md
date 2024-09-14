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