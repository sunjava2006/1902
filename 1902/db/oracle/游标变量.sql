set SERVEROUTPUT ON;
declare
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



