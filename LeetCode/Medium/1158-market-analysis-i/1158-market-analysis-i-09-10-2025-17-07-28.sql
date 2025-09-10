# Write your MySQL query statement below
WITH ORDER_COUNT AS (
    SELECT IFNULL(COUNT(o.order_id), 0) AS orders_in_2019, u.user_id
    FROM Users u
    LEFT JOIN Orders o
    ON u.user_id = o.buyer_id
    AND YEAR(o.order_date) = '2019'
    GROUP BY u.user_id
)
SELECT u.user_id AS buyer_id, u.join_date, o.orders_in_2019
FROM Users u
LEFT JOIN ORDER_COUNT o
ON u.user_id = o.user_id;
