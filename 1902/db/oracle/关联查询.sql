select * from types; --13
select * from locations;--5

select l.*,t.id typeid, t.type_name,t.parent_id 
from types t, locations  l
where t.id=l.type_id; -- 迪卡尔乘积

--========================================================
select * from types t
inner join locations l on t.id=l.type_id; -- 内联接查询

select * from 
locations l full  outer join  types t on t.id=l.type_id; --外联接分（左、右、全）

