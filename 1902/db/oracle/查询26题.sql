-- 17、查询出拿岗位规定的最高（最上限）工资的人。
select e.first_name, j.job_title, e.salary from employees e join jobs j on j.job_id=e.job_id and e.salary=j.max_salary;

-- 20、查询出员工中最高工资的员工所在的岗位、工资、该员工工资与该岗位最高工资之间的差额。
select a.job_id, a.salary, j.max_salary, j.max_salary-a.salary  from (
select job_id, salary from  employees where salary=(select max(salary) from employees) )a join jobs j on a.job_id=j.job_id;

-- 25、查询出在两个及以上岗位工作过的员工。列出曾工作过的岗位。
select e.employee_id, first_name ,h.job_id,e.department_id,h.start_date, h.end_date 
from job_history h join employees e on h.employee_id=e.employee_id;




