create view v_kinds
as select kind_name from t_kinds;

select * from v_kinds;

create or replace view v_goods as
select g.id, g.goods_name,g.unit, k.kind_name name from t_goods g join t_kinds k 
on k.id=g.kind_id; 

select * from v_goods;

create synonym vv_goods for v_goods;

select * from vv_goods;

select * from user_synonyms;




