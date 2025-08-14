package com.dsaPrep.strings;

public class LargestOddNumber {
    public String largestOddNumber(String num) {
        //If last char of 'num' is odd ...return entire string.
        if((int) num.charAt(num.length()-1) % 2 == 1) return num;
        int length = num.length()-1;
        while(length >= 0){
            int n = num.charAt(length);
            if(n % 2 == 1){
                return num.substring(0,length+1);
            }
            length--;
        }
        return "";
    }
}
