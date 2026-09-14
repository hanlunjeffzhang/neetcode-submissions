class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<Character, Integer>();
        // Key: Character, Value; lastSeen Index

        int i = 0;
        int j = 0;
        int max = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);
            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= i) {
                i = lastSeen.get(ch) + 1;
            }
            lastSeen.put(ch, j);
            max = Math.max(j - i + 1, max);
            j++;
        }
        return max;
    }
}
