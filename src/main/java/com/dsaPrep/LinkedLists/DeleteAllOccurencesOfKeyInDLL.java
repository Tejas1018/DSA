package com.dsaPrep.LinkedLists;

public class DeleteAllOccurencesOfKeyInDLL {
    static RandomNode deleteAllOccurOfX(RandomNode head, int x) {
        while(head.data == x){
            head = head.next;
        }
        RandomNode curr = head;

        while(curr!=null){

            //if curr data is 'x'
            if(curr.data==x){
                if(curr.prev!=null){
                    curr.prev.next=curr.next;
                }
                if(curr.next!=null){
                    curr.next.prev=curr.prev;
                }
            }
            curr=curr.next;

        }
        return head;
    }
}
