package com.dsaPrep.BinarySearch;

public class KokoEatingBanana {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int length = piles.length;
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i < length; i++)
            {
                max = Math.max(max,piles[i]);
            }
            int left = 1;
            int right = max;
            int ans = 0;
            while(left <= right){
                int mid = left + (right-left)/2;
                if(canEat(piles,mid,h)){
                    ans = mid;
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            return ans;
        }
        boolean canEat(int[] piles, int speed, int h) {
            long hours = 0;
            for (int pile : piles) {
                hours += (pile + speed - 1l) / speed;  // same as ceil(pile / speed)
            }
            return hours <= h;
        }

    }

    public static void main(String[] args) {
        KokoEatingBanana obj = new KokoEatingBanana();
        Solution solution = obj.new Solution();
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(solution.minEatingSpeed(piles, h)); // Output: 4
    }
}
