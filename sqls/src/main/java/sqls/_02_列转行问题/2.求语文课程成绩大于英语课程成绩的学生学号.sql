-- id,stuid,course,score
-- 1|1|yuwen|43
-- 2|1|shuxue|55
-- 3|1|english|55
-- 4|2|yuwen|77
-- 5|2|shuxue|88
-- 6|2|english|88
-- 7|3|yuwen|98
-- 8|3|shuxue|65
-- 9|3|english|80

--     求语文成绩大于英语成绩的学生学号
-- 列转行,把一列拆成行
SELECT
    stuid,
    MAX(yuwen_score) AS yuwen_score,
    MAX(shuxue_score) AS shuxue_score,
    MAX(englisg_score) AS englisg_score
FROM
    (
        SELECT
            stuid,
            if(course = 'yuwen', score, 0) AS yuwen_score,
            if(course = 'shuxue', score, 0) AS shuxue_score,
            if(course = 'english', score, 0) AS englisg_score
        FROM score_table
    ) t1
GROUP BY stuid
HAVING yuwen_score > englisg_score
