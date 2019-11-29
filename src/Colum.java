/*  A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28

    and vice versa*/
public class Colum {
    private static void printString(int columnNumber)
    {
        // To store result (Excel column name)
        StringBuilder columnName = new StringBuilder();

        while (columnNumber > 0)
        {
            // Find remainder
            int rem = columnNumber % 26;

            // If remainder is 0, then a
            // 'Z' must be there in output
            if (rem == 0)
            {
                columnName.append("Z");
                columnNumber = (columnNumber / 26) - 1;
            }
            else // If remainder is non-zero
            {
               // System.out.println((char)((rem - 1) + 'A')+"   "+rem);
                columnName.append((char)((rem - 1) + 'A'));
                columnNumber = columnNumber / 26;
            }
        }


        System.out.println(columnName.reverse());
    }
    static int titleToNumber(String s)
    {
        // This process is similar to
        // binary-to-decimal conversion
        int result = 0;
        int l=s.length()-1;
        for (int i = 0; i < s.length(); i++)
        {
            int calc= (int) Math.pow(26,l)*(s.charAt(i)-64);

           result=result+calc;
           l--;
        }
        return result;
    }
    public static void main(String[] args) {
        String ab="ABCD";
        int sum=0;
printString(19010);
        //System.out.println(titleToNumber(ab));
        //System.out.println(19010%26);
    }
}
