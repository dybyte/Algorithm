# Write your MySQL query statement below
SELECT id,
    CASE
        WHEN ISNULL(p_id) THEN 'Root'
        WHEN id IN (SELECT p_id FROM Tree) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM Tree