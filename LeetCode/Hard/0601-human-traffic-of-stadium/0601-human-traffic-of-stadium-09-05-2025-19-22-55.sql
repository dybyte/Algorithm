# Write your MySQL query statement below
SELECT id, visit_date, people
FROM (
    SELECT id, LEAD(id, 1) OVER(ORDER BY id) AS id1, LEAD(id, 2) OVER (ORDER BY id) AS id2,
    visit_date, people,
    LAG(id, 1) OVER(ORDER BY id) AS prev1, LAG(id, 2) OVER (ORDER BY id) AS prev2
    FROM Stadium
    WHERE people >= 100
) AS s
WHERE (id+1 = id1 AND id1+1 = id2) OR (prev2+1 = prev1 AND prev1+1 = id) 
OR (prev1+1 = id AND id+1 = id1);