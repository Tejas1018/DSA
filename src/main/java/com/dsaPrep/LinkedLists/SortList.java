package com.dsaPrep.LinkedLists;

public class SortList {
    public ListNode sortList(ListNode head) {
        // Edge case
        if(head == null || head.next == null) return head;
        ListNode middleNode = findMiddle(head);
        ListNode secondHalf = middleNode.next;
        middleNode.next = null;
        ListNode firstHalf = head;

        firstHalf = sortList(firstHalf);
        secondHalf = sortList(secondHalf);
        return mergeTwoLinkedLists(firstHalf,secondHalf);
    }

    ListNode findMiddle(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        // If the list has odd number of nodes, slow pointer will be at the exact middle
        // If the list has even number of nodes, slow pointer will be at the first middle node
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    ListNode mergeTwoLinkedLists(ListNode firstHalf,ListNode secondHalf){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (firstHalf != null && secondHalf != null){
            if (firstHalf.val <= secondHalf.val) {
                temp.next = firstHalf;
                temp = firstHalf;
                firstHalf = firstHalf.next;
            }
            else {
                temp.next = secondHalf;
                temp = secondHalf;
                secondHalf = secondHalf.next;
            }
        }

        if(firstHalf != null){
            temp.next = firstHalf;
        }

        if (secondHalf != null){
            temp.next = secondHalf;
        }

        return dummy.next;
    }
}
