package shop.xiaozhi.deleteDuplicates;


// 删除排序链表中的重复元素
// 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
// https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
public class Solution {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode currentNode = head;
        while (null != currentNode.next) {
            if (currentNode.next.val == currentNode.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

