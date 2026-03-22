class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        int j;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                j = (i+ nums[i])% n;
                result[i]=nums[j];
            }
            else if(nums[i]<0){
                 j = (i+ nums[i])% n;
                 j= (j + n)% n;
                  result[i]=nums[j];
            }
            else{
                result[i]=nums[i];
            }
        }
        return result;
    }
}