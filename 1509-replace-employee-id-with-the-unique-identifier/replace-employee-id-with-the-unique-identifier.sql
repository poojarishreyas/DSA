# Write your MySQL query statement below
Select unique_id,name
From Employees e
Left join EmployeeUNI u
ON e.id=u.id
