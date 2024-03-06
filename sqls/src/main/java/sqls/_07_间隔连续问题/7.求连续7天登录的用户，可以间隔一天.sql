
-- 求连续7天登录的用户，可以间隔一天
    11 12 14 16
    11 14

-- 解题思路：
-- 1.通过lag函数获取到当前登录日期的上一次登录日期；
--     2.观察分组规律进行分组，获取到关键的group_id
--     3.根据分组id，求连续登录天数
-- 1.通过lag函数找到上一次登陆日期
-- 2.然后上一次登录日期和近期登录做diff,得到时间差,也就是间隔时间
-- 3.然后sum(if) 开窗分组得到
--

+------+-------------+-------------+
| uid  |     dt      |   lag_or    |
+------+-------------+-------------+
| 1    | 2018-07-11  | 1970-01-01  |
| 1    | 2018-07-12  | 2018-07-11  |
| 1    | 2018-07-14  | 2018-07-12  |
| 1    | 2018-07-16  | 2018-07-14  |
| 1    | 2018-07-17  | 2018-07-16  |
| 1    | 2018-07-18  | 2018-07-17  |
| 2    | 2018-07-11  | 1970-01-01  |
| 2    | 2018-07-14  | 2018-07-11  |
+------+-------------+-------------+



-- group_id=0的数据是连续登录
+------+-----------+-----------------+
| uid  | group_id  | login_date_cnt  |
+------+-----------+-----------------+
| 1    | 0         | 7               |
+------+-----------+-----------------+
SELECT
    uid,
    group_id,
    login_date_cnt
FROM
    (
        SELECT
            uid,
            group_id,
--             连续天数
            (datediff(max(dt), min(dt)) + 1) AS login_date_cnt
        FROM
            (
                SELECT
                    uid,
                    dt,
--                     group_id 用于判断是否连续登录，如果diff_date>2则不是连续登录,连续登录的标志是0
--                     把所有连续登录的日期进行区分
                    sum(if(diff_date > 2,1,0)) over(partition by uid order by dt desc) AS group_id
                FROM
                    (
                        SELECT
                            uid,
                            dt,
                            lad_dt,
                            datediff(dt, lad_dt) AS diff_date
                        FROM
                            (
                                SELECT
                                    uid,
                                    dt,
                                    -- 取上一次登录的时间，找不到默认日期 1970-01-01
                                    -- lag(dt,1,'1970-01-01')over(partition by uid order by dt)as lad_dt
                                    -- lag 按照uid取上一条数据,如果取不到赋值'1970-01-01
                                    lag(dt,1,'1970-01-01')over(partition by uid order by dt)as lad_dt
                                FROM liuxu_test.log_table_info
                            ) t1
                    ) t2
            ) t3
        GROUP BY uid, group_id
    ) t4
WHERE login_date_cnt >= 7
and group_id=0 -- 此为连续登录

;




SELECT
    uid,
    dt,
    lag(dt,1,'1970-01-01')over(partition by uid order by dt)as lag_or
FROM liuxu_test.log_table_info
+------+-------------+-------------+------------+
| uid  |     dt      |   lag_or    | diff_date  |
+------+-------------+-------------+------------+
| 1    | 2018-07-11  | 1970-01-01  | 17723      |
| 1    | 2018-07-12  | 2018-07-11  | 1          |
| 1    | 2018-07-14  | 2018-07-12  | 2          |
| 1    | 2018-07-16  | 2018-07-14  | 2          |
| 1    | 2018-07-17  | 2018-07-16  | 1          |
| 1    | 2018-07-18  | 2018-07-17  | 1          |
| 2    | 2018-07-11  | 1970-01-01  | 17723      |
| 2    | 2018-07-14  | 2018-07-11  | 3          |
+------+-------------+-------------+------------+
SELECT
    uid,
    dt,
    lad_dt,
    datediff(dt, lad_dt) AS diff_date
FROM
    (
        SELECT
            uid,
            dt,
            -- 上一次登录的时间，找不到默认日期 1970-01-01
            lag(dt,1,'1970-01-01')over(partition by uid order by dt)as lad_dt
        FROM liuxu_test.log_table_info
    ) t1





+------+-------------+-------------+------------+-----------+
| uid  |     dt      |   lad_dt    | diff_date  | 间隔登录分组  |
+------+-------------+-------------+------------+-----------+
| 1    | 2018-07-18  | 2018-07-17  | 1          | 0         |
| 1    | 2018-07-17  | 2018-07-16  | 1          | 0         |
| 1    | 2018-07-16  | 2018-07-14  | 2          | 0         |
| 1    | 2018-07-14  | 2018-07-12  | 2          | 0         |
| 1    | 2018-07-12  | 2018-07-11  | 1          | 0         |
| 1    | 2018-07-11  | 1970-01-01  | 17723      | 1         |
| 2    | 2018-07-14  | 2018-07-11  | 3          | 1         |
| 2    | 2018-07-11  | 1970-01-01  | 17723      | 2         |
+------+-------------+-------------+------------+-----------+
SELECT
    uid,
    dt,
    lad_dt,
    diff_date,
--     求连续7天登录的用户，可以间隔一天
    sum(if(diff_date > 2,1,0)) over(partition by uid order by dt desc) AS group_id
FROM
    (
        SELECT
            uid,
            dt,
            lad_dt,
            datediff(dt, lad_dt) AS diff_date
        FROM
            (
                SELECT
                    uid,
                    dt,
                    -- 上一次登录的时间，找不到默认日期 1970-01-01
                    lag(dt,1,'1970-01-01')over(partition by uid order by dt)as lad_dt
                FROM liuxu_test.log_table_info
            ) t1
    ) t2

+------+-----------+-----------------+
| uid  | group_id  | login_date_cnt  |
+------+-----------+-----------------+
| 1    | 0         | 7               |
| 1    | 1         | 1               |
| 2    | 1         | 1               |
| 2    | 2         | 1               |
+------+-----------+-----------------+

SELECT
    uid,
    group_id,
    (datediff(max(dt), min(dt)) + 1) AS login_date_cnt
FROM
    (
        SELECT
            uid,
            dt,
            sum(if(diff_date > 2,1,0)) over(partition by uid order by dt desc) AS group_id
        FROM
            (
                SELECT
                    uid,
                    dt,
                    lad_dt,
                    datediff(dt, lad_dt) AS diff_date
                FROM
                    (
                        SELECT
                            uid,
                            dt,
                            -- 上一次登录的时间，找不到默认日期 1970-01-01
                            lag(dt,1,'1970-01-01')over(partition by uid order by dt)as lad_dt
                        FROM liuxu_test.log_table_info
                    ) t1
            ) t2
    ) t3
GROUP BY uid, group_id
