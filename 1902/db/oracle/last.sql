-- 批量添加数据
CREATE TABLE t_goods2
    AS
        SELECT
            *
        FROM
            t_goods
        WHERE
            1 = 2;

SELECT
    *
FROM
    t_goods2;

DROP TABLE t_goods2;

INSERT INTO t_goods2
    SELECT
        *
    FROM
        t_goods
    WHERE
        id < 20;

--索引

begin 
   FOR i IN 1..100 loop
        insert into t_goods (id,goods_name,kind_id, unit)
        values(seq_goods.nextval,'goods_'||i, 20,'T');
   end loop;
end;

select count(*) from t_goods;

select * from t_goods where goods_name='goods_48808906';

select * from t_goods where id=454548;

create bitmap index idx_goods_name on t_goods(kind_id,id);
create index idx_goods_name on t_goods(upper(goods_name));

select * from user_constraints;

alter table t_goods drop constraint sys_c007015;


commit;
/
select * from t_goods order by id desc;
delete from t_goods nologing where id=10000000;
rollback;

truncate table t_goods  ;

select * from user_constraints;
alter table t_logs drop constraint FK_LOGS_GOODS;

select * from t_logs;