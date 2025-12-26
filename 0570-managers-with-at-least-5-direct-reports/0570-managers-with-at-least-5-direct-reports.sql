# Write your MySQL query statement below
SELECT m.name
FROM Employee AS m
JOIN Employee AS e 
  ON e.managerId = m.id
GROUP BY m.id, m.name
HAVING COUNT(*) >= 5;
