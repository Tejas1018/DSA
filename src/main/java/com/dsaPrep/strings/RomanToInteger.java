package com.dsaPrep.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        int length = s.length();
        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        int integer = 0;
        // If curr value < next char value --> subtract curr value in res. varable
        // If curr value > next char val --> add to the res variable
        for(int i = 0; i < length-1; i++){
            if(romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i+1))){
                integer = integer - romanMap.get(s.charAt(i));
            }
            else{
                integer += romanMap.get(s.charAt(i));
            }
        }
        integer += romanMap.get(s.charAt(length-1));
        return integer;
    }
}
