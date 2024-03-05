-- 表结构
create table userlog(
    userid bigint,
    month string,
    pv bigint
)
    row format delimited
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n';


-- 示例数据
1|2019-01|10
1|2019-02|20
1|2019-03|10
1|2019-04|30
1|2019-05|40
2|2019-01|20
2|2019-02|10
2|2019-03|30
2|2019-04|10
2|2019-05|20
3|2019-01|10
3|2019-02|20
3|2019-03|50
3|2019-04|20
3|2019-05|10
