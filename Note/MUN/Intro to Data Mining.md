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

