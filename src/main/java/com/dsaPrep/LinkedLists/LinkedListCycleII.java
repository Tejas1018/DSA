package com.dsaPrep.LinkedLists;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                if (temp == slow)
                    return temp;
            }
        }
        return null;
    }
}
