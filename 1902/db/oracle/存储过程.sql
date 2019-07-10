create or REPLACE procedure p_add(a in number:=0, b in number:=0)
as
c number := 0;
begin
    c := a+b;
    dbms_output.put_line(c);
end;

set SERVEROUTPUT ON;
exec p_add(1, 2);
/
begin
   p_add(4,5);
end;

--======================================================
create or replace procedure p_add2(a in number:=0, b in number:=0, c  out number)
as
begin
c := a+b;
end;
/

declare
r number;
begin
    p_add2(c=>r,a=>1,b=>2);
    dbms_output.put_line(r);
end;
/
--===============================返回最高、最低、平均薪水

select * from employees;

--编写过程，实现分页查询
create or replace procedure p_list_emp(page in number, siz in number, cur out sys_refcursor)
as
begin
   open cur for select employee_id, first_name,department_id, gender from (select e.*, rownum ro from employees e
   where rownum <=(page*siz)) where ro >((page-1)*siz);
end;
/
declare
cur sys_refcursor;
i employees%rowtype;
begin
    p_list_emp(2,5,cur);
    loop
       fetch cur into i;
       exit when cur%notfound;
       dbms_output.put_line(i.employee_id || ':' || i.first_name);
    end loop;
    close cur;
end;


--=========================================================
create or replace procedure p_salary_info(mi out number, mx out number, average  out number)
as
begin
    select min(salary) , max(salary), avg(salary) into mi, mx, average from employees2;
end;
/
set SERVEROUTPUT ON;
declare
mi number;
mx number;
average number;
begin
   p_salary_info(mi, mx, average);
   dbms_output.put_line(mi || ' ' || mx || ' ' || average);
end;


drop procedure p_salary_info;

--=========================================================
create or replace function f_rank(sal in number)
return nvarchar2
as
grad nvarchar2(1);
begin
    if sal >=20000 then
        grad := '高';
     elsif sal >=5000 then
        grad := '中';
     else
         grad:='低';
     end if;
     return grad;
end;
/

select  salary, f_rank(salary) from employees2;

begin
    dbms_output.put_line(f_rank(2000));
end;




select * from employees;
