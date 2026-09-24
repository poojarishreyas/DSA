# Write your MySQL query statement below
/*
with t as(
    select t1.salary from Employee t1, Employee t2 where t1.salary<t2.salary
)
select max(salary ) as SecondHighestSalary from t*/
select max(salary) as SecondHighestSalary
From Employee 
where salary<(select max(salary) from Employee)