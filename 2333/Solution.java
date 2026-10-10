
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long operations = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long total = 0;
        for (int d : diff) {
            total += d;
        }

        if (operations >= total) {
            return 0;
        }

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= operations) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int limit = low;
        long answer = 0;
        long used = 0;

        for (int d : diff) {
            if (d > limit) {
                used += d - limit;
                answer += (long) limit * limit;
            } else {
                answer += (long) d * d;
            }
        }

        // Distribute remaining operations by reducing
        // values equal to limit by one.
        long remaining = operations - used;

        answer -= remaining * (2L * limit - 1);

        return answer;
    }
}
