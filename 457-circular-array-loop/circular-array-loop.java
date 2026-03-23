class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i;
            int fast = i;

            // direction of movement
            boolean forward = nums[i] > 0;

            while (true) {
                // move slow by 1 step
                slow = nextIndex(nums, forward, slow);
                if (slow == -1) break;

                // move fast by 2 steps
                fast = nextIndex(nums, forward, fast);
                if (fast == -1) break;

                fast = nextIndex(nums, forward, fast);
                if (fast == -1) break;

                // cycle detected
                if (slow == fast) return true;
            }
        }
        return false;
    }

    private int nextIndex(int[] nums, boolean forward, int current) {
        boolean direction = nums[current] > 0;

        // direction mismatch → invalid
        if (direction != forward) return -1;

        int n = nums.length;
        int next = (current + nums[current]) % n;

        if (next < 0) next += n;

        // self-loop → invalid
        if (next == current) return -1;

        return next;
    }
}