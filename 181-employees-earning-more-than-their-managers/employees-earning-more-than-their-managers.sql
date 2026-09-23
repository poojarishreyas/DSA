# Write your MySQL query statement below
select e.name as Employee
From Employee e
Inner join Employee m
On e.managerId=m.id
where e.salary>m.salary