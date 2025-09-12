# Write your MySQL query statement below
WITH t1 AS (
    SELECT requester_id, COUNT(*) AS count
    FROM RequestAccepted
    GROUP BY requester_id
), t2 AS (
    SELECT accepter_id, COUNT(*) AS count
    FROM RequestAccepted
    GROUP BY accepter_id
)

(
    SELECT t1.requester_id AS id, (IFNULL(t1.count, 0) + IFNULL(t2.count, 0)) AS num
    FROM t1
    LEFT JOIN t2
    ON t1.requester_id = t2.accepter_id
)
UNION
(
    SELECT t2.accepter_id AS id, (IFNULL(t1.count, 0) + IFNULL(t2.count, 0)) AS num
    FROM t1
    RIGHT JOIN t2
    ON t1.requester_id = t2.accepter_id
)
ORDER BY num DESC
LIMIT 1;