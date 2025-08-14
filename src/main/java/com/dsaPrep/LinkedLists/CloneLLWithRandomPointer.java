package com.dsaPrep.LinkedLists;

import java.util.HashMap;
import java.util.Map;
class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static class CloneLLWithRandomPointer {
        public RandomNode copyRandomList(RandomNode head) {
            RandomNode curr = head;
            RandomNode prev = null;
            RandomNode newHead = null;
            Map<RandomNode, RandomNode> map = new HashMap<>();
            while (curr != null) {
                // create a new nodes for DeepCopy
                RandomNode newRandomNode = new RandomNode(curr.val);
                // store the curr node ref with newNode ref for plotting random pointer
                map.put(curr, newRandomNode);
                if (newHead == null) {
                    newHead = newRandomNode;
                    prev = newHead;
                } else {
                    prev.next = newRandomNode;
                    prev = newRandomNode;
                }
                curr = curr.next;
            }

            curr = head;
            RandomNode newCurr = newHead;
            while (curr != null) {
                if (curr.random == null) {
                    newCurr.random = null;
                } else {
                    newCurr.random = map.get(curr.random);
                }
                curr = curr.next;
                newCurr = newCurr.next;
            }
            return newHead;
        }
    }
}
