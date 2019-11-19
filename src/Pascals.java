public class Pascals {
    static int fact(int n) {
        int fact = 1;
        for (int i = 2; i <=n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    static int coeff(int n,int r){
        int value;
        value=fact(n)/(fact(r)*fact(n-r));
        return value;
    }


    public static void main(String[] args) {

        for (int i = 0; i <6; i++) {
            for (int j = 0; j <=i ; j++) {

                    System.out.print(coeff(i,j));



            }
            System.out.println();

        }

    }


    }

