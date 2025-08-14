package com.dsaPrep.strings;

import java.util.Stack;

public class RemoveOuterMostParanthesis {
    //using stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public String removeOuterParenthese0(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < length; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(!stack.isEmpty()){
                    result.append(ch);
                }
                stack.push(ch);
            }
            else{
                // ')'
                stack.pop(); // remove the last character and check if !stack.isEmpty()
                if(!stack.isEmpty()){
                    result.append(ch);
                }

            }
        }
        return result.toString();
    }

    //without using stack
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public String removeOuterParentheses(String s) {
        int length = s.length();
        int open= 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < length; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
                if(open > 1)
                    result.append(ch);
            }
            else{
                if(open > 1){
                    result.append(ch);
                }
                open--;
            }
        }
        return result.toString();
    }
}
