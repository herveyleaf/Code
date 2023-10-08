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