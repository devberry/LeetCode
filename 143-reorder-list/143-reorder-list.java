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
    public void reorderList(ListNode head) {
        ListNode midNode = findMid(head);
        ListNode nextMid = midNode.next;
        midNode.next = null;
        
        ListNode p1 = head;
        ListNode p2 = reverse(nextMid);
        
        while(p1 != null && p2 != null) {
            ListNode nextP1 = p1.next;
            ListNode nextP2 = p2.next;
            
            p1.next = p2;
            p2.next = nextP1;
            
            p1 = nextP1;
            p2 = nextP2;
        }
    }
    
    //O(n)
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    //O(n)
    private ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;
        
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}

/*
i a single l.l(L0 → L1 → … → Ln - 1 → Ln)
o L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
c The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
e nodes' number == 1

solution
1. 
linked list의 중심을 찾는다(slow fast 이용)
중심 다음부터 끝 노드까지의 방향을 역순으로 뒤집는다
ouput의 순서처럼 바꿔 연결한다

time O(n)
space O(1)

*/