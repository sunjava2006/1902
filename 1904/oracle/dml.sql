--===============================insert==============================
insert into students
values
(seq_students.nextval, '赵军', '男', to_date('1990-3-3','yyyy-mm-dd'));

insert into students(birth_date, gender, student_id, student_name)
values
(to_date('1992-4-6','yyyy-mm-dd'), '女',seq_students.nextval, '江红');

-- 批量添加数据
-- insert into select........
insert into students2 SELECT * from students where gender='男';
insert into students2(student_name,gender)
select student_name,gender from students;

-- create table as select........新表只有参照表的结构，没有约束。
create table students2 as select * from students where 1=2;

--drop table students2;

-- 添加 null 值
insert into students2(student_name,student_id,gender,birth_date)
values('李明',7,null, '');

-- default
insert into students(student_id, student_name,gender)
values(seq_students.nextval, 'Peter',default);


--=================================== update ===================================
-- 更新所有数据（将students2表中，所有人的gender改为男）
update students2 set gender='男';
update students2 set gender='女',birth_date=to_date('1998-3-3','yyyy-mm-dd')
where student_name in ('江红','李红','李小乐');

--=============================== delete ====================================
-- 删除students2中所有数据
delete from students2;
-- 从students2删除名字叫李小红的。
delete from students2 where student_name='李小红';

--=================================== 截断表 ======================================
create table t_t as select * from students2;
truncate table t_t;

select * from t_t;
select * from students2;


-- ============================ merge =============================
--select * from t_t;
--insert into t_t select * from students;
--delete from t_t where birth_date is null;
--update students set birth_date=birth_date+1;
merge into t_t a
using (select * from students) b
on (a.student_id = b.student_id)
when matched then update set a.birth_date=b.birth_date,a.gender=b.gender
when not matched then insert (a.student_id,a.student_name,a.gender,a.birth_date)
values(b.student_id,b.student_name,b.gender,b.birth_date);



rollback;-- 回滚
commit;
