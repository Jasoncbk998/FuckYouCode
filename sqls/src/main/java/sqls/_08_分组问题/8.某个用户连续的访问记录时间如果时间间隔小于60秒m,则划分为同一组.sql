-- 例如一个用户在11 12 13 14 16 17登录了，则可以认为该用户连续7天登录

--
-- 解题思路：
-- 1.通过lag函数获取到当前访问时间的上一个访问时间；
-- 2.获取访问时间的差值，观察分组规律进行分组，获取到关键的group_id

select
    uid
from (
     select
         uid
         (datediff(max(dt), min(dt)) + 1) AS date_cnt
     from (
              SELECT
                  uid,
                  showtime as dt , -- 转为标准日期格式
                  diff_showtime,
                  SUM(IF(diff_showtime > 60, 1, 0)) over(partition by uid order by showtime) AS group_id -- 0是访问时间相差一天以内,通过sum分区聚合函数对数据进行区分,本次与上次连续登录的数据为0
              FROM
                  (
                      SELECT
                          uid,
                          showtime,--本次访问时间
                          showtime - lag(showtime, 1, 0) over(partition by uid order by showtime) AS diff_showtime -- 本次访问时间与上次访问时间的diff
                      FROM show_table
                  ) t1
          )a
     where group_id=0
)b
where date_cnt=7 -- 7天连续登录
group by uid;
