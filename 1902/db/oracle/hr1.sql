set SERVEROUTPUT ON;
declare
counter number:=0;
begin
   select salary into counter from employees  where employee_id=100;
    dbms_output.put_line(sql%rowcount);
    if sql%isopen then
      dbms_output.put_line('open');
    else
      dbms_output.put_line('close');
    end if;
   exception
     when others then
        null;
  end;
  --
  
  
-- 游标
declare
cursor cur is select first_name, salary from employees where salary>10000;
fname employees.first_name%type;
sal number;
begin
   open cur; -- 打开游标，将执行查询，并返回查询结果
   open cur;
   dbms_output.put_line(cur%rowcount);
   close cur;  -- 关闭游标，释放查询结果。
   open cur;
   loop
        fetch cur into fname, sal;
        exit when cur%notfound;
        dbms_output.put_line(fname || '  ' || sal);
        dbms_output.put_line(cur%rowcount);
   end loop;
  
   close cur;  -- 关闭游标，释放查询结果。
 exception
   when invalid_cursor then
       dbms_output.put_line('已经关了');
  when cursor_already_open then
     dbms_output.put_line('重复打开');
end;


select first_name, salary from employees where salary>10000;

--========================= for cursor ========
declare
cursor cur(sal number, did number) is select * from employees where salary>sal and department_id>=did 
order by department_id;
begin
    for i in  cur(10000, 50) loop
        dbms_output.put_line(i.first_name || ' '||i.salary ||' ' ||  i.department_id);
    end loop;
end;
--============================  游标变量 ================
declare
type ref_cur is ref cursor; --定义数据类型，是引用游标
cur ref_cur; -- 申明变量，类型是引用游标
i employees%rowtype; -- 参照employees表中，行的类型。i中有与employees相同的列。一个复合类型。
stm varchar2(200);
begin
    stm := 'select * from employees';
    open cur for stm;
    loop
       fetch cur into i ;
       exit when cur%notfound;
       dbms_output.put_line(i.first_name || ' ' || i.last_name);
    end loop;
    close cur;
end;

--============================== 引用系统中的引用游标类型，record类型 ==============================
declare
ref_cur sys_refcursor; -- 定义变量 ，使用了系统中已经定义的引用游标类型。
type rec is record (id  number, fname varchar2(50)); -- 定义一个记录类型 rec。
i rec; -- 申明一个记录类型rec的变量 i。
begin
   open ref_cur for 'select employee_id, first_name from employees';
   loop
      fetch ref_cur into i ;
      exit when ref_cur%notfound;
      
      dbms_output.put_line(i.id || ':' || i.fname);
      
   end loop;
   close ref_cur;
end;

-- select * from employees2;
declare
--cur sys_refcursor;
cursor cur is select * from employees2 for update;
i employees2%rowtype;
begin
   open cur;
   loop
      fetch cur into i;
      exit when cur%notfound;
      
      if i.phone_number is null then
         delete from emplolyees2 where current  of cur;
         dbms_output.put_line('delete....');
      end if;
   end loop;
   close cur;
end;




