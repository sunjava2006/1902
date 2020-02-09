set serveroutput on;
--======================== 隐式游标 ==============================
declare
c number;
begin
    select count(*) into c from students;
    if sql%found then
        dbms_output.put_line('found');
        dbms_output.put_line(sql%rowcount);
    else
        dbms_output.put_line('notfound');
    end if;
end;
--=================================================
begin
    update students set gender = gender;
    dbms_output.put_line(sql%rowcount);
end;

--================================= 显示游标 =====================================
declare
cursor cur is (select * from students);-- 游标就是一个指向查询结果的指针。
i students%rowtype;
begin
     open cur;
--     open cur;
     loop
         fetch cur into i;
         exit when cur%notfound;
         dbms_output.put_line(i.student_id||i.student_name);
         dbms_output.put_line(cur%rowcount);
          if cur%isopen then
            dbms_output.put_line('open');
        else
            dbms_output.put_line('close');
        end if;
     end loop;
     close cur;
--     close cur;
end;
/
--===========================================================================
--for 循环遍历游标
declare
cursor cur is select student_name, gender from students;
begin
    for i in cur loop
        dbms_output.put_line(i.student_name || i.gender);
    end loop;
end;
/
--==========================   有参数的游标  ===================
declare
cursor cur(a number, b number) is select student_name,gender from students where student_id between a and b;
--name varchar2(40 char);
--g nchar(10);
--i students%rowtype;
type red is record (n varchar2(20 char), g nchar(1));-- 定义一个record类型
i red;
begin
    open cur(3, 20);
    loop
        fetch cur into i;
        exit when cur%notfound;
        dbms_output.put_line(i.n||i.g);
    end loop;
    close cur;
end;

--============================ 游标变量（引用游标） ===========================
-- 游标是指向查询结果的指针。游标变量中存储的是指向游标的指针。所以游标变量是指向指针的指针。
declare
--type refcur is ref cursor; -- 声明了一个"游标变量类型"。sys_refcursor
cur sys_refcursor;--声明cur是游标变量对象
type rec is record(id number, name varchar2(10 char)); -- 定义recoder 类型
i rec; -- 定义recoder类型的变量。
stm varchar2(200 char);
begin
    stm := 'select student_id, student_name from students';
    open cur for stm;
        loop
            fetch cur into i;
            exit when cur%notfound;
            dbms_output.put_line(i.id || i.name);
        end loop;
    close cur;
end;
/
--=============================== fro update 游标 ================================
--===================== 如果要使用游标更换数据，不能用游标变量 ======================
select * from scores;
/
declare
cursor cur is select * from scores for update;
new_score number;
begin
    for i in cur loop
        new_score := i.score+10;
        if new_score>100 then
            new_score := 100;
        end if;
        update scores set score=new_score where current of cur; 
    end loop;
end;



