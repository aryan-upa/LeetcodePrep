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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        
        ListNode trav;
        trav = l1;
        while (trav != null) {
            s1.push(trav);
            trav = trav.next;
        }

        trav = l2;
        while (trav != null) {
            s2.push(trav);
            trav = trav.next;
        }

        ListNode res = null;
        int carry = 0;
        
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int s = s1.pop().val + s2.pop().val + carry;
            ListNode add = new ListNode(s % 10);
            
            add.next = res;
            res = add;

            carry = s / 10;
        }
        
        while (!s1.isEmpty()) {
            int s = s1.pop().val + carry;
            ListNode add = new ListNode(s % 10);
            
            add.next = res;
            res = add;

            carry = s / 10;            
        }
        
        while (!s2.isEmpty()) {
            int s = s2.pop().val + carry;
            ListNode add = new ListNode(s % 10);
            
            add.next = res;
            res = add;

            carry = s / 10;            
        }

        if (carry != 0) {
            ListNode nn = new ListNode(1);
            nn.next = res;
            res = nn;
        }
        
        return res;
    }
}