set serveroutput on;
-- 表类型
declare
type rec is record (id number, name varchar2(10 char));-- 定义一个记录类型
type t_tbl is table of rec index by binary_integer; --- 定义一个（索引）表类型
tbl t_tbl; -- 定义一个表类型对象。
idx binary_integer := 0;  --表的索引值
begin
   tbl(idx).id := 1;
   tbl(idx).name := 'wang';
   idx := idx+1;
   tbl(idx).id := 2;
   tbl(idx).name := 'xie';
   
--   idx := 0;
--   dbms_output.put_line(tbl(idx).id || tbl(idx).name);
--   idx := idx+1;
--   dbms_output.put_line(tbl(idx).id || tbl(idx).name);
   
   idx := tbl.first;
   loop
       exit when idx is null;
       dbms_output.put_line(tbl(idx).id || tbl(idx).name);
       idx:=tbl.next(idx);
   end loop;
   
end;