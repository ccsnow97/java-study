package com.cc.study.jdk;

/**
 * @Date: 2020/06/29 10:23
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getListNode(int[] arrays){
        if(arrays==null||arrays.length==0) { return null; }
        ListNode head = null;
        ListNode node = null;
        for(int e:arrays){
            ListNode listNode = new ListNode(e);
            if(head==null) {head=listNode;}
            if(node==null){
                node=listNode;
            }else {
                node.next=listNode;
                node=node.next;
            }
        }
        return head;
    }

}
