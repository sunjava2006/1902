-- 添加记录语法
INSERT INTO types VALUES (1000, '分类', null);
INSERT INTO types VALUES (1, '美食', 1000); 
INSERT INTO types values(2,'医院', 1000);
INSERT INTO types values(3, '购物', 1000);
INSERT INTO types values (4, '公交',1000);
INSERT INTO types values (5, '加油站',1000);
INSERT INTO types values (6, '住宿',1000);
--============================================================
INSERT INTO types VALUES (2000, '周边', null); 
INSERT INTO types values (7, '500米以内',2000);
INSERT INTO types values (8, '1公里以内',2000);
INSERT INTO types values (9, '2公里以内',2000);
INSERT INTO types values (10, '3公里以内',2000);
INSERT INTO types values (11, '5公里以内',2000);
--============================================
INSERT INTO types values (12, '小龙虾',1);
INSERT INTO types values (13, '快餐',1);
INSERT INTO types values (14, '烧烤',1);
INSERT INTO types values (15, '火锅',1);

commit;

--查询数据的语法
SELECT id, type_name, parent_id FROM types;

-- ==================  添加locations ========================
INSERT INTO locations VALUES(1,13,'瑞幸咖啡',32.1566991236,118.6974692345,'瑞幸咖啡,首杯不要钱。');
INSERT INTO locations VALUES(2,13,'便利蜂',32.1566991236,118.6974692345,'便利蜂，一个生产“蜂蜜的地方”。');
INSERT INTO locations VALUES(3,13,'金元宝快餐厅',32.1556273250,118.6971259117,'金元宝快餐厅');
INSERT INTO locations VALUES(4,3,'江北龙湖天街',32.1577300367,118.6969757080,'江北龙湖天街');
--32.1652957642,118.7043678761
INSERT INTO locations VALUES(5,2,'明康眼科医院',32.1652957642,118.7043678761,'明康眼科医院');
commit;
select * from locations where type_id=13;

-- 32.1566627916,  118.6975067854 500米以内的，所有单位.(100米0.001)
select * from locations where 
latitude>=32.1566627916-0.01 and latitude<=32.1566627916+0.01
and  longitude>=118.6975067854-0.01 and longitude<=118.6975067854+0.01;

select * from locations where latitude BETWEEN :latmin and satmax
and longitude BETWEEN -0.01 and longitude+0.01;





