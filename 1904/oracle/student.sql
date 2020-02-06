select * from students;

update students SET student_id = 3 where student_name='李小红';

commit;

alter table students add constraint pk_students_id primary key(student_id);

create table subjects
(
subject_id number(3),
subject_name varchar2(20 char) constraint uni_subj_name unique,
constraint pk_subjects_id primary key(subject_id)
);

create table scores
(
   student_id number constraint fk_scores_stuid references students(student_id),
   subject_id number(3),
   score number(3) not null
);
alter table scores add constraint fk_scores_subjid foreign key(subject_id) REFERENCES subjects(subject_id);
alter table scores modify score not null ;
DELETE from scores where subject_id=4;

select * from user_constraints;

insert into subjects values (3,'三年级数学');

--============================================================
select * from students;
select * from subjects;
select * from scores;
insert into scores values (1,3,null);

alter table scores add constraint ck_score check (score between 0 and 100);

commit;

insert into students(student_id, student_name)values(4,'李亮');

--==========================================================================
-- 创建成绩等级表
create table  brank(
start_score number,
end_score number,
grad varchar2(2 char)
);


insert into brank values(91,100,'优');


select * from brank;

commit;

update scores set  score=80 where student_id=2 and subject_id=2;

