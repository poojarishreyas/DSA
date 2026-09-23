select e1.name
FROM Employee e1
inner join Employee e2
on e1.id=e2.managerId
group by e2.managerId
Having (count(e2.managerId)>=5)