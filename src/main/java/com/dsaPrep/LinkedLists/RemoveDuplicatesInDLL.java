package com.dsaPrep.LinkedLists;

public class RemoveDuplicatesInDLL {
    RandomNode removeDuplicates(RandomNode head) {
        // Code Here.
        RandomNode curr = head;

        while(curr != null && curr.next != null){
            RandomNode frontRandomNode = curr.next;
            while(frontRandomNode != null && curr.data == frontRandomNode.data){
                frontRandomNode = frontRandomNode.next;
            }
            curr.next = frontRandomNode;
            if(frontRandomNode != null){
                frontRandomNode.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
