create or replace package wifi_query
as
PI constant number := 3.14159265;
procedure prc_list_emp(page number, siz number, cur out sys_refcursor);
end wifi_query ;

create or replace package body wifi_query
as
   PROCEDURE prc_list_emp(page number, siz number, cur out sys_refcursor)
   as
   begin
      open cur for select employee_id, first_name, department_id, gender from(
      select e.*, rownum ro from 
      (select * from employees order by employee_id desc) e 
      where rownum<=(page*siz)) where ro >(page-1)*siz;
   end prc_list_emp;
end;
--========================================================
set SERVEROUTPUT ON;
declare
cur sys_refcursor;
i employees%rowtype;
begin
   wifi_query.prc_list_emp(1,10 , cur);
   loop 
      fetch cur into i;
      exit when cur%notfound;
      
      dbms_output.put_line(i.first_name);
      
   end loop;
   close cur;
end;




---======================================================
select employee_id, first_name, department_id, gender from(
select e.*, rownum ro from (select * from employees order by employee_id desc) e where rownum<=10) where ro >0 ;

/
begin
  dbms_output.put_line( wifi_query.PI);
end;

--  查不到select wifi_query.PI from dual;

--============================高级统计查询=======================================
select * from(
select first_name, department_id, salary, row_number()over(partition by department_id order by salary desc ) ro
from employees )
where ro <=2;

select * from(
select first_name, department_id, salary, dense_rank()over(partition by department_id order by salary desc ) ro
from employees )
where ro <=2;
