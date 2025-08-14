package com.dsaPrep.strings;

public class ReverseWordInAString {
    //Time Complexity: O(n)
    //Space Complexity: O(n) for result string
    public String reverseWords(String s) {
        int length = s.length();
        StringBuilder result = new StringBuilder();

        for(int i = length-1; i >= 0 ; i--){

            char ch = s.charAt(i);
            if(ch != ' '){
                StringBuilder word = new StringBuilder();
                while(i >= 0 && s.charAt(i) != ' '){
                    word.append(s.charAt(i));
                    i--;
                }
                word = reverse(word);
                result.append(word + " ");
            }
        }
        return result.substring(0,result.length()-1);
    }

    StringBuilder reverse(StringBuilder word){
        int length = word.length();
        StringBuilder result = new StringBuilder();
        for(int i = length-1; i >= 0 ;i--){
            result.append(word.charAt(i));
        }
        return result;
    }
}
