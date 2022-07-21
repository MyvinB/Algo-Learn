package LeetCodeChallenge.July2022;

public class AdHocStringMan {

    public static void main(String[] args) {
        String ip = "You make a lot of sense";
        int l = ip.length()-1;
        int r = ip.length()-1;
        StringBuilder sb = new StringBuilder();
        while(l>=0){
            //Move l to space
            while(l>=0 && ip.charAt(l)!=' '){
                l--;
            }
            //use a temp pointer to iterate
            for(int i=l+1;i<=r;i++)
                sb.append(ip.charAt(i));
            l--;
            r=l;
            //Reset and all clauses
            sb.append(" ");
        }
        System.out.println(sb.toString());

    }
}
