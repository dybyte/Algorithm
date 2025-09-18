# Write your MySQL query statement below
SELECT t1.name AS results
FROM (
    SELECT u.name, COUNT(*) AS count
    FROM MovieRating r
    JOIN Users u
    ON r.user_id = u.user_id
    GROUP BY u.name
    ORDER BY count DESC, name ASC
    LIMIT 1
) AS t1
UNION ALL
SELECT t2.title AS results
FROM (
    SELECT m.title, SUM(r.rating)/COUNT(*) AS average
    FROM MovieRating r
    JOIN Movies m
    ON r.movie_id = m.movie_id
    WHERE YEAR(r.created_at) = '2020' AND MONTH(r.created_at) = '2'
    GROUP BY m.title
    ORDER BY average DESC, title ASC
    LIMIT 1
) AS t2