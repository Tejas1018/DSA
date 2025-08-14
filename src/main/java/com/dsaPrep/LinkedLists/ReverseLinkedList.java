package com.dsaPrep.LinkedLists;

public class ReverseLinkedList {
    // Iterative approach to reverse a linked list
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = null;
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            if(temp != null){
                temp = temp.next;
            }
        }
        return prev;
    }

    // Recursive approach to reverse a linked list
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return  newHead;
    }
}
