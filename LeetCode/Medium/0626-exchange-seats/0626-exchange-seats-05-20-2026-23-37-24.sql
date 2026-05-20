# Write your MySQL query statement below
SELECT id,
       IF(id%2 = 0, LAG(student) OVER (ORDER BY id), IFNULL(LEAD(student) OVER (ORDER BY id), student)) AS student
FROM Seat