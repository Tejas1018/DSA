package com.dsaPrep.LinkedLists;

public class DeleteMiddleNodeOfLL {
    public ListNode deleteMiddle(ListNode head) {
        // Edge cases
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow.next == null){
            prev.next = null;
            return head;
        }
        else {
            prev.next = slow.next;
        }

        return head;
    }
}
