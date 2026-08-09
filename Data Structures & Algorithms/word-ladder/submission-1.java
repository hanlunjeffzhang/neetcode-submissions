class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);

        int count = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                StringBuilder wordSb = new StringBuilder(q.remove());
                for (int w = 0; w < wordSb.length(); w++) {
                    char orig = wordSb.charAt(w);
                    for (int a = 0; a < 26; a++) {
                        wordSb.setCharAt(w, (char)(a + 'a'));
                        String newWord = wordSb.toString();
                        if (wordSet.contains(newWord) && !seen.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return count + 1;
                            }
                            seen.add(newWord);
                            q.add(newWord);
                        }
                    }
                    wordSb.setCharAt(w, orig);
                }
            }
            count++;
        }
        return 0;
    }
}
