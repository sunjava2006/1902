select * from students;
select * from scores;

-- 交叉连接 ,迪卡尔乘积。
select * from students,scores;
select * from students cross join scores;

-- 从迪卡尔乘积中找出匹配的数据
select * from students st,scores sc where st.student_id=sc.student_id and st.student_id=2;

-- 内连接查询,按指定字段进行连接，查询出完全匹配的数据。
select students.student_id,student_name, subject_id, score from students 
inner join scores on students.student_id = scores.student_id;

-- inner 不写就是inner join
select students.student_id,student_name, subject_id, score from students 
join scores on students.student_id = scores.student_id;

-- 外连接,分主从表
-- 左外连接，以左表为主表，主表数据全部列出，从表与其匹配，不匹配的记录补null.
select * from students a left outer join scores b on b.student_id = a.student_id;
select * from students a left  join scores b on b.student_id = a.student_id;
-- 右外连接，以右表为主表，主表数据全部列出，从表与其匹配。
select * from students a right outer join scores b on b.student_id = a.student_id;
select * from students a right  join scores b on b.student_id = a.student_id;
-- 全外连接，两边的表都列出。能匹配的匹配。
select * from students a full outer join scores b on b.student_id = a.student_id;
select * from students a full  join scores b on b.student_id = a.student_id;

-- 自然连接，自动按两表的相同的字段名进行匹配
select * from students NATURAL JOIN scores;

-- oracle 8i写法 不推荐
select * from students a, scores b where a.student_id=b.student_id(+);

-- 列出学生名，学科名，成绩
select s.student_id, s.student_name, j.subject_name, c.score, k.grad
from students s join  scores c on s.student_id=c.student_id
join subjects j on j.subject_id=c.subject_id
join brank k on c.score between k.start_score and k.end_score;

-- 高级分区统计查询
-- 查询学科2最高分的学生
select * from
(select student_id,subject_id,score,
dense_rank() over(partition by subject_id order by score desc) NO
from scores
where subject_id=2)
where NO=1;

update scores set score=90 where student_id=3 and subject_id=2;











