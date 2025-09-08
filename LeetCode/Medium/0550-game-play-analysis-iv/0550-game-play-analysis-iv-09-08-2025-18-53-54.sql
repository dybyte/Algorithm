# Write your MySQL query statement below
WITH first_login AS (
    SELECT player_id, MIN(event_date) AS first_day
    FROM Activity
    GROUP BY player_id
),
next_day_login AS (
    SELECT DISTINCT f.player_id
    FROM first_login f
    JOIN Activity a
      ON a.player_id = f.player_id
     AND a.event_date = DATE_ADD(f.first_day, INTERVAL 1 DAY)
)
SELECT ROUND(
    (SELECT COUNT(*) FROM next_day_login) * 1.0 / (SELECT COUNT(DISTINCT player_id) FROM Activity),
    2
) AS fraction;
