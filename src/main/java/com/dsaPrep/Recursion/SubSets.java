package com.dsaPrep.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current_path = new ArrayList<>();

        generateSubsets(nums,0,current_path,result);
        return result;
    }

    public void generateSubsets(int[] nums, int index, List<Integer> current_path, List<List<Integer>> result){
        // base
        if (index == nums.length){
            result.add(new ArrayList<>(current_path));
            return;
        }

        // 1. not pick the current element
        generateSubsets(nums,index+1,current_path,result);

        // 2. pick the current element
        current_path.add(nums[index]);
        generateSubsets(nums,index+1,current_path,result);

        // while backtracking remove the current element from the current path
        current_path.remove(current_path.size() - 1);
    }
}
