# Write your MySQL query statement below
WITH t1 AS (
    SELECT t.*
    FROM Trips t
    JOIN Users uc ON t.client_id = uc.users_id AND uc.banned = 'No'
    JOIN Users ud ON t.driver_id = ud.users_id AND ud.banned = 'No'
    WHERE t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
), completed_trips AS(
    SELECT t1.request_at AS Day, COUNT(t1.id) AS completed
    FROM t1
    WHERE t1.status != 'completed'
    GROUP BY t1.request_at
), all_trips AS(
    SELECT t1.request_at AS Day, COUNT(t1.id) AS completed
    FROM t1
    GROUP BY t1.request_at
)

SELECT all_trips.Day, IFNULL(ROUND(completed_trips.completed/all_trips.completed, 2), 0) AS 'Cancellation Rate'
FROM all_trips
LEFT JOIN completed_trips
ON completed_trips.Day = all_trips.Day;