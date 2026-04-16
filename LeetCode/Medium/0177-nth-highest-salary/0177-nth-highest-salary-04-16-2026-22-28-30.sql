CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE a INT;
  SET a = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT IFNULL((SELECT DISTINCT e.salary
      FROM Employee e
      ORDER BY e.salary DESC
      LIMIT 1 OFFSET a), NULL)
  );
END