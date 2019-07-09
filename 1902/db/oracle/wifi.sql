create table student
(id number primary key,
name varchar2(20),
score number(3),
constraint ck_score  check (score between 0 and 100),
gender char(1 char) default '男' check(gender in ('男','女'))
);

insert into student values(1,'wang',1,'女');

drop table student;
/
--PL/SQL
set SERveroutput on;
begin
   -- dbms_output.put_line('Hello World.');
   DBMS_OUTPUT.PUT('hello, ');
   DBMS_OUTPUT.PUT('world. ');
   dbms_output.new_line();
end;
/
--定义变量并输出
declare
a number(3) :=10;
b boolean :=FalsE;
c positive :=90;
d varchar2(20);
e signtype;
begin
   d:='china';
   select -1 into e from dual;
   dbms_output.put_line(a||c||d||e);
end;

--================================================
declare
ran number(13);
grad nvarchar2(3):='xxx';
begin
    ran := trunc(dbms_random.value(30,100));
    dbms_output.put_line(ran);
    if ran>=90 then
        grad:='优';
    elsif ran>=80 then
        grad:='良';
    elsif ran>=70 then
        grad:='中';
    elsif ran>=60 then
        grad := '及格';
    else 
        grad:='不及格';
    end if;
    dbms_output.put_line(grad);
end;

--=======================================
declare
i number(2) := 1;
j number(2) ;
begin
    while i<=9 loop
        j:=1;
        while j<=i loop
            dbms_output.put(j || '*' || i ||'=' ||i*j ||'   ');
            j:= j+1;
        end loop;
        dbms_output.new_line();
        i := i+1;
    end loop;
end;
--================================loop===========================
declare
i number :=1;
begin
    loop
       exit when i>9;
       dbms_output.put_line(i);
       i := i+1;
    end loop;
end;

--==========================for=============================
begin
   for i  in reverse 10..20 loop 
      dbms_output.put_line(i);
   end loop;
end;
/
set serveroutput on;
begin
    for i in (select * from employees) loop
        dbms_output.put_line(i.employee_id || ':' || i.first_name);
    end loop;
end;
--------------------------------DML
declare
new_name nvarchar2(20);
id number;
begin
    id :=1;
    new_name:='Jack';
    update employees set first_name=new_name where employee_id=id;
    dbms_output.put_line(sql%rowcount);
end;
-------------------------select--------------
declare
id number :=1000;
name nvarchar2(20);
did number;
g nchar(1);
counter number :=0;
begin
     select count(*) into counter from employees where employee_id=id;
     if counter = 1 then
         select first_name into name from employees where employee_id=id;
         DBMS_OUTPUT.put_line(name);
     else
         dbms_output.put_line('没有数据');
     end if;
exception
   when no_data_found then
     dbms_output.put_line('没有ID为:' || id );
   when too_many_row then
     dbms_output.put_line('参数不正确查询到得多数据。');
end;


select * from employees;

