package Company.Concepts.Practise;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author mmichaelbarboza
 * on 5:51 AM 2/8/2022
 * Time Taken:
 */
public class Java8 {



    interface Condition{
        boolean isApp(int n);
    }

    private static int sum (int[] A,Condition condition){
        int result =0;
        for(int i=0;i<A.length;i++){
            result+=condition.isApp(A[i])?A[i]:0;
        }
        return result;
    }


    public static void main(String[] args) {
//        System.out.println(sum(new int[]{1,2,3,4,5,6},(n)->n%2==0));
//        List<String> temp = Arrays.asList(new String[]{"Shakira","Myvin","Mylis","Ankita","Rahul","Brajesh","Neha"});
//        temp.stream().filter((s)->s.startsWith("M")).forEach(System.out::print);
//        System.out.println();
//        temp.stream().sorted((a,b)->b.compareTo(a)).forEach(System.out::print);
//        System.out.println();
//        temp.stream().map(String::toUpperCase).forEach(System.out::print);
//        System.out.println();
//        System.out.println(temp.stream().filter((s)->s.startsWith("M")).count());

        System.out.println("The stream after applying "
                + "the function is : ");

        // Creating a list of Integers
        List<Integer> list = Arrays.asList(3, 6, 9, 12, 15);

        // Using Stream map(Function mapper) and
        // displaying the corresponding new stream
        list.stream().map(number -> number * 3).forEach(System.out::println);

        //Use of flatMap
        //creating ArrayList
        List<String> productlist1 = Arrays.asList("Printer", "Mouse", "Keyboard", "Motherboard");
        List<String>  productlist2 = Arrays.asList("Scanner", "Projector", "Light Pen");
        List<String> productlist3 = Arrays.asList("Pen Drive", "Charger", "WIFI Adapter", "Cooling Fan");
        List<String> productlist4 = Arrays.asList("CPU Cabinet", "WebCam", "USB Light", "Microphone", "Power cable");
        List<List<String>> allproducts = new ArrayList<List<String>>();
//adding elements to the list
        allproducts.add(productlist1);
        allproducts.add(productlist2);
        allproducts.add(productlist3);
        allproducts.add(productlist4);

        List<String> flatMapList = allproducts .stream().flatMap(pList -> pList.stream()).collect(Collectors.toList());
        System.out.println(flatMapList);

        //Use of reduce
        List<Integer> numbers = Arrays.asList(1, 1, 1, 1, 1, 2);
        int result = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(result+"Result of using reduc e");

        //Use of filtrer
        // Creating a list of Integers
        List<Integer> list1 = Arrays.asList(3, 4, 6, 12, 20);

        // Getting a stream consisting of the
        // elements that are divisible by 5
        // Using Stream filter(Predicate predicate)
        list1.stream()
                .filter(num -> num % 5 == 0)
                .forEach(System.out::println);
        //Give the count of each character in a string using java 8 IMP
        String str= "Communication";
        Map<String, Long> result1 = Arrays.stream(str.split("")).map(String::toLowerCase).collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));

    }
}
