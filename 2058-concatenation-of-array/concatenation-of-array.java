class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2 * n];

        for(int i = 0; i < 2 * n; i++) {
            ans[i] = nums[i % n];
        }

        System.out.println("array is: " + Arrays.toString(ans)); 
        return ans; 
    }
}
