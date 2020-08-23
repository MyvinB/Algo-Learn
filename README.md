![GitHub repo size](https://img.shields.io/github/repo-size/myvinb/Algo-Learn?style=plastic)  ![GitHub commit activity](https://img.shields.io/github/commit-activity/m/myvinb/Algo-Learn?style=plastic)


## Algo-Learn
KISS :Keep It Simple Stupid
###### Problems To get back to
        

###### Helpful Links to get by 
[DataStructure and Algorithm Guide](https://leetcode.com/discuss/general-discussion/494279/comprehensive-data-structure-and-algorithm-study-guide)||
[Amazon Interview Problems:](https://leetcode.com/discuss/interview-question/481968/Amazon-Interview-Problems-List-(Updated)/430085)|| [Patterns for Dp:](https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns)                                  

### Interview Preparation Links  
h

### Spring  
https://www.edureka.co/blog/interview-questions/spring-interview-questions/


### CODE->to be understood
src/LeetCode/DP/LC132PalindromePartitioningII

### COMMANDS
To clear your entire Git cache, use the “git rm” command with the “-r” option for recursive.
```
$ git rm -r --cached .
```
### Sql questions asked
max N salary 

select id,salary from emplpoyee e1 where N-1=(select count(DISTINCT salary) from employee e2 where e2.salary>e1.salary); 
->Now this query will be slower because it is querying the entire table if asked for 1st highest 
1st highest
select MAX(salary) from employee;
2nd highest
select salary from employee where salary Not In (select MAX(salary) from employee);

