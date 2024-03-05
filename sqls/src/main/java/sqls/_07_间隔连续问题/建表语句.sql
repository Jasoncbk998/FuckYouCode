-- 表结构
create table `liuxu_test.log_table_info`(
                                            uid bigint,
                                            dt string
)
    row format delimited
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n';



-- 示例数据
1|2018-07-11
1|2018-07-12
1|2018-07-14
1|2018-07-16
1|2018-07-17
1|2018-07-18
2|2018-07-11
2|2018-07-14

