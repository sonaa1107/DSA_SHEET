# Write your MySQL query statement below
select em.unique_id ,e.name from EmployeeUNI as em right join employees as e on em.id=e.id