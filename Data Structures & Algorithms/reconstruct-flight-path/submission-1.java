class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> graph = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<String>());
            }
            graph.get(from).add(to);
        }
        int tCount = tickets.size();
        List<String> path = new ArrayList<String>();
        findPath(graph, "JFK", path);
        Collections.reverse(path);
        return path;
    }

    private void findPath(Map<String, Queue<String>> graph, String current, List<String> path) {
        Queue<String> dest = graph.get(current);
        if (dest != null) {
            while (!dest.isEmpty()) {
                String next = dest.remove();
                findPath(graph, next, path);
            }
        }
        path.add(current);
    }
}
