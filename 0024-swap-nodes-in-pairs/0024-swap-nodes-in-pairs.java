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
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to easily handle the head of the list
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        
        // Traverse while there are at least two nodes left to swap
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // Perform the swap
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            // Move prev forward to the start of the next pair
            prev = first;
        }
        
        return dummy.next;
    }
}