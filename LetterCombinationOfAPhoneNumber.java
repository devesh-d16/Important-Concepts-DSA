// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> ans = new ArrayList<>();
        if(n == 0 || digits == null){
            return ans;
        }
        String[] phone = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder comb = new StringBuilder();
        lC(0, ans, phone, digits, comb);
        return ans;
    }

    public void lC(int i, List<String> ans, String[] phone, String digits, StringBuilder comb){
        if(i == digits.length()){
            ans.add(comb.toString());
        }        
        else{
            String letters = phone[digits.charAt(i) - '0'];
            for(char letter : letters.toCharArray()){
                comb.append(letter);
                lC(i + 1, ans, phone, digits, comb);
                comb.deleteCharAt(comb.length() - 1);
            }
        }
    }
