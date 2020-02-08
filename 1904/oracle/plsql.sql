set serveroutput on ;

declare
    age natural := 20;
    married boolean  := false;
    name constant varchar2(4 char):= '李小红';
begin
   -- name := '张小红';
    dbms_output.put_line('hello world');
    dbms_output.put('name:'||name);
    dbms_output.put('age:'||age);
    dbms_output.new_line();
    if married then
        dbms_output.put_line('married');
    else
        DBMS_OUTPUT.PUT_LINE('no married');
    end if;
end;
/
--======================= if ...else....========================
-- 判断随机数，是奇数还是偶数
declare
    a positive;
begin
    a:= trunc(dbms_random.value(0,10));-- 在PLSQL中函数可以直接调用。
    dbms_output.put_line(a);
    if 0=mod(a,2) then
        dbms_output.put_line('偶数');
        dbms_output.put_line('--------------');
    else
        dbms_output.put_line('奇数');
        dbms_output.put_line('==============');
    end if;
end;
/
--=========if...eslif....else.....end if=========================
declare
   score number := trunc(dbms_random.value(0, 100));
   grad varchar2(2 char);
begin
   dbms_output.put_line(score);
   if score<60 then
       grad := '差';
   elsif score<70 then
       grad := '一般';
    elsif score<80 then
       grad := '中';
    elsif score<90 then
       grad :='良';
    else 
       grad := '优';
   end if;
   dbms_output.put_line(grad);
end;
/
--============================while=======================
-- 9*9乘法表
declare
a natural :=1;
begin
    while a<=9 loop
        declare -- 申明局部变量
        b natural ;
        begin
            b := 1;
            while b<=a loop
                 dbms_output.put(b ||'*'|| a || '=' || (b*a) || '   ');
                 b:=b+1;
            end loop;
        end;
             dbms_output.new_line();
        a:=a+1;
    end loop;
end;
/
--===========================loop =======================
-- 打印输出"*"组成的10行10列的矩形
declare
row binary_integer := 1;
col number;
begin
     loop
        
         col := 1;
         loop 
             if col>10 then ---------------
                 exit;     -- 退出循环
             end if;       ----------------  
             dbms_output.put('*');
             col := col+1; -- 列的计数加1
         end loop;
         dbms_output.new_line();
          
         row := row+1; -- 行计数加1
         exit when row>10; -- 退出循环
     end loop;
end;
/
--========================== for =============================
-- 打印扬辉三角形 reverse n..m反转为从大到小。写的时候n必须小于m。
begin
   for i in reverse 1..10 loop
       for j in 1..i loop
           dbms_output.put('*');
       end loop;
   dbms_output.new_line();
   end loop;
end;
/
-- ============= for select ==============================
-- 遍历查询的数据结果，打印每行记录
begin
    for i in (select * from scores) loop
       dbms_output.put_line('student_id:' || i.student_id);
       dbms_output.put_line('subject_id:' || i.subject_id);
       dbms_output.put_line('score:' || i.score);
       dbms_output.put_line('-------------------------');
    end loop;
end;
/

-------------- PL/SQL 中DML操作 ------------------- 
-- insert
declare
student_id students.student_id%type; -- 参照students表中的student_id列的类型
student_name students.student_name%type;
gender nchar(1);
birth_date date;
begin
   student_id := seq_students.nextval;-- 序列可以直接取值
   dbms_output.put_line(student_id);
   student_name := '钱小光';
   gender := '男';
   birth_date := to_date('1996-3-3','yyyy-mm-dd');
   insert into students(student_id,student_name,gender,birth_date)
   values (student_id,student_name,gender,birth_date);
end;
/
select * from students;
/
-- update
declare
idd number(4);
newgender char(1 char);
begin
   idd := 18;
   newgender := '女';
   update students set gender=newgender where student_id=idd;
end;
/
-- delete
declare
idd number;
begin
    idd := 18;
    delete from students where student_id=idd;
end;
/
-- select
select * from students;
/
declare
name nvarchar2(20);
gender nchar(1);
counter number;
idd number := 2;
begin
    select count(*) into counter  from students where student_id=idd;
    if counter=1 then
        select student_name, gender into name, gender
        from students where student_id=idd;
        dbms_output.put_line(name || gender);
    end if;
end;
--============================= %rowtype
declare
i students%rowtype;-- 参照类型，参照students表一行的类型
begin
    select student_name, gender into i.student_name, i.gender
    from students where student_id=100;
    dbms_output.put_line(i.student_id);
    dbms_output.put_line(i.student_name);
    dbms_output.put_line(i.gender);
    dbms_output.put_line(i.birth_date);
    exception
    when no_data_found then
       dbms_output.put_line('没找到数据');
    when too_many_rows then
       dbms_output.put_line('返回的数据不止一行');
    when others then
       dbms_output.put_line('有异常发生');
end;










