select * from employees;
select distinct manager_id from employees where manager_id is not null;

select e.first_name, m.first_name from employees e left join employees m on e.manager_id=m.employee_id;

--====================================================
select * from regions;
select * from countries;

--============================多表关联查询示例============================
-- 查询Steven工作地点和部门
select first_name, department_name , l.street_address, 
city,state_province ,country_name ,region_name
from employees e
join departments d on e.department_id=d.department_id
join locations l on d.location_id=l.location_id
join countries c on c.country_id=l.country_id
join regions r on c.region_id=r.region_id 
where first_name='Steven';

--union
SELECT first_name, salary FROM employees where salary<2500
union all
select first_name, salary from employees where salary<3000 order by first_name;

--minus
SELECT first_name, salary FROM employees where salary<3000
minus
select first_name, salary from employees where salary<2500;

-- intersect
SELECT first_name, salary FROM employees where salary<3000
intersect
select first_name, salary from employees where salary<2500;


-- 统计每个部门工资最高的一个人。
select e.department_id, first_name, last_name ,salary from  employees e join
(select department_id, max(salary) mx from employees group by department_id)a
on e.department_id=a.department_id and e.salary=a.mx;

-- 统计每个部门工资最高的前两个人。
-- oracle 高级查询，统计查询-分区查询
select * from(
select department_id, first_name,last_name,salary ,
row_number() over(partition by department_id order by salary desc) N
from employees 
)where N<=2;

-- 统计每个部门工资拿最高的人。
