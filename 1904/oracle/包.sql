-- ===================================创建包
--在包中定义一个常量
create or replace package my_pkg
as
PI constant number(3, 2):=3.14;
function f_minus(a number, b number)return number;
procedure p_add_subject(name varchar2);
end  my_pkg;

--=========================包体==========================
create or replace package body my_pkg
as
    function f_minus(a number, b number)return number
    as
    begin
         return a-b;
    end;
    
    procedure p_add_subject(name varchar2)
    as
    begin
        insert into subjects (subject_name) values (name);
    end;
end ;

--===============================使用包=========================
begin
   dbms_output.put_line(my_pkg.PI);
end;
/
select my_pkg.f_minus(100,20) from dual;

exec my_pkg.p_add_subject('3年级英语');
/
select * from subjects;
