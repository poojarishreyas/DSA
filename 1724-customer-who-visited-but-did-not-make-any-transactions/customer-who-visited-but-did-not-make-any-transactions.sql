# Write your MySQL query statement below
Select v.customer_id,count(v.customer_id) as count_no_trans
From visits v
where NOT EXISTS(select 1
from Transactions t where t.visit_id=v.visit_id)
Group by v.customer_id
