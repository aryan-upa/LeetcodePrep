/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode oddH = head;
        ListNode evnH = head.next;

        ListNode ot = head;
        ListNode et = head.next; 

        while (ot != null && et != null) {
            ot.next = et.next;
            ot = ot.next;
            if (ot == null)
                break;
            et.next = ot.next;
            et = et.next;
        }

        ListNode trav = oddH;
        while (trav.next != null)
            trav = trav.next;

        trav.next = evnH;
        return oddH;
    }
}