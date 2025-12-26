# Write your MySQL query statement below
select s.student_id,s.student_name,sb.subject_name,
count(e.student_id) as attended_exams
from students s
join subjects sb
left join examinations e 
on e.student_id=s.student_id
and sb.subject_name=e.subject_name
GROUP BY
    s.student_id,
    s.student_name,
    sb.subject_name
ORDER BY
    s.student_id,
    sb.subject_name;
