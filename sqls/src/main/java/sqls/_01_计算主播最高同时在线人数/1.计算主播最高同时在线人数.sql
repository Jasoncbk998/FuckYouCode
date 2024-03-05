
SELECT
    MAX(curr_online_cnt) AS max_online_cnt
FROM
    (
        SELECT
            author_name,
            tt,
            flag,
            SUM(flag) over(order by tt) AS curr_online_cnt
        FROM
            (
                SELECT
                    author_name,
                    stt AS tt,
                    1 AS flag
                FROM author_room_online_info

                UNION ALL

                SELECT
                    author_name,
                    edt AS tt,
                    -1 AS flag
                FROM author_room_online_info
            ) t1
    ) t2



根据时间,进行sum
 SUM(flag) over(order by tt) AS curr_online_cnt,得出同时在线的峰值数量
张伟    2021-06-14 12:12:12     1       1
王静    2021-06-14 13:12:12     1       2
李强    2021-06-14 13:15:12     1       3
李娜    2021-06-14 15:12:12     1       4
王勇    2021-06-14 15:18:12     1       5
王静    2021-06-14 16:12:12     -1      3
李娜    2021-06-14 16:12:12     -1      3
张伟    2021-06-14 18:12:12     -1      2
张伟    2021-06-14 20:12:12     1       1
李强    2021-06-14 20:12:12     -1      1
王勇    2021-06-14 20:12:12     -1      1
李娟    2021-06-14 21:12:12     1       2
张涛    2021-06-14 22:12:12     1       3
张涛    2021-06-14 23:10:12     -1      2
张伟    2021-06-14 23:12:12     -1      1
李娟    2021-06-14 23:15:12     -1      0