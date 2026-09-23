# Write your MySQL query statement below
select s.user_id, ifNULL(Round(AVG(c.action='confirmed'),2),0) as confirmation_rate
FROM Signups s
Left join Confirmations c
on s.user_id=c.user_id
Group by user_id