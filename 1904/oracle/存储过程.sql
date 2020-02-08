set serveroutput on;

-- 创建存储过程，根据姓名查询学生信息
create or replace procedure p_list_student(name in varchar2)as
begin
    for i in (select * from students where student_name=name) loop
        dbms_output.put_line(i.student_id ||':'||i.student_name||','||i.gender||','||i.birth_date);
    end loop;
end;
/
-- 标准SQL中调用存储过程
exec p_list_student('李红');
/
-- PL/SQL中调用存储过程
begin
    p_list_student(name=>'李小乐');
end;

-- 创建有输出参数的过程，根据学生ID，学科ID，查询成绩。
create or replace procedure p_find_score(sid in number, jid in number:=1, score out number)
as
begin
    select score into score from scores where student_id=sid and subject_id=jid;
    exception
    when others then
    score := -1;
end;

-- 有输出参数在PL/SQL环境中去调用
declare
score number;
begin
     p_find_score(sid=>1,score=>score,jid=>3);
     dbms_output.put_line('成绩：'||score);
end;
--=========================== 创建存储过程添加学生 ==========================
create or replace procedure p_add_stu(name in varchar2, gender in nchar,birth_date varchar2)
as
begin
    insert into students(student_id,student_name,gender,birth_date)
    values
    (seq_students.nextval, name, gender, to_date(birth_date, 'yyyy-mm-dd'));
end;
/
-- 调用，添加学生
exec p_add_stu('吴昊','男','1994-4-4');
/
select * from students;

-- =============================  自定义函数  ==========================
-- 创建一个根据学生成绩，返回等级的函数
create or replace function f_grad(score number)
return varchar2
as
grad varchar2(2 char);
begin 
    if score<60 then
        grad := '差';
    elsif score<70 then
        grad := '及格';
    elsif score<80 then
        grad := '中';
    elsif score<90 then
        grad := '良';
    else 
        grad := '优';
    end if;
    return grad;
end;
/
-- 调用,在SQL环境中
select student_name, subject_name, score, f_grad(score)
from scores c
join students s on s.student_id=c.student_id
join subjects j on j.subject_id=c.subject_id;
/
--  在 PL/SQL中
declare
g varchar2(2 char);
begin
    for i in (select student_name, subject_name, score
                from scores c
                join students s on s.student_id=c.student_id
                join subjects j on j.subject_id=c.subject_id) loop
        g := f_grad(i.score);
        dbms_output.put_line(i.student_name || i.subject_name || g);
    end loop;
end;


















