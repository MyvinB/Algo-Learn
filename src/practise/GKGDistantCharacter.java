package practise;

public class GKGDistantCharacter {
    public static void main(String[] args) {
        System.out.println(findString(9,2));
    }

    static String findString(int n, int k)
    {
        int i=0;
        StringBuilder sb=new StringBuilder();
        StringBuilder res = new StringBuilder();

        for(;i<k;i++){
            sb.append((char)('a'+i));
        }
        System.out.println(sb.toString());
        for(int j=k;j<n/2;j++){
            sb.append((char)('a'+k));
        }
        res.append(sb.toString());
        if(n%2!=0){
            sb.append((char)('a'+k));
        }
        res.append(sb.reverse().toString());

        return res.toString();

    }

//    https://www.geeksforgeeks.org/string-k-distinct-characters-no-characters-adjacent/
}
