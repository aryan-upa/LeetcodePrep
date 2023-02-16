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
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt((obj) -> obj.val));
		ListNode res = new ListNode(-1);
		ListNode headKeeper = res;

		for (ListNode list : lists) {
            if (list != null)
    			heap.add(list);            
        }

		while (!heap.isEmpty()) {
			res.next = heap.peek();
			ListNode rem = heap.poll();

			if (rem.next != null)
				heap.add(rem.next);
			
			res = res.next;
		}
		
		return headKeeper.next;
	}
}