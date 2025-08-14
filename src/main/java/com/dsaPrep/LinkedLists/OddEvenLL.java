package com.dsaPrep.LinkedLists;

public class OddEvenLL {

    // TC : O(N)
    // SC : O(N)
    public ListNode oddEvenList1(ListNode head) {
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode current = head;
        int index = 1;
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        while(current != null){
            if(index % 2 == 1){
                odd.next = new ListNode(current.val);
                odd = odd.next;
            }
            else{
                even.next = new ListNode(current.val);
                even = even.next;
            }
            current = current.next;
            index++;
        }
        odd.next = evenDummy.next;
        return oddDummy.next;
    }

    // TC : O(N)
    // SC : O(1)
    public ListNode oddEvenList(ListNode head) {
        if(head != null){
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;
            while(even != null && even.next != null){
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }
}
