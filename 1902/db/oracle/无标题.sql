set serveroutput on;
declare
ran number;
msg varchar2(200);
begin
    ran := trunc(dbms_random.value*100);
    dbms_output.put_line(ran);
    if ran < 30 then
       msg := '小于30';
    elsif ran>=30 and ran <=50 then
       msg := 'between 30 and 50';
    else
       msg := '大于50';
    end if;
    
    dbms_output.put_line(msg);
end;
/
select sys.utl_raw.cast_to_raw( 
dbms_obfuscation_toolkit.md5(input_string=>'china ') )
from dual;

