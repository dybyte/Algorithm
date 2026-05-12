# Write your MySQL query statement below
SELECT ROUND(AVG(CASE WHEN t.order_date = t.customer_pref_delivery_date THEN 1 ELSE 0 END) * 100, 2) AS immediate_percentage
FROM (
    SELECT
        d.*,
        ROW_NUMBER() OVER (
            PARTITION BY customer_id
            ORDER BY order_date ASC
        ) AS rn
    FROM Delivery d
) t
WHERE rn = 1;

