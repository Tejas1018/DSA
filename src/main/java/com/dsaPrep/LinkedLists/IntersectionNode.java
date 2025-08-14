package com.dsaPrep.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class IntersectionNode {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Map<ListNode,Integer> map = new HashMap<>();

        while(headA != null){
            map.put(headA,map.getOrDefault(headA,0)+1);
            headA = headA.next;
        }
        ListNode result = null;
        while(headB != null){
            if(map.containsKey(headB)){
                result = headB;
                return result;
            }
            headB = headB.next;
        }
        return result;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = length(headA);
        int sizeB = length(headB);
        int difference = Math.abs(sizeA - sizeB);

        if (sizeA > sizeB) {
            // Shift the head node by differnce times in headA
            for (int i = 0; i < difference; i++) {
                headA = headA.next;
            }
        } else {
            // shift the head node by differnce times in headB
            for (int i = 0; i < difference; i++) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            // Move both nodes ahead
            headA = headA.next;
            headB = headB.next;
        }
        // if by any chance node matches return that node

        return headA;
    }

    int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
