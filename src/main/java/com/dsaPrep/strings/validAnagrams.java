package com.dsaPrep.strings;

import java.util.HashMap;
import java.util.Map;

public class validAnagrams {

    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) return false;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }

        for(int i = 0; i < m ; i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)){
                return false;
            }
            else{
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }
        return true;
    }
}
