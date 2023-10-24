# SQL

## SQL查询语言概览

SQL有以下几个部分：

- 数据定义语言(DDL)：提供定义关系模式、删除关系以及修改关系模式的命令
- 数据操纵语言(DML)：提供从数据库中查询信息，以及在数据库中插入元组、删除元组、修改元组的能力
- 完整性：SQL DDL包括定义完整性约束的命令，保存在数据库中的数据必须满足所定义的完整性约束
- 视图定义
- 事物控制
- 嵌入式SQL和动态SQL：定义如何嵌入到通用编程语言，如C和Java
- 授权

## SQL数据定义

数据库中的关系集合必须由DDL指定给系统。SQL的DDL不仅能够定义一组关系，还能够定义每个关系的信息

### 基本类型

SQL标准支持多种固有类型，包括：

- char(n)：固定长度的字符串，用户指定长度n
- varchar(n)：可变长度的字符串，用户指定最大擦还能够读n
- int：整数类型
- smallint：小整数类型
- numeric(p, d)：定点数，精度由用户指定。这个数有p位数字(加上一个符号位)，其中d位数字在小数点的右边
- real, double precision：浮点数和双精度浮点数
- float(n)：精度至少为n位的浮点数

### 基本模式定义

用**creat table**命令定义SQL关系，creat table命令的通用形式是：

creat table r  
    (A1 D1,  
    A2 D2,  
    ...,  
    An Dn,  
    <完整性约束1>,  
    ...,  
    <完整性约束k>);

其中r是关系名，每个Ai是关系r模式中的一个属性名，Di是属性Ai的域

SQL支持许多不同的完整性约束，如：

- primary key(Aj1, Aj2, ..., Ajm)：表示属性Aj1, Aj2, ..., Ajm构成关系的主码。主码属性必须非空且唯一
- foreign key(Ak1, Ak2, ..., Akn)references s：表示关系中任意元组在属性(Ak1, Ak2, ..., Akn)上的取值必须对应于关系s中某元组在主码属性的取值
- not null：一个属性上的not null约束表明在该属性上不允许空值

insert命令将数据加载到关系中，如：  
inssert into instructor  
    values(10211, 'Smith', 'Biology', 66000);  
值被给出的顺序应该遵循对应属性在关系模式中列出的顺序

delete命令从关系中删除元组，如：  
delete from student;  
从student关系中删除所有元组，其他格式的删除允许指定待删除的元组

drop table命令从数据库中去掉一个关系，如：  
drop table r;  
drop table命令从数据库中删除关于被去掉关系的所有信息，比delete from更强，不仅删除r的所有元组，还删除r的模式

alter table命令为已有关系增加属性，如：  
alter table r add A D;  
r是现有关系的名字，A是待添加属性的名字，D是待添加属性的域  
alter table r drop A;  
从关系中去掉属性，r是现有关系的名字，A是关系的一个属性的名字

## SQL查询的基本结构

SQL查询的基本结构由三个子句构成：select、from和where。查询的输入是在from子句中列出的关系，在这些关系上进行where和select子句中指定的运算，然后产生一个关系作为结果

### 单关系查询

select 属性  
from 关系

eg：  
select name  
from instructor;

因为一个关系中，同名的属性可以出现不止一次，所以可以通过在select后加入关键词distinct来强行删除重复，而关键词all可以用来显式指明不去除重复。select子句还可带有+、-、*、/运算符的算数表达式，运算对象可以是常数或者元组的属性，但这种运算不会对关系产生任何改变

where子句允许我们选出在from子句的结果关系中满足特定谓词的元组，并且where子句中可以使用逻辑连词and、or和not，逻辑连词的运算对象可以是包含运算符<、<=、>、>=、=和<>的表达式

### 多关系查询

select A1, A2, ..., An  
from r1, r2, ..., rm  
where P;

每个Ai代表一个属性，每个ri代表一个关系，P是一个谓词。如果省略where子句，则谓词P为true，就会输出笛卡儿积。在可能出现相同的属性名前加上关系名作为前缀，表示该属性来自于哪个关系；对于那些只出现在单个模式中的属性，通常去掉关系名前缀

通常来说，一个SQL查询的含义可以理解为：

1. 为from子句中列出的关系产生笛卡儿积
2. 在步骤1的结果上应用where子句中指定的谓词
3. 对于步骤2结果中的每个元组，输出select子句中指定的属性

### 自然连接

自然连接运算作用于两个关系，并产生一个关系作为结果。不同于两个关系上的笛卡儿积，它将第一个关系的每个元组与第二个关系的所有元组都进行连接；自然连接只考虑那些在两个关系模式中都出现的属性上取值相同的组对

结果关系不会重复列出那些在两个关系模式中都出现的属性。属性列出的顺序是：先是两个关系模式中的共同属性，然后是那些只出现在第一个关系模式中的属性，最后是那些只出现在第二个关系模式中的属性

对于SQL查询：  
select name, course_id  
from instructor, teaches  
where instructor.ID = teaches.ID;  
可以写成：  
select name, course_id  
from instructor natural join teaches;

自然连接运算的结果是关系，从概念上讲，from子句中的"instructor natural join teaches"表达式可以替换成执行该自然连接后所得到的关系，然后再这个关系上执行where和select子句。  
所以，在一个SQL查询的from子句中，可以用自然连接将多个关系结合在一起，如：  
select A1, A2, ..., An
from r1 natural join r2 natural join ... natural join rm  
where P;

为了发扬自然连接的优点，同时避免不必要的想等属性带来的危险，SQL提供了一种自然连接的构造形式，允许用户来指定需要哪些列相等。例如：  
select name, title  
from (instructor natural join teaches) join course using (course_id);

join ... using运算中需要给定一个属性名列表，其两个输入中都必须具有指定名称的属性。  
r1 join r2 using(A1, A2)，与r1和r2的自然连接类似，只不过在t1.A1 = t2.A1并且t1.A2 = t2.A2成立的前提下，来自r1的元组t1和来自r2的元组t2就能匹配，即使r1和r2都具有名为A3的属性，也不需要t1.A3 = t2.A3成立

## 附加的基本运算

### 更名运算

