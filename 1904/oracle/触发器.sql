set serveroutput on;
--========================== 什么是行级触发器/语句级触发器 ==============================
create or replace trigger trg_update_subj
before update on subjects
for each row
begin
    dbms_output.put_line('更新了subjects表');
--    dbms_output.put_line(SYS.dictionary_obj_name);
end;

update subjects set subject_name=subject_name;
--===========================添加学科，当没有给学科id时触发。===========================
create or replace trigger trg_add_subj
before insert on subjects
for each row
when(new.subject_id is null)
begin
    dbms_output.put_line(':new 中 subject_id 没有值');
    :new.subject_id := seq_subjects.nextval;
end;
/
insert into subjects (subject_id,subject_name)values(5,'4年级Python');
select * from subjects;

----------------------------------- 检查gender是否是有效数据 -----------------------------------
create or replace trigger trg_add_up_stu
before insert or update of gender on students
for each row
when (new.gender not in ('男','女'))
begin
    if inserting then
         dbms_output.put_line('inserting');
    elsif updating then
        dbms_output.put_line('updating');
    end if;
    :new.gender:='女';
end;
/
insert into students(student_id, student_name, gender)
values(SEQ_STUDENTS.nextval, 'Marry', '2');
/
update students set gender='w';
/
select * from students;
/
--===========================替代触发器============================
select * from v_stu_score;
create or replace trigger trg_del_view_stuscore
instead of delete on v_stu_score
declare
sub_id number;
begin
    dbms_output.put_line('deleting view');
    select subject_id into sub_id from subjects where subject_name=:old.subject_name;
    delete from scores where student_id=:old.student_id and subject_id=sub_id;
end;

delete from v_stu_score where student_id=2; 

--=============================== DDL触发器，监控DDL操作  ===============================
create or replace trigger trg_ddl_on_student
after create or alter or drop on student.SCHEMA
begin
   dbms_output.put_line(sys.login_user ||' '|| sys.sysevent || ' ' || sys.dictionary_obj_type ||' ' || SYS.dictionary_obj_name);
end;

drop sequence seq_tt;

--====================== 系统触发器 ============================
create or replace trigger trg_logoff
before logoff on student.schema
begin
    dbms_output.put_line(sysdate ||' ' ||sys.login_user||' ' ||'logoff');
end;