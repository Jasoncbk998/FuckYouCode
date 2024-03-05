SELECT
    uid,
    MIN(dt) AS min_dt,
    MAX(dt) AS max_dt,
    group_id, -- 连续登录7天的起始天,从这一天开始连续登录天
    COUNT(*) AS cnt
FROM
    (
        SELECT
            uid,
            dt,
            date_sub(dt, rn) AS group_id  -- 登录日期 - rn = 分组id
        FROM
            (
                SELECT
                    uid,
                    dt,
                    row_number() over(partition by uid order by dt asc) AS rn  -- 给组内数据编号
                FROM logtable
            ) t1
    ) t2
GROUP BY uid, group_id
HAVING cnt >= 7

