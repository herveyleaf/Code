检查版本 numpy.__ version __

查看某个namespace内的函数 np.< TAB >

查看帮助文档 np?

建立指定数据的数组 np.array(size, dtype)

创建全是0的数组 np.zeros(size, dtype)

创建全是1的数组 np.ones(size, dtype)

创建全是指定数字的数组 np.full(size, number)

创建一个指定区间和步长的线性数组 np.arange(begin, end, step)

创建一个指定区间被等分的线性数组 np.linspace(begin, end, cut)

创建一个值在0到1之间的伪随机数组 np.random.random(size)

创建一个符合正态分布的数组 np.random.normal(mean, deviation, size)

创建一个单位矩阵 np.eye(integer)

创建一个未初始化，显示内存值的数组 np.empty(size)

创建一个numpy的随机数生成器，一般将其赋值给一个变量rng，需要指定种子 rng = np.random.default_rng(seed=1701)

使用随机数生成器生成随机整数数组，如果不指定上限，则默认为0到low x1 = rng.integers(low, up, size)

使用随机数生成器生成随机浮点数数组 x2 = rng.random(size)

每个数组都有一些基本信息，可以通过x3.attribute来查看，ndim表示维数，shape代表数组维数的形状，size表示总共有多少个元素，dtype表示数据类型

对于一个指定好数据类型的数组，如果试图将其中元素的值改为不同类型的数，numpy将会进行类型转换

可以通过x[ start:stop:step ]来对数组进行切片，获取子数组。对于多维数组，可以用逗号,来分开对不同维数的切片x[d1, d2]

一维数组可以通过x[ index ]指定访问某个值，而对于多维数组，可以通过不同维度的index来指定访问某个维度的特定值，x[:, 0]就是访问每一行的第一个值

numpy数组的切片，依然是指向原数组的，对子数组进行修改会影响到原数组

可以在切片后使用copy()函数，将子数组复制一份，而不是以view的形式，比如x_sub_copy = x[:2, :2].copy()，这样对子数组进行修改将不会影响到原数组x

可以使用reshape(size)函数对数组的维数进行重构，但是元素的数量必须符合size，一般将一维数组reshape成二维，比如grid = np.arange(1, 10).reshape(3, 3)，并且reshape的数组也是no-copy的，对reshape数组进行修改会影响到原数组

可以将np.newaxis放在所要新增的维度的位置来创建新的维度

可以使用np.concatenate(array)来合并数组，合并的数组必须有相同的维数，优先从第0维开始合并，可以通过指定参数axis来改变合并方向

对于不同维数的数组，可以使用np.vstack()或np.hstack()函数来进行合并，所合并维度的值的数量需要匹配

对于分割数组，可以使用np.split(array, [ indices ])来指定要分割的数组和分割点

可以使用np.vsplit()和np.hsplit()函数来进行二维的分割

numpy的+ - * / // ** %等操作都进行了重载，可以对数组之间或者数组和数字之间进行向量化计算

可以使用np.absolute()或者简写为np.abs()来对数据取绝对值，比python原生的abs()函数的效率要高

numpy对三角函数、反三角函数也进行了重载，可以传递数组作为参数

对于指对数，可以使用np.exp2(x)来表示2的x次方，或者np.power(2, x)来表示；可以使用np.log2(x)来表示log2(x)，如果传递的参数x非常小，可以用np.expm1(x)或者np.log1p来进行计算，可以得到更高的精确度

对于复杂的科学计算，可以导入scipy包中的special模块来进行计算

如果想将计算值赋值给某个变量，可以通过指定参数out来完成，这个过程不需要将数据暂存一份，如果像y = 2 ** x这样赋值，就会先暂存一份2 ** x然后再赋值给y

如果要对numpy的元素进行累积操作，可以用np.operation.reduce(array)来得到累积操作的值，operation为add、multiply等操作，reduce()函数只会显示最后的结果，如果需要计算过程中的所有中间值，可以使用accumulate()函数

如果需要对所有元素进行两两配对的遍历，可以使用outer()函数，比如np.multiply.outer(x, x)

numpy重载了sum(), mean(), min(), max()等函数，效率比python原生的更高，可通过axis参数指定计算维度，对于aixs，作用是折叠指定的轴，为0则是折叠第0个轴，沿着第0维的索引向下搜索，为1则是沿着第1维的索引搜索

