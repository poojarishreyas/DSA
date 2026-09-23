# Write your MySQL query statement below
Select st.student_id,student_name,sb.subject_name,count(e.subject_name) as attended_exams
FROM Students st
Join subjects sb
Left join Examinations e
On st.student_id=e.student_id And sb.subject_name=e.subject_name
Group by student_id,student_name,subject_name
Order by student_id ASC


