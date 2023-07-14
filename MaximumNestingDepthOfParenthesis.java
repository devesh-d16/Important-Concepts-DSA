// A string is a valid parentheses string (denoted VPS) if it meets one of the following:

// It is an empty string "", or a single character not equal to "(" or ")",
// It can be written as AB (A concatenated with B), where A and B are VPS's, or
// It can be written as (A), where A is a VPS.
// We can similarly define the nesting depth depth(S) of any VPS S as follows:

// depth("") = 0
// depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
// depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
// depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
// For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.

// Given a VPS represented as string s, return the nesting depth of s.
  
// Input: s = "(1+(2*3)+((8)/4))+1"
// Output: 3
// Explanation: Digit 8 is inside of 3 nested parentheses in the string.

// Input: s = "(1)+((2))+(((3)))"
// Output: 3

// TC - O(N)
// SC - O(1)

    public int maxDepth(String s) {
        int count = 0;
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
            }
            res = Math.max(res,count);
            if(s.charAt(i) == ')'){
                count--;
            }
        }
        return res; 
    }
// stack use krke
    public int maxDepth(String s) {
        Stack<Character> stk = new Stack<>();
        int maxCount = 0;
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
                stk.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')'){
                maxCount = Math.max(count,maxCount);
                count--;
                stk.pop();
            }
            else{
                continue;
            }
        }
        return maxCount;
    }
