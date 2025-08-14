package com.dsaPrep.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    //LeetCode 46: Permutations
    //TC: O(n!)
    //SC: O(n) for the recursion stack
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean visited[] = new boolean[len];
        permutations(nums,ans,path,visited);
        return ans;
    }

    void permutations(int nums[], List<List<Integer>> ans, List<Integer> path, boolean visited[]){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0 ; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                path.add(nums[i]);
                permutations(nums,ans,path,visited);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = obj.permute(arr);
        System.out.println("All permutations of the array: " + result);
    }
}
