# Write your MySQL query statement below
SELECT DISTINCT num AS ConsecutiveNums
FROM (
    SELECT num,
        LEAD(num, 1) OVER () AS l1,
        LEAD(num, 2) OVER () AS l2
    FROM Logs
) AS s
WHERE num = l1 AND num = l2;