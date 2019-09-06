select * from regions;
select * from countries;
select * from locations;
select * from departments;
select * from employees;
select employee_id,first_name,manager_id from employees;
select * from jobs;
select * from job_history;
-- 1、查询出员工表中所有员工所在的部门。（如有重复的，只列出一个）。
select department_name from departments 
where department_id in ( select distinct department_id from employees);
-- 2、查询出不属于任何部门的员工。
select first_name from employees where department_id is null;

-- 3、查询出员工中First_name以Pe开头的所有员工。
select first_name, last_name from employees 
where first_name like 'P_t';

-- 在一列中显示员工的全名
select first_name || ' ' || last_name from employees;

-- 查询不叫Peter的员工
select first_name from employees where first_name <> 'Peter';

-- 查询员工工资为5000\6000\7000\8000的员工。
select first_name, salary from employees where salary=5000 or salary=6000
or salary=7000 or salary=8000;

select first_name, salary from employees where salary in(5000,6000,7000,8000);

-- 查询2007-5-21入职的员工
select first_name, last_name from employees
where hire_date=to_date('2007-5-21','yyyy-mm-dd');

-- 4、列出员工表的表结构（表字段的定义）
desc employees;

-- 5、查询出工作日期为2007年的员工，列出员工的名字。
select first_name,hire_date from employees
where hire_date>=to_date('2007-1-1','yyyy-mm-dd') 
and hire_date<=to_date('2007-12-31','yyyy-mm-dd');
-- 5、查询出工作日期不是2007年的员工，列出员工的名字。
select first_name,hire_date from employees
where not hire_date  between to_date('2007-1-1','yyyy-mm-dd') 
and to_date('2007-12-31','yyyy-mm-dd');

-- 6、按员工的岗位分组，计算出各岗位的平均工资。
select department_id, job_id, avg(salary) from employees
group by job_id, department_id;

-- 7、查询列出员工的详细信息：列出员工名字、岗位、所在部门的名字、工资、工作地点。
select e.first_name, j.job_title ,d.department_name, e.salary, l.city, c.country_name from employees e
 join jobs j on e.job_id = j.job_id
 join departments d on e.department_id = d.department_id
join locations l on d.location_id=l.location_id
 join countries c on l.country_id=c.country_id;

select e.first_name, j.job_title 
from employees e NATURAL join jobs j ;

-- 8、按部门统计出各部门的工资总合，列出部门的名字。
select d.department_name, a.sum from 
(select department_id, sum(salary) sum from employees group by department_id) a
left join departments d on d.department_id=a.department_id order by sum; 

select department_name, sum(salary) sum from
(select * from employees e left join departments d on e.department_id=d.department_id) 
group by department_name order by sum;

--      分页查询出员工，按薪水从高到低排列。每页最多10条记录。
select * from(
select a.*, rownum ro from (
select * from employees order by salary desc)a where rownum <=20) 
where ro > 10;
 
--      分页查询出员工（薪水大于全员平均工资的员工），按薪水从高到低排列。每页最多10条记录。
 select * from(
 select a.*,rownum ro from(
 select first_name,salary from employees where 
 salary>(select avg(nvl(salary,0)) from employees) order by salary desc)a where
 rownum<=20)
 where ro>10;

-- 9、查询出在Europe(区域)工作的所有员工。
select * from employees where department_id in
(select department_id from departments where location_id in
(select location_id from locations where country_id in
(select country_id from countries 
where region_id = (select region_id from regions
where upper(region_name)='EUROPE'))));
-- 10、查询出IT部门所有员工，列出他们的工资、名字。
select salary,first_name from employees e inner join departments d
on e.department_id=d.department_id where d.department_name='IT';

-- 11、查询出工作地在UK的员工，列出他们的名字、工作所在地。
select * from(
select e.first_name||e.last_name,l.city,c.country_id country from employees e
join departments d on d.department_id=e.department_id
join locations l on l.location_id=d.location_id
join countries c on c.country_id=l.country_id) where country='UK';

select * from countries;

-- 12、列出曾经在"Programmer"岗位工作过的员工，列出名字、当前岗位。
     select e.first_name from
     (select*from jobs where job_title='Programmer')j  join job_history jh
     on j.job_id=jh.job_id join employees e on jh.employee_id=e.employee_id;

-- 13、列出各部门经理和他们管理的员工的名字。按经理名字排序。
select e.employee_id, e.first_name ename, m.employee_id, m.first_name mname
from employees e
left join employees m on e.manager_id=m.employee_id
order by mname;

-- 14、分页查询，按员工的工作日期排序。查询出员工的名字、部门名、岗位名、工资。
--每页5条记录。查询第1页、第2页。
-- 15、查询出各部门最高工资的人。
select e.first_name, e.salary ,e.department_id from employees e join 
(select department_id, max(salary) max from employees
group by department_id) a on e.department_id=a.department_id and e.salary=a.max
order by department_id;
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
select * from(
select first_name, 
        department_id,
        salary, 
        row_number() over(PARTITION by department_id order by salary desc) no
from employees) where no<3 ;


select first_name, 
        department_id,
        salary, 
        dense_rank() over(PARTITION by department_id order by salary desc)
from employees;