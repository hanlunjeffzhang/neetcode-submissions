class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int netTotal = 0;
        int current = 0;

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            current += net;
            netTotal += net;
            if (current < 0) {
                current = 0;
                start = (i == gas.length - 1) ? 0 : (i + 1);
            }

        }
        return (netTotal >= 0) ? start : -1;
    }
}
