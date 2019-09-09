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

