select * from t_goods order by id desc;
insert into t_kinds(kind_name)values('原材料');

select * from t_kinds;

insert into t_goods (id,goods_name,kind_id,unit)
values(301,'钢管',30,'T');

select seq_goods.nextval from dual;

commit;


drop function is_big;
--=========================================
create or replace function goods_type(unit in nvarchar2)
return nvarchar2
as
kind nvarchar2(20);
begin
   if 'T'=upper(unit) then
       kind := '大件物品';
   elsif 'KG'=upper(unit) then
       kind := '一般物品';
   elsif '盒'=unit then
       kind := '包装物品';
   else
       kind := '散装小件';
   end if;
   return kind;
end;


select id, goods_name, goods_type(unit) from t_goods;

set SERVEROUTPUT ON;
declare
aa nvarchar2(30);
begin
    aa := goods_type('T');
    dbms_output.put_line(aa);
    dbms_output.put_line(upper('china'));
end;
