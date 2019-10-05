create or replace procedure query_stm(stm in varchar2, refcur out sys_refcursor)
as
begin
   open refcur for stm;
end;

set SERVEROUTPUT ON;
declare
refcur SYS_REFCURSOR;
i employees%rowtype;
begin
   query_stm('select * from employees where employee_id > 80 for update',refcur);
   loop
       fetch refcur into i;
       exit when refcur%notfound;
       dbms_output.put_line(i.first_name);
       if i.first_name='emp81' then
           update employees set first_name='LiBai' where current of refcur;
           dbms_output.put_line('update......................');
       end if;
   end loop;
   close refcur;
end;

--=========================================================
create or replace procedure exe_dml(stm in varchar2 )
as
begin
    execute immediate stm;
end;

exec exe_dml('update employees set first_name=''LiBai'' where employee_id=1');
--====================================================
create or replace procedure update_name(empid number, new_name nvarchar2)
as
begin
    execute immediate 'update employees set first_name=:xx1 where employee_id=:2' using new_name, empid;
end;

exec update_name(2,'LALA');

--===========================================================================
create or replace procedure qury_by_id(eid number, ename out nvarchar2)
as
begin
     execute IMMEDIATE 'select first_name from employees where employee_id=:1' into ename using eid;
end;

declare
n nvarchar2(30);
BEGIN
    qury_by_id(1,n);
    dbms_output.put_line(n);
END;

select * from employees;