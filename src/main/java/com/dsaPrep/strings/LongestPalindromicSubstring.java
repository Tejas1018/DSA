package com.dsaPrep.strings;

public class LongestPalindromicSubstring {
    // Brute Force Approach
    // TC : O(N^3)
    public String longestPalindrome1(String s) {
        int length = s.length();

        String longest = "";
        for(int i = 0 ; i < length; i++){
            for(int j = i; j < length; j++){
                // If substring is palindrome update longest
                if(palindrom(s.substring(i,j+1))){
                    if((j-i+1) > longest.length()){
                        longest = s.substring(i,j+1);
                    }
                }
            }
        }
        return longest;
    }
    boolean palindrom(String s){
        int left = 0;
        int right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Optimized Approach
    // TC : O(N^2)
    public String longestPalindrome(String s) {
        int length = s.length();
        String result = "";
        for(int i = 0 ; i < length; i++){
            String oddLength = isPalindrome(s,i,i);
            if(oddLength.length() > result.length()){
                result = oddLength;
            }

            String evenLength = isPalindrome(s,i,i+1);
            if(evenLength.length() > result.length()){
                result = evenLength;
            }
        }
        return result;
    }

    String isPalindrome(String s,int left,int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
