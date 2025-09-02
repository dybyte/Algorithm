CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
DETERMINISTIC
BEGIN
   DECLARE offset_value INT;
   SET offset_value = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT IFNULL(
        (SELECT DISTINCT salary
        FROM Employee
        ORDER BY salary DESC
        LIMIT 1 OFFSET offset_value),
        NULL)
  );
END