# Write your MySQL query statement below
select u.user_id as buyer_id, join_date, ifnull(count(order_id),0) as orders_in_2019
from users u
left join Orders o
on u.user_id=o.buyer_id AND Year(order_date)=2019
group by u.user_id
