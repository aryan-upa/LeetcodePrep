class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int ini = 0, end = people.length - 1;
        int boatCount = 0;

        while (ini <= end) {
            boatCount += 1;
            if (people[ini] + people[end] <= limit)
                ini += 1;
            end -= 1;
        }

        return boatCount;
    }
}