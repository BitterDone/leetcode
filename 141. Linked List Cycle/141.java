import java.util.HashMap;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    HashMap<Integer, ListNode> record = new HashMap<Integer, ListNode>();
    int foundCycles = 0;
    public boolean hasCycle(ListNode head) {
        if (head == null) { return false; }
        if (head.next == null) { return false; }
        if (foundCycles > 10) { return true; }
        
        ListNode node = record.get(head.val);
        boolean cycle = false;
        if (node != null) {
            cycle = (head.next.val == node.next.val);
        }

        if (cycle) { foundCycles++; }
        
        record.put(head.val, head);
        return hasCycle(head.next);
    }
}