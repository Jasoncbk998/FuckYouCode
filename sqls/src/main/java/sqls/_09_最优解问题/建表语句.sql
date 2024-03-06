-- 表结构
create table `product_view_log`(
   uid bigint,
   viewtime bigint,
   product_id bigint
)
row format delimited
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n';

-- 示例数据
1|1662172200|10001
1|1662172205|11201
1|1662172210|10321
1|1662172290|13401
2|1662171100|20011
2|1662171200|11301
2|1662171270|11321
2|1662171378|13501

 -- 要求输出
 uid    最早访问的商品    最早访问商品的时间    最晚访问的商品    最晚访问商品对应的时间
 1      10001           1662172200         13401           1662172290
 2      20011           1662171100         13501           1662171378
