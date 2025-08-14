package com.dsaPrep.strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char last[] = strs[strs.length-1].toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < first.length; i++){
            if(first[i] != last[i]){
                break;
            }
            result.append(first[i]);
        }
        return result.toString();
    }
}
