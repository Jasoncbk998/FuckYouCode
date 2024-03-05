-- 示例数据
1001|1002,1003,1004,1005
1002|1001,1007,1008,1010
1003|1002,1004,1006
1004|1005,1006,1008
1005|1002,1001,1004
1006|1002,1003,1004,1007
1007|1004,1010
1008|1001,1002,1003,1004
1009|1005
1010|1001,1003,1004,1005





-- 解
打散后出现AB和BA的情况,使用case when 现在比较一下就始终把小的字母放前面就行了,统一顺序
SELECT
    COUNT(*) AS cnt
FROM
    (
        SELECT
            f_tag,
            COUNT(*) AS cnt
        FROM
            (
                SELECT
--                     保证小的id在前,大的id在后 方便后边聚合
                    CASE WHEN user_id > f_user_id
                         THEN concat_ws(':', user_id, f_user_id)
                    ELSE concat_ws(':', f_user_id, user_id)
                    END AS f_tag
                FROM liuxu_test.user_table lateral view explode(split(friends, ',')) cols as f_user_id
            ) t1
        GROUP BY f_tag
        HAVING cnt = 2
    ) t2
;






1001    1002    1002:1001
1001    1003    1003:1001
1001    1004    1004:1001
1001    1005    1005:1001
1002    1001    1002:1001
1002    1007    1007:1002
可以看到  1001和1002 互为好友
1002    1001    1002:1001
1001    1002    1002:1001
这就是 case when 的原因

SELECT
    user_id,
    f_user_id,
    CASE WHEN user_id > f_user_id
             THEN concat_ws(':', user_id, f_user_id)
         ELSE concat_ws(':', f_user_id, user_id)
        END AS f_tag
FROM liuxu_test.user_table
         lateral view explode(split(friends, ',')) cols as f_user_id
