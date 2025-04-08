package com.problem.solving;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if(head == null)    {
            return null;
        }
        var nextNode = head.next;
        while(head != null && nextNode != null) {
            var tmp = nextNode.next;
            if(head.next == nextNode)   {
                head.next =null;
            }
            nextNode.next = head;
            head = nextNode;
            nextNode = tmp;
        }
        return head;
    }

    public static void main(String[] args) {
        var listNode = new ListNode();
        listNode.insert(1);
        listNode.insert(2);
        listNode.insert(3);
        listNode.insert(4);
        listNode.insert(5);
        System.out.println(new ReverseList().reverseList(listNode.head));
    }
}
