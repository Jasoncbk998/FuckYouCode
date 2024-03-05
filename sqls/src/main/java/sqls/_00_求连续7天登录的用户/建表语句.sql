-- 表结构
CREATE TABLE `logtable` (
                            uid int,
                            dt string
)
    ROW FORMAT DELIMITED
FIELDS TERMINATED BY '|'
LINES TERMINATED;


-- 示例数据
1|2018-07-11
1|2018-07-12
1|2018-07-13
1|2018-07-14
1|2018-07-15
1|2018-07-16
1|2018-07-17