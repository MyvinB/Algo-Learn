Theory 
How to increase the speed of queries ? you can do it by indexing

Difference between http vs https 

Java 
Q Internal Working of stuff -> md
Q Why do we need to override equals and hashcode method -> md
Q How do you create a singleton class in java -> https://www.geeksforgeeks.org/singleton-class-java/
Q How do you create a immmutable class in java -> immutable java 




Tomact
Explain internal engine of tomcat server


SpringBoot
Give the different types of injection in spring boot
Explain inversion of control
Do you know any sprinboot cli commands
Explain Spring boot model view controller
Explain about a few modules in spring boot

Q) why do we use controller advice? (remeber controller adivce is async )
https://medium.com/@jovannypcg/understanding-springs-controlleradvice-cd96a364033f

Q)Explain the spring life cycle of a bean
https://reflectoring.io/spring-bean-lifecycle/

What is autowiring and name the different modes of it?

Q Why singleton is not thread safe?
A singleton class itself is not thread safe. Multiple threads can access the singleton same time and create multiple objects, violating the singleton concept. The singleton may also return a reference to a partially initialized object.

Q) In try with resource would a plain try give you a syntax error ? No it would not give you a syntax error 

Q) Explain circular dependency in spring boot how is it handled ?
https://www.baeldung.com/circular-dependencies-in-spring

Q)What is a junit lifecycle?
Setup and teardown

Q) Explain garbage collection what algo is used for garbage collection ?
Q) Can static method be overridden and ocerloaded? static method can be overloaded but not overridden 
Q) Explain thread lifecycle ?
https://www.javatpoint.com/life-cycle-of-a-thread
Q) What is flat map in java 8 ?
Q) What is covariant return type in java
https://www.tutorialspoint.com/Covariant-return-types-in-Java#:~:text=Covariant%20return%20type%20refers%20to,for%20non%2Dprimitive%20return%20types.

Q)What are the different ways to create threads in java ?
https://www.javatpoint.com/how-to-create-a-thread-in-java

Q)Suppose you call the thread.run method directly without calling thread.start what will happen ?
https://java2blog.com/can-we-call-run-method-directly-to-start-thread/#:~:text=No%2C%20you%20can%20not%20directly,in%20same%20stack%20as%20main.

Q)Method overriding and different exception states ?
If you are overdding a method and the method in parent class throws exception does child class have to throw exception -> No read article
If you are placed in the above scenario but parent class throws arithmetic exceptrion and child throws exception -> compile time error child cannot have larger exception
If you parent class throws no exception the child class can only throw unchecked exception
https://www.javatpoint.com/exception-handling-with-method-overriding

Q)What is spring mvc ?
https://www.javatpoint.com/spring-mvc-interview-questions




React Js and front end interview qs
Promise async await resolve and reject
https://www.youtube.com/watch?v=Gjbr21JLfgg


Ds Algo
Distance between two nodes in a binary tree?
Write a program to print odd and even numbers using threads
Write a program to simulate dead lock 

Questions not yet asked but imp to know
What is cap theorm? 


O/p questions
class X {
static int i = 11;

static{
i = i-- - --i;
i = 11 - 9 = 2
}

{
i = i++ + ++i;
}
}

class Y extends X{
static{
i = --i - i--;
i =  1 - 1 = 0
}
{
i = ++i + i++;
}
}

public class DriverClass{
public static void main(String[] args){
Y y = new Y();
System.out.println(y.i);
}
}

What is the o/p of this program


What are the different size of int ,long,float ,boolean?
byte	1 byte	Stores whole numbers from -128 to 127
short	2 bytes	Stores whole numbers from -32,768 to 32,767
int	4 bytes	Stores whole numbers from -2,147,483,648 to 2,147,483,647
long	8 bytes	Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
float	4 bytes	Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
double	8 bytes	Stores fractional numbers. Sufficient for storing 15 decimal digits
boolean	1 bit	Stores true or false values
char	2 bytes	Stores a single character/letter or ASCII values


Difference between final finally and finalize