-- 1、查询出员工表中所有员工所在的部门。（如有重复的，只列出一个）。不关心某一个人是出自哪个部门。
select distinct department_name from employees natural join departments ;

-- 2、查询出不属于任何部门的员工。
select first_name || ' ' || last_name from employees where department_id is null;

-- 3、查询出员工中First_name以Pe开头的所有员工。
select first_name , last_name from employees where first_name like 'Pe%';

-- 4、列出员工表的表结构（表字段的定义）
desc employees;

-- 5、查询出工作日期在2005-2--7之间（包含）的员工，列出员工的名字。(2月头-7月尾)
select first_name, hire_date from employees 
where hire_date between to_date('2005-2-1','yyyy-mm-dd') 
and 
to_date('2005-7-31:23:59:59','yyyy-mm-dd:hh24:mi:ss');
--select to_char(to_date('2005-7-31:23:59:59','yyyy-mm-dd:hh24:mi:ss') ,'yyyy-mm-dd:hh24:mi:ss')from dual;
select first_name ,hire_date from employees
where extract(year from hire_date)=2005 and extract(month from hire_date) between 2 and 7;

-- 6、按员工的岗位分组，计算出各岗位的平均工资。
select job_id,avg(nvl(salary,0)) from employees group by job_id;

-- 7、查询列出员工的详细信息：列出员工名字、岗位、所在部门的名字、工资、工作地点。
select first_name,last_name,salary,job_title,department_name, l.state_province, city,l.street_address
from employees e
join departments d on e.department_id=d.department_id
join locations l on d.location_id=l.location_id
join jobs j on j.job_id = e.job_id;

-- 8、按部门统计出各部门的工资总合，列出部门的名字。
select department_name, sm from
(select department_id, sum(nvl(salary,0)) sm from employees group by department_id) a
left join departments  d on a.department_id=d.department_id;

--分页查询出员工，按薪水从高到低排列。每页最多10条记录。
select * from
(select a.*, rownum ro from (select first_name, salary from employees order by salary desc)a where rownum<=20)
where ro>10;

--分页查询出员工（薪水大于全员平均工资的员工），按薪水从高到低排列. 每页最多10条记录。
select * from (
select first_name,salary, rownum ro from
(select * from employees where salary>(select avg(nvl(salary,0)) from employees) order by salary desc)
where rownum <=10)
where ro>0;
      



-- 9、查询出在Europe(区域)工作的所有员工。
select first_name, region_name, country_name
from employees 
natural join departments
natural join locations
natural join countries
natural join regions
where regions.region_name = 'Europe';

-- 10、查询出IT部门所有员工，列出他们的工资、名字。
select * from employees where department_id=(select department_id from departments where department_name='IT');

select * from employees e left join departments d on e.department_id=d.department_id where department_name='IT';

-- 11、查询出工作地在UK的员工，列出他们的名字、工作所在地。* 

select e.first_name , street_address, city,l.location_id location_id
from employees e
join departments d on e.department_id=d.department_id
join locations l on l.location_id = d.location_id
join countries c on l.country_id= c.country_id
where c.country_id='UK';

--select * from employees where department_id in(
--select department_id from departments where location_id in
--(select location_id from locations where country_id='UK'));


-- 12、列出曾经在"Programmer"岗位工作过的员工，列出名字、当前岗位。
-- 13、列出各部门经理和他们管理的员工的名字。按经理名字排序。
-- 14、分页查询，按员工的工作日期排序。查询出员工的名字、部门名、岗位名、工资。每页5条记录。查询第1页、第2页。
-- 15、查询出各部门最高工资的人。
-- 16、查询出各岗位最高工资的人。
-- 17、查询出各岗位规定的最高（最上限）工资的人。
-- 18、查询出各部门中，员工工资，正好为本部门平均工资的人。
-- 19、查询出员工中最高工资的员工所在的部门。
-- 20、查询出员工中最高工资的员工所在的岗位、工资、该员工工资与该岗位最高工资之间的差额。
-- 21、查询出各岗位的员工，按岗位、员工工作日期倒序排列。
-- 22、查询出在London上班的员工.列出名字。
-- 23、是否只有销售岗位的员工才有提成。查询返回是或没有结果。
-- 24、公司要为员工涨薪水50%。但不能超过各岗位的最高工资，如涨50%后超过限额的不涨。列出可以涨薪的员工、当前工资、加薪之后的工资、岗位工资上限。
-- 25、查询出在两个以上岗位工作过的员工。列出曾工作过的岗位。
-- 26、查询出各部门工资最高的2个人。