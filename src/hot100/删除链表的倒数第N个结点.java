package hot100;

/**
 * @author: EEGoose
 * @since: 2023-03-17 16:28
 */
public class 删除链表的倒数第N个结点 {

    static class ListNode {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = p;
        int m = n;
        while (m != 0) {
            q = q.next;
            if (q == null) {
                return head.next;
            }
            m--;
        }
        while (true) {
            if (q.next == null) {
                p.next = p.next.next;
                return head;
            }
            p = p.next;
            q = q.next;
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = removeNthFromEnd(one, 5);
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
