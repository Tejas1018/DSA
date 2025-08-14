package com.dsaPrep.LinkedLists;

public class RemoveNthNodeFromEndList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode res = dummy;
        ListNode temp = head;
        for (int i = 0 ; i < n; i++){
            temp = temp.next;
        }
        while(temp != null){
            dummy = dummy.next;
            temp = temp.next;
        }
        dummy.next = dummy.next.next;
        return res.next;
    }
}
