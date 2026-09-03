# Write your MySQL query statement below
SELECT name
FROM SalesPerson
WHERE sales_id NOT IN (
    SELECT s.sales_id
    FROM SalesPerson s
    LEFT JOIN Orders o ON o.sales_id = s.sales_id
    LEFT JOIN Company c ON c.com_id = o.com_id
    WHERE c.name = 'RED'
)
