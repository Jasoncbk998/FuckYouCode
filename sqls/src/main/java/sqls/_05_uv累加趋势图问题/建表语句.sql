-- 表结构
create table visitlog(
     shop_id bigint,
     product_name string,
     user_id  bigint,
     visitstamp  string
)
    row format delimited
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n';

-- 示例数据
1001|product_a|1010|2021-06-14 18:11:11
1001|product_b|1111|2021-06-15 19:12:12
1001|product_c|1212|2021-07-17 12:13:13
1001|product_a|1313|2021-07-19 11:14:12
1001|product_d|1010|2021-08-20 13:15:15
2001|product_a|1515|2021-06-14 15:12:12
2001|product_b|1616|2021-06-14 16:16:16
2001|product_c|1717|2021-07-14 17:12:12
2001|product_d|1313|2021-08-14 19:12:17
2001|product_e|1212|2021-09-14 10:16:17
3001|product_f|1818|2021-06-14 11:12:12
3001|product_a|1515|2021-06-14 12:12:18
3001|product_b|1111|2021-07-14 13:17:16
3001|product_a|1212|2021-08-14 15:12:17
3001|product_b|1313|2021-09-14 18:16:17
