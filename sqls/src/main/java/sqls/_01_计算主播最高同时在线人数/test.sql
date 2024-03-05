
select
    max(onilne_cnts)
from(
    select
        uid,
        dt,
        sum(flag)over(order by dt) as onilne_cnts
    from (
             select
                 uid,
                 dt,
                 1 as flag
             from table

             union all

             select
                 uid,
                 dt,
                 -1 as flag
             from table
         )a
)b