numpy对于shape不同的array可以进行broadcast，但是需要符合规则

- 如果两个array在维度数量上不同，那么维度少的那个array将会用leading side的element来填补出一个新维度，比如一维数组扩展成2维数组，leading side是一维的各个元素，它们将一起组成二维的一个元素，array[1, 2] -> array[[1, 2]]

- 如果两个array有不匹配的维度，两者之间有一个在该维度的shape是1，那么就可以将其stretch成相同shape

- 如果有任意一个维度的size不匹配且不为1，即不能stretch，那么就会报错

通过这些聚合操作，可以将数据中心化，即使其均值为0

numpy重载了>, <, ==, !=等比较运算，运算结果是一个对应shape的boolean数组

由于python规定Boolean值为False，其int值为0，True值为1，所以可以用np.count_nonzero()函数来计数满足条件的个数，但是这个函数只能得到总数

通过np.sum()函数中指定axis轴，可以得到不同维度的计数

可以用np.any()和np.all()来分别检测数组中是否有任意一个满足条件的值，或者检测数组的值是否全部满足条件，这两个函数同样可以指定轴

对于numpy的ndarray，不能使用python内置的and, or等逻辑运算符进行逻辑运算，需要使用重载后的位运算符。重载后的位运算符会将ndarray的每个对应元素进行逻辑运算，得到一个Boolean数组。&代表与运算，|代表或运算，~代表非运算，^代表异或运算

Boolean数组可以作为mask，来选择数据的特定子数组，通过比较运算和逻辑运算得到了对应条件的Boolean数组，可以通过x[ boolean_array ]来选取满足条件，即值为True的元素

ndarray可以通过传入一个索引array进行复杂的slice操作，并且索引array可以写成多维数组，这样得到的子数组也是多维数组

对于多维数组的fancy index，与普通的索引是一样的，不同维度的index用逗号,分开，可以传入array，也可以传入多维数组，这样得到的也是多维数组

fancy index可以和普通的index结合使用，与mask结合使用

np.random.choice(sample, size, replace)可以对sample数组进行size个数的随机采样，如果replace为True，那么会出现重复，为False不会

使用fancy index对数组进行修改或赋值操作，不是vectorized操作，如果对同一个元素进行了多次操作，那么是按fancy index的顺序依次进行的，比如x[[0, 0]] = [4, 6]，最后x[ 0 ]的值将为6

但是如果对相同的元素做+=操作，将不会进行多次累加，因为x[ ind ] += 1其实是x[ ind ] = x[ ind ] + 1的缩写，而x[ ind ] + 1的值在最开始就已经决定了，这样只是将同一个元素多次赋了同样的值

如果想对array进行重复的操作，可以使用at(array, indices, num)函数，如np.add.at(x, ind, 1)表示对array x的ind这些元素做加法，这是一个可以累积的操作

np.sort()用于排序，也可以对ndarray直接调用sort()函数，直接调用的话就是一个in-place的函数，这个函数同样可以通过指定axis来进行行排序或者列排序

np.argsort()可以返回原数组排序后对应的index

np.partition(array, k)函数可以将函数最小的前k个值移到最前，剩余的数不保证排序，最前的k个值也不保证排序，只保证他们是所有值中最小的k个，这个函数可以通过axis参数指定轴

np.argpartition()可以返回原数组经过partition后的index，是完整的index array

可以通过对ndarray的列命名和声明构建一个结构化的array，比如data = np.zeros(4, dtype = {'names':('name', 'age', 'weight'), 'formats':('U10', 'i4', 'f8')})，这样就可以通过data[ 'name' ]这样来访问列，以上是通过字典形式来声明，也可以使用列表形式，如np.dtype([('name', 'S10'), ('age', 'i8'), ('weight', 'f4')])

在声明数据类型的时候，可以在第3个参数位置来声明shape，形成一列中的每个数据又是一个ndarray

可以通过np.recarray来将结构化数组的列名作为array的属性，比如data_rec = data.view(np.recarray)，假如data有age列，不使用该方法，要访问age列就要data[ 'age' ]，使用该方法可以data.age这样访问，但是record array访问的速度比原生访问方法要慢