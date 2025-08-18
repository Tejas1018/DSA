package com.dsaPrep.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates,0,target,new ArrayList<>(),result);
        return result;
    }

    public void findCombinations(int[] nums,int index,int target,List<Integer> current,List<List<Integer>> result){
        // Base condition

        if(index == nums.length){
            if(target == 0){
                result.add(new ArrayList<>(current));
                return;
            }
            return;
        }

        if(nums[index] <= target){
            current.add(nums[index]);
            findCombinations(nums,index,target-nums[index],current,result);
            current.remove(current.size()-1);
        }
        findCombinations(nums,index+1,target,current,result);
    }
}
