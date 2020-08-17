#分组函数
/*
 功能：用作统计使用，又称为聚合函数或统计函数或组函数
 
 分类：
 sum 求和、avg 平均值、max 最大值、min 最小值、count 计算个数
 
 特点：
 1. sum avg一般用于处理数值型
    max、min、count可以处理任何类型
 2.是否忽略null值
    sum avg mix min count 均忽略
 3.可以和distinct搭配使用实现去重运算
 
 4.单独介绍count
   count(*)统计总行数
   
 5.和分组函数一同查询的字段要求是group by后的字段
*/


#1.简单使用
select sum(salary) from emloyees;
select avg(salary) from emloyees;
select max(salary) from emloyees;
select min(salary) from emloyees;
select count(salary) from emloyees;

select sum(distinct salary) from emloyees;

-----------------------------------------------------------------------------
#分组查询

/*
 语法：
     select 分组函数 ，列（要求出现在group by的后面）
	 from 表
	 group by 分组的列表
	 【oder by 子句】
	 
 注意：
     查询列表比较特殊，要求分组函数和group by 后出现的字段
	 
 特点：1.分组前筛选   group by子句前
       2.分组后筛选   group by子句后
	   
	   3.group by子句支持单个字段分组，多个字段分组（多个字段之间用逗号隔开没有顺序要求），表达式
	   4.也可以添加排序（排序放在整个分组查询的最后）
*/
#案例1:查询每个工种的最高工资
    select max(salary),job_id
	from emloyees
	group by job_id;
	


