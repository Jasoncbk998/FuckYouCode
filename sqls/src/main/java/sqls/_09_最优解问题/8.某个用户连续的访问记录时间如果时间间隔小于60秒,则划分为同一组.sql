-- 示例数据
uid|viewtime|product_id
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



-- 1 开窗+标记
SELECT
    uid,
    MAX(first_product_id) AS first_product_id,
    MAX(first_viewtime) AS first_viewtime,
    MAX(last_viewtime) AS last_viewtime,
    MAX(last_product_id) AS last_product_id
FROM
    (
        SELECT
            uid,
            IF(asc_rk = 1, viewtime, NULL) AS first_viewtime,
            IF(asc_rk = 1, product_id, NULL) AS first_product_id,
            IF(desc_rk = 1, viewtime, NULL) AS last_viewtime,
            IF(desc_rk = 1, product_id, NULL) AS last_product_id
        FROM
            (
                SELECT
                    uid,
                    viewtime,
                    product_id,
--                     两个排序顺序,对应最早和最晚
                    row_number() over(partition by uid order by viewtime asc) AS asc_rk,
                    row_number() over(partition by uid order by viewtime desc) as desc_rk
                FROM product_view_log
            ) t1
        WHERE asc_rk = 1  OR desc_rk = 1
    ) t1
GROUP BY uid


--2 拼接成字符串排序
-- 比较简单
SELECT
    uid,
    split(min(concat_info), '_')[0] AS first_product_id,
    split(min(concat_info), '_')[1] AS first_viewtime,
    split(max(concat_info), '_')[0] AS last_product_id,
    split(max(concat_info), '_')[1] AS last_viewtime
FROM
    (
        SELECT
            uid,
            concat_ws('_', cast(viewtime as string), cast(product_id as string)) AS concat_info
        FROM product_view_log
    ) t1
group by uid


