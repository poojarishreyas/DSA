# Write your MySQL query statement below
Select c.name as Customers
FROM Customers c
Left join Orders o
On c.id=customerId  where o.CustomerId IS NULL