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