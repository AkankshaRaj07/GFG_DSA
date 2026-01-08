class Solution {
    public int countSubarrays(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }

    private int atMost(int[] arr, int k) {
        int left = 0, oddCount = 0;
        int count = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] % 2 != 0) oddCount++;

            while (oddCount > k) {
                if (arr[left] % 2 != 0) oddCount--;
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}
