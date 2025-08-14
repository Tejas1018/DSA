package com.dsaPrep.strings;

public class ATOI {
    public int myAtoi(String s) {
        int length = s.length();
        if(length == 0) return 0;
        s = s.trim();   // Removes the leading whitespaces
        if(s.length() == 0) return 0;
        int sign = 1;   // if 0th car is '-' update sign with -1
        long ans = 0;
        if(s.charAt(0) == '-') sign = -1;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;    //for boundary condition check
        int i = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;

        while(i < s.length()){
            if(s.charAt(i) == ' ' || !Character.isDigit(s.charAt(i))) break;
            ans = ans * 10 + (s.charAt(i) - '0');
            if(sign == -1 && -1 * ans < min) return min;
            if(sign == 1 && ans > max) return max;

            i++;
        }

        return (int) (sign * ans);
    }
}
