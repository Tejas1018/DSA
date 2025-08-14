package com.dsaPrep.LinkedLists;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while(t1!=null || t2!=null){
            int sum = carry;
            if(t1!=null) sum = sum+t1.val;
            if(t2!=null) sum = sum+t2.val;
            ListNode newNode = new ListNode(sum%10);
            curr.next = newNode;
            curr = curr.next;
            carry = sum/10;
            if(t1!=null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        return dummy.next;
    }
}
