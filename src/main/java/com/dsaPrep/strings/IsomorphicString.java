package com.dsaPrep.strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) return false;
        Map<Character,Character> mapA = new HashMap<>();
        Map<Character,Character> mapB = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(mapA.containsKey(ch1)){
                if(mapA.get(ch1) != ch2){
                    return false;
                }
            }
            mapA.put(ch1,ch2);
            if(mapB.containsKey(ch2)){
                if(mapB.get(ch2) != ch1){
                    return false;
                }
            }
            mapB.put(ch2,ch1);
        }

        return true;
    }
}
