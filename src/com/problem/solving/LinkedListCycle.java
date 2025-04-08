package com.problem.solving;

// link: https://leetcode.com/problems/linked-list-cycle/?envType=problem-list-v2&envId=linked-list
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast  = head;
        while(fast != null && fast.next != null)    {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)    {
                return true;
            }
        }
        return false;
    }

}

class ListNode  {

    Integer val;
    ListNode next;
    ListNode head;
    ListNode last;

    public ListNode() {}

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public ListNode getLast() {
        return last;
    }

    public void setLast(ListNode last) {
        this.last = last;
    }

    public void insert(int val) {
        var node = new ListNode();
        node.setVal(val);
        if(head == null)    {
            head = node;
            last = node;
        }
        else {
            last.next = node;
            last = last.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
