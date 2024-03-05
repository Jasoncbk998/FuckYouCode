-- 表结构
create table user_log(
                         userid bigint,
                         time string
)
    row format delimited
FIELDS TERMINATED BY '|'
LINES TERMINATED BY '\n';)


select

from (
     select
         start_time,
         count(userid) as base_cnt,
         count(distinct if(cover_day=3,1,null)) as 3_cnt
     from (
              select
                  a.userid as userid,
                  a.time as start_time,
                  date_diff( a.time,b.time) as cover_day
              from table as a
                       left join
                   table as b
                   on a.userid = b.userid
              where a.time <= b.time
          )a
     group by start_time
 )b
