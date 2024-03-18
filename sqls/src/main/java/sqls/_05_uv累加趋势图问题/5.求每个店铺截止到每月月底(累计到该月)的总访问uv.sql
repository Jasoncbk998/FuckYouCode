
-- 题目：求每个店铺截止到每月月底(累计到该月)的总访问uv
--     每个用户访问商铺shop_id的商品时都会产生一条访
-- shop_id bigint,
-- product_name string,
-- user_id  bigint,
-- visitstamp  string

shop_id product_name   user_id  visit_month
1001    product_a      1010     2021-06
1001    product_b      1111     2021-06
1001    product_c      1212     2021-07
1001    product_a      1313     2021-07
1001    product_d      1010     2021-08
2001    product_a      1515     2021-06
2001    product_b      1616     2021-06
2001    product_c      1717     2021-07
2001    product_d      1313     2021-08
2001    product_e      1212     2021-09
3001    product_f      1818     2021-06
3001    product_a      1515     2021-06
3001    product_b      1111     2021-07
3001    product_a      1212     2021-08
3001    product_b      1313     2021-09


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



