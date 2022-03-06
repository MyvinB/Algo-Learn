q) Find the Nth highest salary using sql?


2nd Maximum salary 
select max(salary) from emp where salary not in 
(select max(salary) from emp);


Nth Maximum salary
https://www.youtube.com/watch?v=fh4yBn0oTaM
select salary from emp e1 where N-1 = (select count(distinct salary) from emp e2 where e2.salray>e1.salary)
