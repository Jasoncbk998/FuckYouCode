select
    uid,
    group_id,
    count(*) as cnt,
    max(dt) as max_dt,
    min(dt) as min_dt
from (
 select
     uid,
     dt,
     date_sub(dt,rn) as group_id
 from  (
           select
               uid,
               dt,
               row_number() over(partition by uid order by dt desc ) rn
           from table
    ) t2
)t3
group by uid,group_id
having  cnt>=7