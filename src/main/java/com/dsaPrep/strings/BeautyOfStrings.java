package com.dsaPrep.strings;

public class BeautyOfStrings {
    // Brute Force Approach
    // TC : O(N^3)
    public int beautySum(String s) {
        int length = s.length();

        int totalAns = 0;
        for(int i = 0 ; i < length; i++){
            for(int j = i ; j < length; j++){
                totalAns += findFrequency(s.substring(i,j+1));
            }
        }
        return totalAns;
    }
    int findFrequency(String word){
        int[] charList = new int[26];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < word.length();i++){
            char ch = word.charAt(i);
            charList[ch - 'a']++;
        }

        for(int f : charList){
            if(f > 0){
                min = Math.min(min,f);
                max = Math.max(max,f);
            }
        }
        return max-min;
    }

    // Optimized Approach
    // Instead of caluclating frequency of each substring,
    // We can calculate frequency of each character in the string in a single pass
    //TC : O(N^2)
    public int beautySum1(String s) {
        int length = s.length();

        int totalAns = 0;
        for(int i = 0 ; i < s.length(); i++){
            int[] charList = new int[26];
            for(int j = i ; j < s.length(); j++){
                char ch = s.charAt(j);
                charList[ch - 'a']++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int f : charList){
                    if(f > 0){
                        min = Math.min(min,f);
                        max = Math.max(max,f);
                    }
                }
                totalAns += (max-min);
            }

        }
        return totalAns;
    }
}
