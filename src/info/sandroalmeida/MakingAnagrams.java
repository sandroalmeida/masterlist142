package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {

    public static int makeAnagram(String a, String b) {
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        int counter = 0;

        for(char c: a.toCharArray()) mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        for(char c: b.toCharArray()) mapB.put(c, mapB.getOrDefault(c, 0) + 1);

        for(char c: a.toCharArray()){
            if(!mapB.containsKey(c)) {
                counter++;
            } else{
                int qtA = mapA.getOrDefault(c,0);
                int qtB = mapB.getOrDefault(c,0);
                if(qtB > qtA){
                    counter += qtB - qtA;
                    mapA.put(c, 0);
                    mapB.put(c, 0);
                }
            }
        }

        for(char c: b.toCharArray()){
            if(!mapA.containsKey(c)) {
                counter++;
            } else{
                int qtA = mapA.getOrDefault(c,0);
                int qtB = mapB.getOrDefault(c,0);
                if(qtA > qtB){
                    counter += qtA - qtB;
                    mapA.put(c, 0);
                    mapB.put(c, 0);
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(makeAnagram(a, b));
    }
}
