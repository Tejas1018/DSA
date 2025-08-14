package com.dsaPrep.LinkedLists;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        // Find the tail node and get the length of the LL.
        // Attach the tail node to the original head.
        // Find the (length - k) node.
        // Create new head by kthNode.next
        // Initialize kthNode.next = null.

        // Edge cases
        if(head == null || k == 0) return head;

        int length = 1;
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
            length++;
        }

        if(k % length == 0) return head;
        k = k % length;
        curr.next = head;
        ListNode newTailNode = findTailNode(head,length-k);
        head = newTailNode.next;
        newTailNode.next = null;
        return head;
    }

    ListNode findTailNode(ListNode head,int target){
        target = target-1;
        while(head != null && target > 0){
            head = head.next;
            target--;
        }
        return head;
    }
}
