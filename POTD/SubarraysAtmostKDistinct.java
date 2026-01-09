class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        int left = 0;
        int count = 0;
        int distinct = 0;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {

            if (freq.getOrDefault(arr[right], 0) == 0) {
                distinct++;
            }
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);

            while (distinct > k) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0) {
                    distinct--;
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}
