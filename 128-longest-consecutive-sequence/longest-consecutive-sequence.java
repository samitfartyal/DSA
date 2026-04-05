class Solution {
    public int longestConsecutive(int[] nums) {
      
        int i;
        HashSet<Integer> set= new HashSet<>();
       for(int num:nums){
        set.add(num);
       }
       int longestcount =0;
       for(int num:set){
        if(!set.contains(num-1)){
       int currentnum=num;
       int count=1;
       while(set.contains(currentnum +1)){
        currentnum++;
        count++;
       }
       longestcount =Math.max(longestcount,count);
        }
       }

 return longestcount;
    }
}