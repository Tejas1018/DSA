package com.dsaPrep.LinkedLists;

public class PalindromicLinkedList {
    // approach: Reverse the second half of the linked list and compare it with the first half.
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseHead = reverse(slow.next);

        ListNode first = temp;
        ListNode second = reverseHead;
        while (second != null) {
            if (first.val != second.val) {
                reverse(reverseHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(reverseHead);
        return true;

    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = null;
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
