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