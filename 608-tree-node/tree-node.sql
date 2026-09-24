select id,case
    when p_id is Null then 'Root'
    when p_id is NOT null AND id IN(select distinct p_id from Tree) then 'Inner'
    else 'Leaf'
    End as type
from Tree