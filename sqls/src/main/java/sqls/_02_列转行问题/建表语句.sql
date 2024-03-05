-- 表结构
create table liuxu_test.score_table(
    id int,
    stuid int,
    course string,
    score bigint
)
row format delimited
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n';


hive_beeline_dm -e "load data local inpath '/home/liuxu_dxm/temp/score' overwrite into table liuxu_test.score_table  "


1|1|yuwen|43
2|1|shuxue|55
3|1|english|55
4|2|yuwen|77
5|2|shuxue|88
6|2|english|88
7|3|yuwen|98
8|3|shuxue|65
9|3|english|80