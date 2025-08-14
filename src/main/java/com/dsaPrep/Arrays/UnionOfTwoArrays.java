package com.dsaPrep.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class UnionOfTwoArrays {

    //----Brute Force Approach----

    // TC : O(n1logN + m1logM) for sorting the arrays
    // SC : O(n1 + m1) for storing the elements in a HashSet
/*    public int[] unionArray(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < len1; i++){
            set.add(nums1[i]);
        }
        for(int i = 0 ;i < len2; i++){
            set.add(nums2[i]);
        }

        int result[] = new int[set.size()];
        int k = 0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            result[k++] = iterator.next();
            iterator.remove();
        }
        return result;
    }*/

    //----Optimized Approach----
    int[] unionArray(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int p1 = 0;
            int p2 = 0;
            List<Integer> list = new ArrayList<Integer>();
            while(p1 < n && p2 < m){
                if(nums1[p1] <= nums2[p2]){
                    if(list.isEmpty() || list.get(list.size()-1) != nums1[p1]){
                        list.add(nums1[p1]);
                    }
                    p1++;
                }
                else{
                    if(list.isEmpty() || list.get(list.size()-1) != nums2[p2]){
                        list.add(nums2[p2]);
                    }
                    p2++;
                }
            }
            while(p1 < n){
                if(list.isEmpty() || list.get(list.size()-1) != nums1[p1]){
                    list.add(nums1[p1]);
                }
                p1++;
            }
            while (p2 < m){
                if(list.isEmpty() || list.get(list.size()-1) != nums2[p2]){
                    list.add(nums2[p2]);
                }
                p2++;
            }
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
    }
    public static void main(String[] args) {
        UnionOfTwoArrays unionOfTwoArrays = new UnionOfTwoArrays();
        int[] nums1 = {1,1, 2, 3, 4,6,7,8,9};
        int[] nums2 = {1,1,3, 4, 5, 6};
        int[] result = unionOfTwoArrays.unionArray(nums1, nums2);

        System.out.print("Union of two arrays: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
