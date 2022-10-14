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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        else
            return mergedList(list1, list2);
    }
    
    public ListNode mergedList(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode head = result;

        while (l1 != null || l2 != null) {
            
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    result.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                else {
                    result.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            
            else if (l1 != null) {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            
            result = result.next;
        }

        return head.next;
    }
}