package practise;

public class PrimeNumber {
    static boolean isPrime(int a){
        int count=0;
        for(int i=1;i<=a;i++){
           if(a%i==0)count++;
        }
        if(count==2)return true;
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        //System.out.println(isPrime(8));
        int A=4;
        int sum;
        for(int i=1;i<A;i++){
            sum=i+A-i;
            if(isPrime(i)&&isPrime(A-i)){
                System.out.println(i+" "+(A-i));
                break;
            }

        }

    }
}
