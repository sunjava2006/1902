-- desc 表名 ： 列出表中的字段
-- SQL Structory Query language结构化查询语言
--desc students;
--select student_id,student_name from students;
--select s.* ,1+1  NO from students s; -- * 是通配符，表示所有字段。
--seLEct distiNct GeNdeR fROm StudeNts;
--select distinct * from students;
--select s.*, s.score+10  from scores s;
--============================== hr ==========================================
-- user_tables
select * from user_tables;
select * from employees;
select first_name || ' ' || last_name, salary, salary-1000 from employees; 

select null*10 from dual;
--distinct --
select distinct department_id from employees order by department_id;

select distinct 'ok' from employees;

--============================= 条件查询 ====================================
select * from employees where first_name='Steven' and last_name='King';
select * from employees where first_name <>'Steven';
select * from employees where salary>10000;
-- between and
select first_name, salary from employees where salary>=6000 and salary<=7000;--13条
select first_name, salary from employees where salary between 6000 and 7000;-- 同效上一语句

-- in
select first_name, salary from employees where salary=6000 or salary=6500 or salary=7000 or salary=7500;--9条
select first_name, salary from employees where salary in (6000,6500, 7000,7500);--9

-- like 字符串的模糊查询 %:多个任意字符, _:一个任意字符
select first_name from employees where first_name  like 'S_n%';

-- is null
select first_name, department_id from employees where department_id is null;

-- is not null
select first_name,commission_pct from employees where commission_pct is not null;

-- 条件 == is | <= <> >= | and or not
select first_name , department_id from employees where not department_id=50;

--======================================= 排序 order by 子句=======================================
select first_name, department_id from employees order by first_name asc, department_id ;


--===================================== 分组查询 group by ==================================
select department_id,job_id, count(first_name)  from employees 
where department_id>50
group by department_id , job_id
having count(first_name)>1
order by department_id;

-- 查询每个部分最高工资，平均工资、最低工资、总合
select department_id, count(salary), max(salary), round(avg(salary)), min(salary), sum(salary) from employees
group by department_id
order by department_id;

--==============================  子查询 ================================
-- 查询全员中，最高工资的人，列出名字、工资、部门、岗位。
select first_name,salary, department_id,job_id from employees
where salary=(select  max(salary) from employees);

-- 查询工资最高的员工，所在的部门
select department_name from departments
where department_id in (
select distinct department_id from employees 
where salary=(select  max(salary) from employees));

-- exixts 存在
select nvl2(
(select 'have' from dual where exists (select * from employees where first_name='Steven3')),'have','no')
from dual;

--================================= 分页查询 ===================================
-- rownum
select first_name, rownum from 
(select first_name from employees order by first_name);

select * from(
select first_name ,rownum ro from employees where rownum <=10 )where ro>0;

select * from(
select first_name ,rownum ro from employees where rownum <=20 )where ro>10;

select * from
(select first_name, rownum ro from 
(select first_name from employees order by first_name) where rownum<=10)where ro>0;

select * from
(select first_name, rownum ro from 
(select first_name from employees order by first_name) where rownum<=20)where ro>10;

-- with语句
with a as (select first_name, rownum ro from employees where rownum<=20)
select * from  a where ro>10;

with a as (select s.*,rownum ro from (select first_name from employees order by first_name desc)s where rownum<=20)
select * from  a where ro>10 ;

--================================= 查询每个部门工资最高的人 =======================================
select e.first_name, e.last_name, e.department_id,e.salary from employees e join
(select department_id,max(salary) mm from employees group by department_id) d
on e.department_id=d.department_id and e.salary=d.mm;

select * from employees where department_id=90;

select * from(
select department_id, first_name, salary,row_number()  over(partition by department_id order by salary desc)
ro from employees) where ro<=2;
