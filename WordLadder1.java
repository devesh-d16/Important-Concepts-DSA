// A transformation sequence from word beginWord to word endWord using
// a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, 
// and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, 
// or 0 if no such sequence exists.

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

    
public class Pair{
        String first;
        int second;

        public Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }

// toh isme kya krenge humlog ki...sbse phle ek hashset bnayenge and
// usme dict ke word ko store kr lenge
// ab hum jo first word hai usko queue me push krenge with 1(no of steps till now)
// ab word ke first letter ko change krenge a to z tk and if vo dictionary me hoga
// toh us word ko set se hta denge and replace word ko queue me daalenge with step + 1
// ye kind of bfs algo hi hai
// last me if equal aaya endWord ke toh steps return krdenge 
// noi toh 0 if impossible

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();
        int n = wordList.size();
        for(int i = 0; i < n; i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            if(word.equals(endWord) == true){
                return steps;
            }

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char replaceCharArray[] = word.toCharArray();
                    replaceCharArray[i] = ch;
                    String replaceWord = new String(replaceCharArray);
                    if(set.contains(replaceWord) == true){
                        set.remove(replaceWord);
                        q.add(new Pair(replaceWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
