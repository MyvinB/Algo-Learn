q) Find the Nth highest salary using sql?


2nd Maximum salary 
select max(salary) from emp where salary not in 
(select max(salary) from emp);


Nth Maximum salary
https://www.youtube.com/watch?v=fh4yBn0oTaM
select salary from emp e1 where N-1 = (select count(distinct salary) from emp e2 where e2.salray>e1.salary)



 QQ --> Given Student And different cast group and their score and the (Mckinsey)

Category Table --> id , String categoryName
Student Table --> id , Name and other details related to student,category id
Exam --> List of different Exams

Linking Tables
CuttOF table --> category id , exam id , cutt off()
Score --> student id , exam id , marks (numeric)


//Top 2 student who have made cleared the cut of from each category in a an exam in a given year


select * from score s where

//find max score for category
