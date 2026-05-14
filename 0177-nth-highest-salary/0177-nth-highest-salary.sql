CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select distinct salary  from 
      (select  e.salary , dense_rank() over(order by salary desc) as drnk from employee e) as X
      where drnk=N
  );
END