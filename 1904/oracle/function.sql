select  * from students;
select student_name, length(student_name) from students;

select count(student_name) from students;
INSERT INTO students(student_id, student_name) VALUES(5, 'Jack');
--===========================================================
-- lower 转换为小写字符
select lower('ChINa') from dual;
select lower(student_name)from students;
-- upper转换为大写字符
select upper(student_name)from students;
-- initcap 转换为首字母大写
select initcap('CHINA') from dual;
-- concat 字符拼接
select concat(concat('hello','Wang'),'LaoShi') from dual;
select 'hello'||' wang'|| ' LaoShi' from dual;
-- substr 取字符的子串 ,下标从1开始计数，不是从0开始。
select substr('I like Oracle', 3, 4) from dual; 
-- instr 查找子串所在的位置
select instr('天汇智码-智码堂','智', 1, 2)from dual;
select instr('天汇智码-智码堂','智', -1, 1)from dual;--从后往前查找
-- lpad 在字符串左边填充(英文适用)
select lpad(student_name,8,'*')from students;
-- rpad 在字符串右边填充
select rpad('hello', 8,'*') from dual;
-- trim 去除字符串两边的空格
select length(trim('    hi    ')) from dual;
-- trim 去除指定的字符
select trim('*' from '***abc***') from dual;
-- ltrim 去除左边的空格
select length(ltrim('  hi  ')) from dual;
-- rtrim 去除右边的空格
select rtrim('  hi  ') from dual;
--select rtrim('*' from '**hi**') from dual;错误的
-- replace 替换
select replace('I Like Oracle', 'I', 'You') from dual;
-- length 求字符串长度
select student_name, length(student_name) from students;

--========================= 数值函数 ================================
-- round 四舍五入
select round(3.14, 0) from dual;--3
select round(3.14159,4) from dual; -- 3.1416
select round(155, -2)from dual; --200 小数点前两位
-- trunc 截断,不进位
select trunc(3.14159, 4) from dual;--3.1415
select trunc(155, -2)from dual; --100
-- mod 求模（求数）
select mod(4,3)from dual;--1
select mod(4,2)from dual;--0
select mod(4,0)from dual;--4
-- abs 求绝对值
select abs(-9)from dual;
-- dbms_random.value 求随机数
select trunc(dbms_random.value(10,20))from dual;

--============================ 日期函数 ===============================
-- sysdate 取当前日期
select sysdate from dual;
-- to_char 将日期转换为字符串的指定形式
select to_char(sysdate, 'syyyy-MM-DD pm HH12:mi:ss day') from dual;
-- to_date 将字符串转换为日期
select to_char(to_date('-21-1-1','syyyy-mm-dd'), 'syyyy-mm-dd') from dual;
-- months_between 计算两个日期之间差几个月
select sysdate+30 from dual;
select abs(months_between(sysdate , sysdate+30 )) from dual;
-- add_months 在上期上加几个月
select add_months(sysdate, 2) from dual;
-- next_day 返回从指定日期开始，下一个星期几的日期
select next_day(sysdate, 7)from dual;
-- last_day 返回指定日期所在月份，最后一天的日期
select last_day(add_months(sysdate,1)) from dual;
-- round 日期上的使用
select to_char(round(sysdate,'dd'), 'yyyy-mm-dd hh24:mi:ss') from dual;
-- trunc 在日期上的使用
select trunc(to_date('1990-12-25','yyyy-mm-dd'),'mm') from dual;
-- extract 抽取日期的指定部分
select extract(month from sysdate) from dual;

--============================== 转换函数 ================================
-- to_char 数值转字符串, 格式化数值
select to_char(123456, 'L999,999,999,999') from dual;
select to_char(123456, '$000,000,000,000') from dual;
-- to_number 字符串转化为数值
select to_number('$123.45','$000.000')*100 from dual;
-- to_timestamp 转换为时间戳
select to_timestamp('1995-3-3 12:24:35','yyyy-mm-dd hh24:mi:ss') from dual;

--============================== 通用函数 ================================
-- nvl null值
select nvl(null, '男') from dual;
select * from scores;
select avg(nvl(score,0)) from scores;

select (90*4+100 )/6 from dual;
select (90*4+100 )/5 from dual;
-- nvl2（n1,n2,n3）n1不为null,返回n2,否则返回n3
select student_name, nvl2(gender,gender,'男') from  students;
--nullif(n1,n2) 两个参数相同返回null,否则返回n1
select nullif(1,12) from dual;
-- coalesce 返回参数列表中，第一个不为null的值。
select coalesce(null,null,null,2,3,5)from dual;

-- 聚合函数
-- min取最小值
update scores set score=60 where student_id=1 and subject_id=1;
select * from scores;
select min(score) from scores;

--max 取最大值
select max(score) from scores;

-- sum 求总合
select sum(score) from scores;

--avg 平均数
select avg(score) from scores;

-- count 计数
select count(score) from scores;
select count(distinct gender) from students;

