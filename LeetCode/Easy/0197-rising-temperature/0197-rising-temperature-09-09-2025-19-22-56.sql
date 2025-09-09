# Write your MySQL query statement below
SELECT w.id
FROM Weather w
WHERE (
    SELECT temperature
    FROM Weather
    WHERE recordDate = DATE_ADD(w.recordDate, INTERVAL -1 DAY)
) < w.temperature;