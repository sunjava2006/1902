create or replace package my_package
as
function sum(a in number, b in number) return number;
end ;
--====================================
create or replace package body my_package 
as
    function sum(a in number, b in number) return number
    as
    begin
       return a+b;
    end;
end;
/
select my_package.sum(1,3) from dual; 