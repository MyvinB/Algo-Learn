package practise;/*String subsequnce count the charachter differnce and give the number of character*/

public class Scon {
    public static void main(String[] args) {
        String s="cdeabcgcde";
        char a[]=s.toCharArray();
        String scon="";
        int count=0;
        int p= Integer.MIN_VALUE;

        for (int i = 0; i <a.length ; i++) {

            for (int j = i+1; j <a.length ; j++) {
                if(a[i]+2==a[j]){

                   System.out.println((char)a[i]+"  "+(char)a[j]+i+j);
                    if(!scon.contains(String.valueOf(a[i]))&&a[i]>p){
                        ++count;
                        scon=scon+String.valueOf(a[i]);
                    }
                    if(!scon.contains(String.valueOf(a[j]))&&a[j]>p){
                        ++count;
                        scon=scon+String.valueOf(a[j]);
                    }
                   p=scon.charAt(count-2);
                    System.out.println(scon+"   scon");
                }
            }


        }
        System.out.println(count);
    }
}
