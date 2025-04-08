package com.problem.solving;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if(head == null)    return null;

        var currentElement = head;
        while(currentElement.next != null) {
            var nextElement = currentElement.next;
            if(nextElement.val == val)  {
                currentElement.next = nextElement.next;
            }   else {
                currentElement = currentElement.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        var listNode = new ListNode();
        listNode.insert(7);
        listNode.insert(7);
        listNode.insert(7);
        listNode.insert(7);
        listNode.insert(4);
        listNode.insert(5);
        listNode.insert(6);
        System.out.println(new RemoveLinkedListElements().removeElements(listNode.head, 6));
    }
}
