# Write your MySQL query statement below
(SELECT sub.name AS results
FROM (SELECT u.name AS name, COUNT(u.user_id) AS count
FROM MovieRating r
JOIN Users u ON r.user_id = u.user_id
GROUP BY u.user_id) AS sub
ORDER BY sub.count DESC, sub.name ASC
LIMIT 1)

UNION ALL

(SELECT sub.title AS results
FROM (SELECT m.title AS title, SUM(r.rating)/COUNT(m.movie_id) AS average
FROM MovieRating r
JOIN Movies m ON r.movie_id = m.movie_id
WHERE YEAR(r.created_at) = 2020 AND MONTH(r.created_at) = 2
GROUP BY m.movie_id) AS sub
ORDER BY sub.average DESC, sub.title ASC
LIMIT 1)