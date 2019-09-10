set serveroutput on;

declare
refcur SYS_REFCURSOR;
begin
    open refcur for 'select * from t_kinds';
    dbms_sql.return_result(refcur);
end;