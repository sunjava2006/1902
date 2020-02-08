set serveroutput on ;

declare
    age natural := 20;
    married boolean  := false;
    name varchar2(4 char);
begin
    name := '张小红';
    dbms_output.put_line('hello world');
    dbms_output.put('name:'||name);
    dbms_output.put('age:'||age);
    dbms_output.new_line();
end;