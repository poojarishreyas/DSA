# Write your MySQL query statement below
select contest_id, round(count(*)/(select count(*) from Users)*100,2) as percentage
FROM Register r
group by contest_id
order by percentage desc,contest_id asc