package info.sandroalmeida;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndList {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> nodesList = new ArrayList<>();
        ListNode current = head;
        while(current != null){
            nodesList.add(current);
            current = current.next;
        }

        int indexToRemove = nodesList.size() - n;
        ListNode toRemove = nodesList.get(indexToRemove);
        if(indexToRemove - 1 >= 0){
            ListNode previous = nodesList.get(indexToRemove - 1);
            previous.next = toRemove.next;
        } else{
            head = toRemove.next;
        }
        toRemove.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        ListNode head = removeNthFromEnd(node, 1);
    }
}
