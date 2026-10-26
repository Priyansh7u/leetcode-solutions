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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupEnd = dummy;
        
        while (true) {
            // Check if there are at least k nodes remaining
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k; i++) {
                kthNode = kthNode.next;
                if (kthNode == null) {
                    return dummy.next;
                }
            }
            
            ListNode nextGroupStart = kthNode.next;
            
            // Reverse the current k group
            ListNode prev = nextGroupStart;
            ListNode curr = prevGroupEnd.next;
            while (curr != nextGroupStart) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            
            // Connect the reversed group with the rest of the list
            ListNode firstNodeOfGroup = prevGroupEnd.next;
            prevGroupEnd.next = kthNode;
            prevGroupEnd = firstNodeOfGroup;
        }
    }
}