package Company.Concepts.Practise;

/**
 * @author mmichaelbarboza
 * on 10:04 AM 3/2/2022
 * Time Taken:
 */
public class QImmutableClass {
    public static void main(String[] args) {
        // ALl Wrapper classes are immutable classes in java
        Integer t = 1;

        //The class must be declared as final so that child classes can’t be created.
        //Data members in the class must be declared private so that direct access is not allowed.
        //Data members in the class must be declared as final so that we can’t change the value of it after object creation.
        //A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
        //Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)

    }
}
