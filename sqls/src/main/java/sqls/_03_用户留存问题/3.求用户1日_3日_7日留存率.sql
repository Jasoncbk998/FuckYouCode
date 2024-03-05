

-- 1日留存:以基准日的活跃用户数为主,第1天还活跃的用户数/基准日当日用户数

-- 解题思路:
-- 1.进行表的自关联,过滤出右表日期大于左表日期的日志
-- 2.根据行为日期差计算出X日留存用户数,核心是date_diff函数的使用
-- 3.计算用户留存率,其中X日留存率 = X日留存用户数 / 基准日活跃用户数

-- 找到每个用户的开始登录日期去计算留存
select
    start_time,
    round(3_days/base,2) * 100 as 3_day,
    round(5_days/base,2) * 100 as 5_day,
    round(7_days/base,2) * 100 as 7_day
from (
         select
             start_time,
             count(distinct userid) as base ,
             count(distinct if(days=3,userid,null)) as 3_days,
             count(distinct if(days=5,userid,null)) as 5_days,
             count(distinct if(days=7,userid,null)) as 7_days
         from (
                  select
                      userid,
                      start_time,
                      datediff(end_time,start_time) as days
                  from (
                           select
                               a.userid as userid,
                               a.times as start_time,
                               b.times  as end_time
                           from liuxu_test.user_log  as a
                               left join
                                    liuxu_test.user_log as b  on a.userid=b.userid
                           where a.times<=b.times
                       )a
              )b
         group by start_time
     )c
;


-- 拆解
-- userid=1 & a.start_date <= b.start_date
-- 可以知道userid 每一个登录日期以后的每一次登录日期差
SELECT
    a.userid AS a_userid,
    a.start_date AS start_date,
    b.userid AS b_userid,
    b.start_date AS end_date,
    datediff(b.start_date, a.start_date) AS diff_date  -- 0-当日登录
FROM log_data a
         LEFT JOIN log_data b
                   ON a.userid = b.userid
WHERE a.start_date <= b.start_date
  and a.userid=1
order by a.start_date;

+-----------+-------------+-----------+-------------+------------+
| a_userid  | 第一次登录  | b_userid  |  下一次登录   | 间隔天数  |
+-----------+-------------+-----------+-------------+------------+
| 1         | 2019-07-11  | 1         | 2019-07-18  | 7          |
| 1         | 2019-07-11  | 1         | 2019-07-11  | 0          |
| 1         | 2019-07-11  | 1         | 2019-07-14  | 3          |
| 1         | 2019-07-11  | 1         | 2019-07-12  | 1          |
| 1         | 2019-07-11  | 1         | 2019-07-21  | 10         |
| 1         | 2019-07-11  | 1         | 2019-07-16  | 5          |
| 1         | 2019-07-11  | 1         | 2019-07-17  | 6          |
| 1         | 2019-07-11  | 1         | 2019-07-19  | 8          |
| 1         | 2019-07-12  | 1         | 2019-07-18  | 6          |
| 1         | 2019-07-12  | 1         | 2019-07-12  | 0          |
| 1         | 2019-07-12  | 1         | 2019-07-16  | 4          |
| 1         | 2019-07-12  | 1         | 2019-07-14  | 2          |
| 1         | 2019-07-12  | 1         | 2019-07-19  | 7          |
| 1         | 2019-07-12  | 1         | 2019-07-21  | 9          |
| 1         | 2019-07-12  | 1         | 2019-07-17  | 5          |
| 1         | 2019-07-14  | 1         | 2019-07-18  | 4          |
| 1         | 2019-07-14  | 1         | 2019-07-21  | 7          |
| 1         | 2019-07-14  | 1         | 2019-07-19  | 5          |
| 1         | 2019-07-14  | 1         | 2019-07-17  | 3          |
| 1         | 2019-07-14  | 1         | 2019-07-16  | 2          |
| 1         | 2019-07-14  | 1         | 2019-07-14  | 0          |
| 1         | 2019-07-16  | 1         | 2019-07-21  | 5          |
| 1         | 2019-07-16  | 1         | 2019-07-17  | 1          |
| 1         | 2019-07-16  | 1         | 2019-07-19  | 3          |
| 1         | 2019-07-16  | 1         | 2019-07-16  | 0          |
| 1         | 2019-07-16  | 1         | 2019-07-18  | 2          |
| 1         | 2019-07-17  | 1         | 2019-07-21  | 4          |
| 1         | 2019-07-17  | 1         | 2019-07-19  | 2          |
| 1         | 2019-07-17  | 1         | 2019-07-18  | 1          |
| 1         | 2019-07-17  | 1         | 2019-07-17  | 0          |
| 1         | 2019-07-18  | 1         | 2019-07-19  | 1          |
| 1         | 2019-07-18  | 1         | 2019-07-21  | 3          |
| 1         | 2019-07-18  | 1         | 2019-07-18  | 0          |
| 1         | 2019-07-19  | 1         | 2019-07-19  | 0          |
| 1         | 2019-07-19  | 1         | 2019-07-21  | 2          |
| 1         | 2019-07-21  | 1         | 2019-07-21  | 0          |
+-----------+-------------+-----------+-------------+------------+

