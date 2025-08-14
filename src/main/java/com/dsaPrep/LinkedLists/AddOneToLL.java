package com.dsaPrep.LinkedLists;

public class AddOneToLL {
    public ListNode addOne(ListNode head) {
        int carry = helper(head);
        if(carry == 1){
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    int helper(ListNode head){
        if(head == null){
            return 1;
        }
        int carry = helper(head.next);
        head.val = head.val + carry;
        if(head.val < 10){
            return 0;
        }
        head.val = 0;
        return 1;
    }
}
