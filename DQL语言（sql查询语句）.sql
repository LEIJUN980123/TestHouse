#基础查询
/*
语法:
select 查询列表 from 表名;

特点；
1.查询列表可以是：表中字段、常量值，表达式、函数
2.查询的结果是一个虚拟的表格

#1.查询表中的单个字段
select last_name from employees;

#2.查询表中的多个字段
select last_name,salary,email from employees;

#3.查询表中的所有的字段
select * from employees;

#4.查询常量值
select 100;
select 'john';

#5.查询表达式
select 100%98;

#6.查询函数
select version();

#7.起别名
select 100%98 AS 结果;
select last_name AS 姓,first_name AS 名 from employees;

#8.去重
select distinct id from 表名;

#9.拼接
   concat
 
*/
-----------------------------------------------------------------
#条件查询
/*
语法：
   select 
         查询列表
   from   
         表名
   where	
         筛选条件

分类：
    一、按条件表达式筛选
      条件运算符：> < = !=	<> >= <=
	二、按逻辑表达式筛选
	  逻辑运算符：&& || ！ and or not
	三、模糊查询
	   like
	   between and
	   in
	   is null

#一、按条件表达式筛选

#案例1：查询工资>12000的员工信息

select  * from employees where salary>12000;

#案例2:查询部门编号不等于90号的员工名和部门编号

select last_name,department_id from employees where department_id!=90;


#二、按逻辑表达式筛选

#案例1：查询工资在10000到20000之间的员工名、工资以及奖金

select last_name,salary,commission_pct from employees where salary>=10000 and salary<=20000;


#三、模糊查询
#1.like     特点；一般和通配符搭配使用 通配符：%任意多个字符，包含0个字符  _任意单个字符

 #案例1:查询员工名中包含字母a的员工信息
 select * from employees where last_name like '%a%';

#案例2:查询员工名中第三个字符为e，第五个字符为a的员工名和工资
 select last_name,salary from employees where last_name like '__e_a%';
 
#案例3：查询员工名中第二个字符为_的员工名
 select last_name from employees where like '_$_%' escape '$';
 
#2.between and  特点；语言简洁，包含临界值

#案例1：查询员工编号在100到120之间的所有的员工信息
select * from employees where employee_id between 100 and 120;
 
#3.in   特点：语言简洁 in列表的值类型必须一致或兼容

案例1：查询员工的工种编号是 IT_RPOG、AD_VP、AD_PRES中的一个员工名和工种编号
select last_name,job_id from employees where job_id IN(IT_RPOG、AD_VP、AD_PRES);

#4.is null  特点:is null is not null 判断null

案例1：查询没有奖金的员工名和奖金率
select last_name,commission_pct from employees where commission_pct is null;
/ 

-------------------------------------------------------------------------
#排序查询

语法：
     select 查询列表
	 from 表
	 where 筛选条件
	 order by 排序列表 【asc|desc】
特点：
    
	1.asc代表的是升序,desc代表是降序,默认升序
	2.order by 子句可以支持单个字段，多个字段、表达式、函数、别名
	
案例1：查询员工信息，要求工资从高到低排序
select *from employees order by salary desc