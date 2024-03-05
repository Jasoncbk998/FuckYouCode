
-- 题目：求每个店铺截止到每月月底(累计到该月)的总访问uv
--     每个用户访问商铺shop_id的商品时都会产生一条访
-- shop_id bigint,
-- product_name string,
-- user_id  bigint,
-- visitstamp  string

-- 方法1
-- 开窗
-- 这个很少用,不错的想法
--  size(collect_set(user_id) over(partition by shop_id order by visit_month))

SELECT
    shop_id,
    size(collect_set(user_id) over(partition by shop_id order by visit_month))
FROM
    (
    SELECT
    shop_id,
    user_id,
    substring(visitstamp,0,7) AS visit_month
    FROM liuxu_test.visitlog
    ) t1
;



-- 方法2
WITH visit_log1 AS (
    SELECT
        shop_id,
        substring(visitstamp, 0, 7) AS visit_month,
        user_id
    FROM liuxu_test.visitlog
)

SELECT
    shop_id,
    visit_month,
    COUNT(DISTINCT user_id) AS pv
FROM
    (
        SELECT
            t1.shop_id,
            t1.visit_month,
            t2.user_id
        FROM visit_log1 as t1
                 LEFT JOIN  visit_log1  as t2
                            ON t1.shop_id = t2.shop_id
        WHERE t1.visit_month >= t2.visit_month

    ) t3
GROUP BY shop_id, visit_month
;



