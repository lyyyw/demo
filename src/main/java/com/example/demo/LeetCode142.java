package com.example.demo;

public class LeetCode142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 =  new  ListNode(2);
        ListNode node2 =  new  ListNode(0);
        ListNode node3 =  new  ListNode(-4);
        head.next= node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        System.out.println(head);
        ListNode listNode1 = detectCycle1(head);


    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        // 添加新的结点
        public void add(int newval) {
            ListNode newNode = new ListNode(newval);
            if(this.next == null)
                this.next = newNode;
            else
                this.next.add(newval);
        }
        // 打印链表
        public void print() {
            System.out.print(this.val);
            if(this.next != null)
            {
                System.out.print("-->");
                this.next.print();
            }
        }
    }
    private static ListNode detectCycle(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode slow = node,fast =node;
        while (fast != null) {
            slow = slow.next;
            if (fast.next !=null) {
                fast = fast.next.next;
            }else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = node;
                while (ptr != slow) {
                    ptr =ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
    public static ListNode detectCycle1(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) {
                fast = head;
                while(fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
