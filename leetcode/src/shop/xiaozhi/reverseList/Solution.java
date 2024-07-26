package shop.xiaozhi.reverseList;

//反转链表
//https://leetcode.cn/problems/reverse-linked-list/description/
public class Solution {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = next;
        }
        return preNode;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

