# Write your MySQL query statement below
select w1.id
FROM weather w1
INNER JOIN weather w2
ON DATEDIFF(W1.recordDate,w2.recordDate)=1  where w1.temperature>w2.temperature
