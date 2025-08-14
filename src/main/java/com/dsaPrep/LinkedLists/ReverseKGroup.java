package com.dsaPrep.LinkedLists;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prevNode = null;
        while (curr != null) {
            ListNode kthNode = findKthNode(curr, k);
            // if kth node is null,we dont have kth group just remains as it is
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = curr;
                    break;
                }
            }
            ListNode frontNode = kthNode.next;
            kthNode.next = null;
            reverseLL(curr);
            if (curr == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }
            prevNode = curr;
            curr = frontNode;

        }
        return head;
    }

    ListNode findKthNode(ListNode head, int k) {
        k = k - 1;
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }

    ListNode reverseLL(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode front = null;
        while (curr != null) {
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
}
