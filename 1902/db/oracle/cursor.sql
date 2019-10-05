set SERVEROUTPUT ON;
declare
ii number;
begin
    --select count(*) into ii from t_kinds;
    update t_kinds set kind_name=kind_name;
    dbms_output.put_line(sql%rowcount);
    if sql%isopen then
        dbms_output.put_line('open');
    else
        dbms_output.put_line('close');
    end if;
end;

declare
cursor cur is select id, kind_name from t_kinds;
idd number;
name nvarchar2(20);
begin
    open cur;
    loop
        fetch cur into idd, name;
        exit when cur%notfound;
        dbms_output.put_line(cur%rowcount || ':' ||idd || name);
        dbms_output.put_line('-----');
    end loop;
    close cur;
end;
--=====================for=============================
declare
cursor cur is select * from t_kinds ;
begin
   for i in cur loop
   dbms_output.put_line(i.id ||':' ||i.kind_name);
   end loop;
end;

--=====================================================
set SERVEROUTPUT ON;
declare
cursor cur(name nvarchar2) is select * from t_kinds where kind_name=name;
idd number;
name t_kinds.kind_name%type; -- 参照了kind_name列的类型。
i t_kinds%rowtype; -- 参照的是一行,行有几列，就有几列。
begin
    open cur('工具');
    fetch cur into i; --idd, name;
--    dbms_output.put_line(idd || ':' || name);
    dbms_output.put_line(i.id || ':' || i.kind_name);
    close cur;

    exception
     when cursor_already_open then
      dbms_output.put_line('repeat open');
      when invalid_cursor then
      dbms_output.put_line('invalid cursor');
end;
--======================================================
declare
type t_row is record(id number, name nvarchar2(20), ro number);--类型
i t_row; --  申明变量
cursor cur is select k.*, rownum  from t_kinds k;
begin
    open cur;
    loop 
       fetch cur into i;
       if cur%notfound then
         exit;
       end if ;
       dbms_output.put_line(i.id ||':'||i.name || ':'|| i.ro);
    end loop;
    close cur;
end;

--=======================有多个参数的游标==============================
declare
cursor cur(minval number,maxval number) is 
    with temp as (select * from t_goods order by id desc)
    select * from
    (select t.*, rownum ro from temp t where rownum <=maxval)
    where ro>minval;
type t_row is record
    (id t_goods.id%type, 
     name nvarchar2(20), 
     kind_id number, 
     unit t_goods.unit%type,
     ro number );
i t_row;
begin
   open cur(0, 10);
      loop
         fetch cur into i ;
         exit when cur%notfound;
         dbms_output.put_line(i.id ||':' ||i.name );
      end loop;
   close cur;
end;

/
select * from
(select a.*, rownum ro from(
select * from t_goods order by id desc)a where rownum <=20)
where ro>10;

with temp as (select * from t_goods order by id desc)
select * from
(select t.*, rownum ro from temp t where rownum <=20)
where ro>10;

-- 可写入的游标
declare
cursor cur is select * from t_kinds for update;
begin
    for i in cur loop
      update t_kinds set kind_name=substr(i.kind_name,0,2) where current of cur;
    end loop;
end;
commit;

--================================