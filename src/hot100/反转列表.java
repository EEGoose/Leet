package hot100;

/**
 * @author: EEGoose
 * @since: 2023-02-01 10:18
 */
public class 反转列表 {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        if (q == null) {
            return p;
        }
        p.next = null;
        ListNode x = q.next;

        while (true) {
            q.next = p;
            p = q;
            if (x == null) {
                break;
            }
            q = x;
            x = x.next;
        }
        return q;
    }

    public static void main(String[] args) {
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        ListNode listNode = reverseList(one);
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}