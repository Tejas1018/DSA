package com.dsaPrep.LinkedLists;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean validate = false;
        int pos = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                validate = true;
                break;
            }
        }
        return validate;
    }
}
