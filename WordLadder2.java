    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        int len = wordList.size();

        for(int i = 0; i < len; i++){
            set.add(wordList.get(i));
        }

        Queue<List<String>> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(list);

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;

        List<List<String>> ans = new ArrayList<>();

        while(!q.isEmpty()){
            List<String> a = q.peek();
            q.remove();


            // erase all words that has been
            // previous levels to transform
            if(a.size() > level){
                level++;
                for(String it : usedOnLevel){
                    set.remove(it);
                }
            }

            String word = a.get(a.size() - 1);
            if(word.equals(endWord)){
                // the first sequence where we reached ends
                if(ans.size() == 0){
                    ans.add(a);
                }
                else if(ans.get(0).size() == a.size()){
                    ans.add(a);
                }
            }

            for(int i = 0; i < word.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord) == true){
                        a.add(replacedWord);
                        // java works by reference
                        ArrayList<String> temp = new ArrayList<>(a);
                        q.add(temp);
                        // mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        a.remove(a.size() - 1);
                    }
                }
            }
        }
        return ans;
    }
