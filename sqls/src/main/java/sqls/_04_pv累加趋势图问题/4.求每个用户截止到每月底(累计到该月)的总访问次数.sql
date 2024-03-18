-- 解题思路1：自关联
--     1.进行表的自关联、过滤出左表日期大于右表日期的数据
--     2.按照左表月份聚合，右表pv求和

-- 求每个用户截止到每月底(累计到该月)的总访问次数

-- 求得每个用户，每个月的总访问次数
WITH distinct_user_log AS (
    SELECT
        userid,
        month,
        SUM(pv) AS pv
    FROM userlog
    GROUP BY userid, month
)


SELECT
    userid,
    month,
    sum(pv) AS pv
FROM
    (
    SELECT
    t1.userid AS userid,
    t1.month AS month,
    t2.pv AS pv
    FROM distinct_user_log t1
    LEFT JOIN distinct_user_log t2
        ON t1.userid = t2.userid
    WHERE t1.month >= t2.month
    ) t3
GROUP BY userid, month



-- 方法二
select
    userid,
    month,
    sum(pvs) over (partition by userid order by month asc ) as sums
from (
    select
        userid,
        month,
        sum(pv) as pvs
    from liuxu_test.userlog
    group by userid,month
)a

