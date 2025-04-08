package com.problem.solving;

import java.util.HashSet;

public class IntersectionOfTwoLinkedList {
//    my solution
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        HashSet<ListNode> hashSet = new HashSet<>();
//        while(headA != null)    {
//            hashSet.add(headA);
//            headA = headA.next;
//        }
//
//        while(headB!= null) {
//            var isIntersection = hashSet.add(headB);
//            if(!isIntersection) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
//    }

    // trying solution
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)  return null;
        var a = headA;
        var b = headB;
        while(a!=b) {
            a = a ==null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

}
