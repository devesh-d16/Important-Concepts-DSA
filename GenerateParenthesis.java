// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
  
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gP(ans, 0, 0, "", n);
        return ans;
    }

    public void gP(List<String> ans, int nOpen, int nClose, String s, int n){
        if(s.length() == n*2){
            ans.add(s);
            return;
        }
      
        if(nOpen < n){
            gP(ans, nOpen + 1, nClose, s + "(", n);
        }

        if(nClose < nOpen){
            gP(ans, nOpen, nClose + 1, s + ")", n);
        }
    }
