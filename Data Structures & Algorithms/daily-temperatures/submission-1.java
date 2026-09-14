class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temps = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!temps.isEmpty() && temperatures[temps.peek()] < temperatures[i]) {
                int index = temps.pop();
                result[index] = i - index;
            }
            temps.push(i);
        }
        return result;
    }
}
