class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null)
            throw new NullPointerException("Rooms Not Found!");

        if (rooms.size() <= 1)
            return true;
        
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0); // we have the key for room 0 and we are visiting it.
        tryVisitAllRooms(rooms, 0, visited);

        return visited.size() == rooms.size();
    }

    public void tryVisitAllRooms(List<List<Integer>> rooms, int roomNo, HashSet<Integer> visited) {
        for (int key : rooms.get(roomNo)) {
            if (visited.contains(key))
                continue;
            visited.add(key);
            tryVisitAllRooms(rooms, key, visited);
        }
    }
}