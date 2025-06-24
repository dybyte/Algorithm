# Write your MySQL query statement below
select d.name as Department, e.name as Employee, e.salary as Salary
from Employee e
join Department d
on e.departmentId = d.id
join (
    select MAX(e2.salary) as max, e2.departmentId as id
    from Employee e2
    group by e2.departmentId
) sub on e.salary = sub.max and e.departmentId = sub.id;