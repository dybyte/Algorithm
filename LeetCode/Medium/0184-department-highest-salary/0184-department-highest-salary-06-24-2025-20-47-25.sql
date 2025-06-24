# Write your MySQL query statement below
select d.name as Department, e.name as Employee, e.salary as Salary
from Employee e
inner join Department d
on e.departmentId = d.id
where e.salary = (
    select MAX(e2.salary)
    from Employee e2
    left join Department d2
    on e2.departmentId = d2.id
    where e.departmentId = d2.id
);