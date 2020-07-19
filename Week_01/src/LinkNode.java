

/**
 * @description: 链表
 * @author: 孙彬
 */

public class LinkNode {
	
	//21.合并两个有序链表
	 public ListNode MergeTwoLists(ListNode l1,ListNode l2){
        ListNode node = new ListNode(-1);
        ListNode prev = node;
        while (l1 != null && l2 != null){
            if (l1.value > l2.value){
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return node.next;
    }
	
	

  static class ListNode {
        int value;
        ListNode next;

        public ListNode(int num) {
            this.value = num;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

}	
	