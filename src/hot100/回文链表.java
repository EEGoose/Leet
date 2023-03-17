package hot100;

/**
 * @author: EEGoose
 * @since: 2023-02-20 11:11
 */
public class 回文链表 {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (null != fast && null != fast.next) {
                fast = fast.next;
            }
        }

        reserve(slow);

        ListNode p = head;

        while (p != slow) {
            if (p.val != fast.val) {
                return false;
            }
            p = p.next;
            fast = fast.next;
        }

        return true;
    }

    private static void reserve(ListNode s) {
        ListNode o = s;
        ListNode p = s.next;
        if (p == null) {
            return;
        }
        ListNode q = s.next.next;
        p.next = o;
        o.next = null;
        while (q != null) {
            o = p;
            p = q;
            q = q.next;
            p.next = o;
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

    public static void main(String[] args) {
        ListNode five = new ListNode(1);
        ListNode four = new ListNode(2, five);
        ListNode three = new ListNode(2, four);
        ListNode two = new ListNode(1, three);
        ListNode one = new ListNode(1, two);

        System.out.println(isPalindrome(two));
    }
}
