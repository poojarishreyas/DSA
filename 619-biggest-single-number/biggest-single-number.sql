SELECT MAX(num) AS num
FROM MyNumbers
where num in (select num from MyNumbers group by num having count(*)=1)