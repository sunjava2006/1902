create or replace procedure p_todo
as
--declare
--type refcur is ref cursor;
cur SYS_REFCURSOR;
i t_kinds%rowtype;
stm varchar2(200);
begin
   stm := 'select * from t_kinds for update';
   open cur for stm ;
      loop
         fetch cur into i;
         exit when cur%notfound;
         dbms_output.put_line(i.id || ':' || i.kind_name);
         
      end loop;
   close cur;
end;
/

select* from user_procedures;
set SERVEROUTPUT ON;

exec p_todo;

-------------------------------
begin
   p_todo;
end;
--======================参数========================
create or replace procedure p_get_kind(idd in out number, name out nvarchar2)
as
begin
    select kind_name into name from t_kinds where id = idd;
end;

declare
idd number ;
n nvarchar2(20);
begin
idd:=20;
   p_get_kind(idd, n);
   dbms_output.put_line(idd ||n);
end;

--=======================分页查询==========================
create or replace procedure p_list_goods(page in number, siz in number, 
     cur out sys_refcursor )
as
begin
    open cur for  select id, goods_name, kind_id, unit from
    (select g.*, rownum ro from t_goods g where rownum <=page*siz)
    where ro >(page-1)*siz;
end;


--========================
set SERVEROUTPUT ON;
declare
cur sys_refcursor;
i t_goods%rowtype;  
begin
    p_list_goods(1,10, cur);
    loop
        fetch cur into i;
        exit when cur%notfound;
        dbms_output.put_line(i.id || i.goods_name);
    end loop;
    close cur;
end;
