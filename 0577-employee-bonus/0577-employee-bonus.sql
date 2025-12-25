# Write your MySQL query statement below
SELECT e.name, b.bonus
FROM employee e
left JOIN bonus b
ON e.empId = b.empId
WHERE b.bonus < 1000 || bonus is null;
