package com.problem.solving;

import java.util.Stack;

// link: https://leetcode.com/problems/valid-parentheses/description/
public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        var valid = true;
        for (int i = 0; i < s.length(); i++) {
            var character = s.charAt(i);
            if(character ==  '(' || character == '{' || character == '[')   {
                stack.add(character);
            }   else {
                if(character == ')' && stack.peek() != '(')    {
                    valid = false;
                    break;
                } else if (character == '}' && stack.pop()!= '{') {
                    valid =false;
                    break;
                }   else if(character == ']' && stack.pop()!= '[') {
                    valid = false;
                    break;
                }
            }
        }
        if(!stack.isEmpty())    {
            return false;
        }
        return valid;
    }

    public static void main(String[] args) {
        var str = "(]";
        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid(str));
    }

}
