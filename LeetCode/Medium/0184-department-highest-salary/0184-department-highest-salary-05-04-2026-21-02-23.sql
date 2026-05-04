# Write your MySQL query statement below
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Employee e
JOIN Department d ON d.id = e.departmentId
JOIN (
    SELECT MAX(e.salary) as salary, d.name as name
    FROM Employee e
    JOIN Department d
    ON e.departmentId = d.id
    GROUP BY d.name
) AS sub
ON d.name = sub.name AND e.salary = sub.salary;