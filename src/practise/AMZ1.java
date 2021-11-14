package practise;

public class AMZ1 {
    public static void main(String args[]) {
        System.out.println(minimumNumber(4321));
    }

    public static int minimumNumber(int n){
        String s =""+n;
        int[] a = new int[s.length()];
        for (int i = 0; i <s.length() ; i++) {
            a[i] = Integer.parseInt(""+s.charAt(i));
        }
        Arrays.sort(a);
        int p1=0,p2=0;
        for (int i = 0; i <a.length ; i++) {
            if(i%2==0){
                p1=p1*10+a[i];
            }else{
                p2=p2*10+a[i];
            }
        }

        return p1+p2;
    }

}
