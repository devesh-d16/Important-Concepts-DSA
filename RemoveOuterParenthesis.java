// A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
// For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
// A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
// Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
// Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
 
// Example 1:
// Input: s = "(()())(())"
// Output: "()()()"
// Explanation: 
// The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
// After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

// TC - O(n)
// SC - O(n)
    public String removeOuterParentheses(String s) {
      
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < n; i++){
          // whenever '(' milega we will check ki size > 0 hai and hai toh string pe add krenge and stack pe push krenge
            if(s.charAt(i) == '('){
                if(stk.size() > 0){
                    sb.append(s.charAt(i));
                }
                stk.push(s.charAt(i));
            }
          // whenever ")" milega
          // stack se pop krenge 
          // if size > 0 hua toh string me add krenge 
          // otherwise 0 hua size means it's out parenthesis
            else{
                stk.pop();
                if(stk.size() > 0){
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
