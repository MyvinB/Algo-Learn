package LeetCodeChallenge.APR2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 3:27 PM 4/23/2022
 * Time Taken:
 */
public class LC535EncodeAndDecodeTinyURL {

    public static void main(String[] args) {

    }

    public class Codec {

        List<String> res = new ArrayList<>();
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            res.add(longUrl);
            return String.valueOf(res.size()-1);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int index = Integer.valueOf(shortUrl);
            return index<res.size()?res.get(index):"";
        }
    }
}
