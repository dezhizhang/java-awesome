package shop.xiaozhi.middleNode;

public class Solution {
    // 链表的中间结点
    // https://leetcode.cn/problems/middle-of-the-linked-list/description/
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}