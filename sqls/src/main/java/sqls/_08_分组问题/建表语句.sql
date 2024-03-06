例如一个用户在11 12 13 14 16 17登录了，则可以认为该用户连续7天登录
-- 表结构
create table `show_table`(
                             uid bigint,
                             showtime string
)
    row format delimited
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n';


-- 示例数据
1|1662172200
1|1662172205
1|1662172210
1|1662172290
2|1662172100



