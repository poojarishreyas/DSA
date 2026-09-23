# Write your MySQL query statement below
select class
FROM  Courses
GROUP BY class
HAVING count(class)>=5