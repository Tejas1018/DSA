package com.dsaPrep.strings;

public class MaxNestingDepthOfParanthesis {
    public int maxDepth(String s) {
        int length = s.length();
        int maxDepth = 0;
        int openParanthesis = 0;
        for(int i = 0 ; i < length; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                openParanthesis++;
                maxDepth = Math.max(maxDepth,openParanthesis);
            }
            else if(ch == ')'){
                openParanthesis--;
            }
        }
        return maxDepth;
    }
    // TC : O(N)
    // SC : O(1)
}
