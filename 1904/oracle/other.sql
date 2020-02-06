-- 建立视图view
create or replace view v_stu_score as
select student_id,student_name,subject_name,score
from students s natural join scores c
natural join subjects;

-- 视图是根据查询语句所创建的逻辑表。本身不包含数据。通过视图可以隐藏不想让别人看到的数据，可以简化查询。
select * from v_stu_score;

-- 创建一个Tests表
create table tests(id number constraint pk_test_id primary key,
name varchar2(20 char)
);

-- 创建序列
create sequence seq_tests;

select seq_tests.currval from dual;

INSERT INTO tests(id, name) VALUES (seq_tests.nextval, 'xie');

select * from tests;

--创建一个序列，从10开始，增长10。到50结束。循环。
create sequence seq
minvalue 10
start with 10 
increment by 10
maxvalue 50
cycle
cache 2;

drop sequence seq;


select seq.nextval from dual;

create public synonym tes2 for tests;

drop public synonym tes;

select * from tes;

grant select on tes2 to hr;
revoke select on tes from hr;

select * from user_synonyms;