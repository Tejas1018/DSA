package com.dsaPrep.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character,Integer> freqMap = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        List<Character> charList = new ArrayList<>(freqMap.keySet());
        charList.sort((a,b)-> freqMap.get(b)-freqMap.get(a));
        StringBuilder result = new StringBuilder();
        for(char ch : charList){
            int freq = freqMap.get(ch);
            for(int i = 0 ;i < freq; i++){
                result.append(ch);
            }
        }
        return result.toString();
    }
}
