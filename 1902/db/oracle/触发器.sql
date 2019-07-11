select * from employees;
create sequence seq_employees start with 100;

-- 添加员工时，如果没有给员工id,触发。给一个ID。
CREATE   or replace trigger trg_add_emp
before  insert on employees
for each row
when (new.employee_id is null)
declare
id number;
begin
   select seq_employees.nextval into id from dual;
   :new.employee_id := id;
end;

insert into employees(first_name, gender) values('Green','x');

-- 为gender添加触发器，防止错误的值
create or replace trigger trg_emp_gender
before insert or update of gender on employees
for each row
when (new.gender not in ('男','女'))
begin
     if inserting then
      :new.gender := null;
     elsif updating then
      :new.gender := :old.gender;
     end if;
end;

update employees set gender='男1' where employee_id=100;

desc employees;
SET SERVEROUTPUT ON;
select * from v_employee_info;

update v_employee_info set department_name='SEIL' ;

--   INSTEAD
CREATE OR REPLACE TRIGGER TRG_UPDATE_V_EMP_INFO 
INSTEAD OF UPDATE  ON V_EMPLOYEE_INFO
BEGIN
    UPDATE DEPARTMENTS SET DEPARTMENT_NAME=:NEW.DEPARTMENT_NAME WHERE DEPARTMENT_NAME=:OLD.DEPARTMENT_NAME;
    DBMS_OUTPUT.PUT_LINE('INSTEAD OF ......');
END;
---==============================DDL
create or replace trigger trg_ddl_log
after create or alter or drop on wifi.schema
begin
   dbms_output.put_line(login_user ||' '  ||to_char(sysdate, 'dd-mm-yyyy hh:mi') ||' ' ||
   sysevent || ' ' || Dictionary_obj_type || ' ' || Dictionary_obj_name);
end;

create sequence seq_gen;

select to_char(sysdate, 'dd-mm-yyyy hh:mi') from dual;
