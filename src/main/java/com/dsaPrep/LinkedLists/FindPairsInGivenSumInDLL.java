package com.dsaPrep.LinkedLists;

import java.util.ArrayList;

// TC : O(n) Bicause we traverse the list once
public class FindPairsInGivenSumInDLL {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      RandomNode head) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        RandomNode left = head;
        RandomNode right = findTail(head);
        while(left != null && right != null && left.data < right.data){
            ArrayList<Integer> pair = new ArrayList<>();
            if(left.data + right.data == target){
                pair.add(left.data);
                pair.add(right.data);
                result.add(pair);
                left = left.next;
                right = right.prev;
            }
            else if(left.data + right.data > target){
                right = right.prev;
            }
            else{
                left = left.next;
            }
        }
        return result;
    }
    static RandomNode findTail(RandomNode curr){
        while(curr != null && curr.next != null){
            curr = curr.next;
        }
        return curr;
    }
}
