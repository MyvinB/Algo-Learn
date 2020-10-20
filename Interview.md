

##### Java Interview Questions
Java 8-> https://github.com/winterbe/java8-tutorial           
In 28 min->https://bit.ly/micgogijava          
Concurrency concepts-> https://www.youtube.com/channel/UCiz26UeGvcTy4_M3Zhgk7FQ
```
//Immutable class 
/*
The class must be declared as final (So that child classes can’t be created)
Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
A parameterized constructor
Getter method for all the variables in it
No setters(To not have the option to change the value of the instance variable) 
If a mutable object passed to the constructor must be assigned to a field create a defensive copy of it*/
public class DateContainer {
  private final Date date;
  public DateContainer() {
      this.date = new Date();
  }
  public Date getDate() {
    return new Date(date.getTime());
  }
}

public final class Student 
{ 
    final String name; 
    final int regNo; 
  
    public Student(String name, int regNo) 
    { 
        this.name = name; 
        this.regNo = regNo; 
    } 
    public String getName() 
    { 
        return name; 
    } 
    public int getRegNo() 
    { 
        return regNo; 
    } 
} 
```
```
//SingleTon Class
// with getInstance() method 
class Singleton 
{ 
    // static variable single_instance of type Singleton 
    private static Singleton single_instance = null; 
  
    // variable of type String 
    public String s; 
  
    // private constructor restricted to this class itself 
    private Singleton() 
    { 
        s = "Hello I am a string part of Singleton class"; 
    } 
  
    // static method to create instance of Singleton class 
    public static Singleton getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Singleton(); 
  
        return single_instance; 
    } 
} 
```
HashMap Vs. ConcurrentHashMap Vs. SynchronizedMap – How a HashMap can be Synchronized in Java     
https://crunchify.com/hashmap-vs-concurrenthashmap-vs-synchronizedmap-how-a-hashmap-can-be-synchronized-in-java/           
Difference between fail safe and fail fast              
https://medium.com/@mr.anmolsehgal/fail-fast-and-fail-safe-iterations-in-java-collections-11ce8ca4180e         


###Spring
##### Differenc btwn ApplicationContext vs BeanFactory
https://dzone.com/articles/difference-between-beanfactory-and-applicationcont
##### Difference btwn rqst param and query param
https://medium.com/1developer/spring-requestparam-vs-queryparam-vs-pathvariable-vs-pathparam-7c5655e541ad        
##### What is Transactional Isolation and Transaction Progation? 
https://stackoverflow.com/questions/8490852/spring-transactional-isolation-propagation
https://www.youtube.com/watch?v=CTCAo89fcQw      
https://www.javainuse.com/spring/boot-transaction-propagation
##### Monolithic Architecture vs Microservices
https://www.tiempodev.com/blog/disadvantages-of-a-microservices-architecture/   
##### AOP             
https://www.javainuse.com/spring/spring-boot-aop 
###### Helpful Links to get by 

### Hiberate
https://www.dineshonjava.com/difference-between-merge-and-update-methods-in-hibernate/


[DataStructure and Algorithm Guide](https://leetcode.com/discuss/general-discussion/494279/comprehensive-data-structure-and-algorithm-study-guide)||
[Amazon Interview Problems:](https://leetcode.com/discuss/interview-question/481968/Amazon-Interview-Problems-List-(Updated)/430085)|| [Patterns for Dp:](https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns)                                  

```
### Sql questions asked
max N salary         

select id,salary from emplpoyee e1 where N-1=(select count(DISTINCT salary) from employee e2 where e2.salary>e1.salary);          
->Now this query will be slower because it is querying the entire table if asked for 1st highest             
1st highest                  
select MAX(salary) from employee;             
2nd highest            
select salary from employee where salary Not In (select MAX(salary) from employee);

