# Write your MySQL query statement below
-- distinct salary 4000 4000 3000 
SELECT IFNULL((SELECT DISTINCT e.salary
FROM Employee e
ORDER BY e.salary DESC
LIMIT 1 OFFSET 1),null) AS SecondHighestSalary;