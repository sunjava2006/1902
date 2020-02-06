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

-- oracle 自已的写法 不推荐









