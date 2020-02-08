-- 索引
create index idx_student on students(student_name);

create bitmap index idx_student_gender on students(gender);

select * from students where upper(student_name)='PETER';

CREATE INDEX idx_student_name on students(upper(student_name));


select * from user_indexes;