# Write your MySQL query statement belowFROM 
SELECT employee_id,
Case
    when (employee_id%2=1) AND name NOT LIKE "M%"  then salary
    Else 0
End as bonus

FROM Employees
Order by employee_id ASC

