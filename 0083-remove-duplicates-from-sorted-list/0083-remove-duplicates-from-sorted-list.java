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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        
        int prevVal = head.val;
        ListNode trav = head;
        
        while (trav.next != null) {
            if (trav.next.val == prevVal)
                trav.next = trav.next.next;
            else {
                trav = trav.next;
                prevVal = trav.val;
            }
        }
        
        return head;
    }
}