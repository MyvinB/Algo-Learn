package Company.Amazon;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 6:40 AM 3/14/2022
 * Time Taken:
 */
public class LC1268 {

    public static void main(String[] args) {
        String[] products = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
        System.out.println(suggestedProductsUnderstanding(products,"mouse"));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        System.out.println(Arrays.toString(products));
        int k = searchWord.length();
        Arrays.sort(products);
        LinkedHashMap<String,List<String>> map = new LinkedHashMap();
        for(int i=1;i<=k;i++){
            String subString = searchWord.substring(0,i);
            map.put(subString,new ArrayList<>());
        }
        for(int i=0;i<products.length;i++){
            for(int j=1;j<=Math.min(k,products[i].length());j++){
                String key = products[i].substring(0,j);
                if(map.containsKey(key) && map.get(key).size() <3){
                    map.get(key).add(products[i]);
                }
            }
        }
        System.out.println(map);
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> suggestedProductsUnderstanding(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }

        String key = "";
        for (char c : searchWord.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "~");
            if (ceiling == null || floor == null) break;
            res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) res.add(new ArrayList<>());
        return res;
    }


}
