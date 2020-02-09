--================================动态SQL===============================
-- INSERT
declare
stm varchar2(200 char);
begin
     stm := 'insert into subjects(subject_id,subject_name) values (:id,:name)';
     execute immediate stm using 4,'6年级c语言';-- 即时编译语句
end;
/

-- update
declare
stm VARCHAR2(100 char);
id number;
name varchar2(10 char);
begin 
    id := 4;
    name := '5年级Python';
    stm := 'update subjects set subject_name=:name where subject_id=:id';
    execute IMMEDIATE stm using name, id;
end;

-- select 
set serveroutput on;
declare
stm varchar2(100 char);
name varchar2(40 char);
begin
    stm := 'select subject_name from subjects where subject_id=:id';
    execute immediate stm into name using 1;
    dbms_output.put_line(name);
end;

select * from subjects;